package model.service.impl;

import model.bean.RentType;
import model.repository.RentTypeRepository;
import model.repository.impl.RentTypeRepositoryImpl;
import model.service.RentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
