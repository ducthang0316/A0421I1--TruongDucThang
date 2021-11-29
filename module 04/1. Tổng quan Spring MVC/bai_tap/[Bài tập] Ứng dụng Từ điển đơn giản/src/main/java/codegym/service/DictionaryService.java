package codegym.service;

import org.springframework.stereotype.Service;

@Service
public interface DictionaryService {
    String find(String word);
}
