package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Fabric;

import java.util.List;

public interface IFabricService {
    List<Fabric> getAllFabrics();
    Fabric getFabricById(long fabricId);
    void addFabric(Fabric fabric);
    void updateFabric(Fabric fabric);
    void deleteFabric(long fabricId);
}
