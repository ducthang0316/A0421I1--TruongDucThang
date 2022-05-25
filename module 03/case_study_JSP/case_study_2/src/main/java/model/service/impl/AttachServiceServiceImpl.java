package model.service.impl;

import model.bean.AttachService;
import model.repository.AttachServiceRepository;
import model.repository.impl.AttachServiceRepositoryImpl;
import model.service.AttachServiceService;

import java.util.List;

public class AttachServiceServiceImpl implements AttachServiceService {
    AttachServiceRepository attachServiceRepository = new AttachServiceRepositoryImpl();

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
