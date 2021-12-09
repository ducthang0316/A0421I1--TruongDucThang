package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private final String EMAIL_REGEX ="^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    private final String REGEX_DATE = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    private final String REGEX_PHONE = "^(090\\d{7}|091\\d{7}|\\(84\\)\\+90\\d{7}|\\(84\\)\\+91\\d{7})$";
    private final String REGEX_ID_CARD = "^(\\d{9}|\\d{12})$";
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public boolean delete(int id) {
        return  customerRepository.delete(id);
    }

    @Override
    public boolean update(int id, Customer customer) {
        return  customerRepository.update(id, customer);
    }

    @Override
    public List<Customer> search(String name, String address, String type) {
        return customerRepository.search(name, address, type);
    }

    @Override
    public Map<String, String> saveWithValidate(Customer customer) {
        Map<String, String> map = new HashMap<>();
        boolean check = true;
        if ("".equals(customer.getEmail())){
            check= false;
            map.put("emailMess" , "Email must not null");
        } else if (!validateEmail(customer.getEmail())){
            check = false;
            map.put("emailMess", "Email is wrong format");
            //validate birthday
        } else if ("".equals(customer.getBirthday())){
            check= false;
            map.put("birthdayMess" , "Birthday must not null");
        } else if (!validateDate(customer.getBirthday())){
            check= false;
            map.put("birthdayMess" , "Birthday is wrong format");
            //validate phone
        } else if ("".equals(customer.getPhone())){
            check= false;
            map.put("phoneMess" , "phone must not null");
        } else if (!validatePhone(customer.getPhone())){
            check= false;
            map.put("phoneMess" , "phone is wrong format");
             //validate phone
        } else if ("".equals(customer.getIdCard())){
            check= false;
            map.put("idCardMess" , "idCard must not null");
        } else if (!validateIdCard(customer.getIdCard())){
            check= false;
            map.put("idCardMess" , "idCard is wrong format");
        }

        if (check){
            customerRepository.save(customer);
        }
        return map;
    }

    // validate data
    public  boolean validateEmail(String email){
        return email.matches(EMAIL_REGEX);
    }
    public  boolean validateDate(String date){
        return date.matches(REGEX_DATE);
    }
    public  boolean validatePhone(String phone){
        return phone.matches(REGEX_PHONE);
    }
    public  boolean validateIdCard(String idCard){
        return idCard.matches(REGEX_ID_CARD);
    }
}
