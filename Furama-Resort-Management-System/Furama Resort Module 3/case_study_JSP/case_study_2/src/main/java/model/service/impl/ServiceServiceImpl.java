package model.service.impl;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public boolean update(Service service, int service_id) {
        return serviceRepository.update(service, service_id);
    }

    @Override
    public boolean delete(int service_id) {
        return serviceRepository.delete(service_id);
    }

    @Override
    public List<Service> search(String service_name) {
        return serviceRepository.search(service_name);
    }
}
