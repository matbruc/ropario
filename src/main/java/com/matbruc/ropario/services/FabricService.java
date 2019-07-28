package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Fabric;
import com.matbruc.ropario.repositories.FabricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricService implements IFabricService {

    @Autowired
    private FabricRepository fabricRepository;

    @Override
    public List<Fabric> getAllFabrics() {
        List<Fabric> list = new ArrayList<>();
        fabricRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Fabric getFabricById(long fabricId) {
        return fabricRepository.findById(fabricId).get();
    }

    @Override
    public void addFabric(Fabric fabric) {
        fabricRepository.save(fabric);
    }

    @Override
    public void updateFabric(Fabric fabric) {
        fabricRepository.save(fabric);
    }

    @Override
    public void deleteFabric(long fabricId) {
        fabricRepository.delete(getFabricById(fabricId));
    }
}
