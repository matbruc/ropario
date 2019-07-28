package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Type;
import com.matbruc.ropario.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getAllTypes() {
        List<Type> list = new ArrayList<>();
        typeRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Type getTypeById(long typeId) {
        return typeRepository.findById(typeId).get();
    }

    @Override
    public void addType(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void updateType(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void deleteType(long typeId) {
        typeRepository.delete(getTypeById(typeId));
    }
}
