package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Type;

import java.util.List;

public interface ITypeService {
    List<Type> getAllTypes();
    Type getTypeById(long typeId);
    void addType(Type type);
    void updateType(Type type);
    void deleteType(long typeId);
}
