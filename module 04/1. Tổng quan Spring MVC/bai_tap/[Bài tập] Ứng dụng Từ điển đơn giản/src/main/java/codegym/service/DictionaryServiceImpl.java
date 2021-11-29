package codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Override
    public String find(String word) {

            Map<String, String> wordList = new HashMap<>();
            wordList.put("hello", "xin chao");
            wordList.put("how", "lam the nao");
            wordList.put("phone", "dien thoai");
            wordList.put("laptop", "may tinh xach tay");
            wordList.put("water", "nuoc");
            wordList.put("clothes", "quan ao");
            wordList.put("door", "cai cua");

       for (Map.Entry<String, String> entry : wordList.entrySet()){
           if (word.equals(entry.getKey())){
               return entry.getValue();
           }
       }
        return null;
    }
}
