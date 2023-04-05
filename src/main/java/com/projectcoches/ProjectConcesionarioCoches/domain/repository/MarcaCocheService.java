package com.projectcoches.ProjectConcesionarioCoches.domain.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.pojo.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.domain.service.IMarcaCocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MarcaCocheService implements IMarcaCocheService {

    private final IMarcaCocheRepository iMarcaCocheRepository;

    @Override
    public List<MarcaCochePojo> getAll() {
        return iMarcaCocheRepository.getAll();
    }

    @Override
    public Optional<MarcaCochePojo> getMarcaCoche(Integer id) {
        return iMarcaCocheRepository.getMarcaCoche(id);
    }

    @Override
    public MarcaCochePojo save(MarcaCochePojo newMarcaCoche) {
        return iMarcaCocheRepository.save(newMarcaCoche);
    }

    @Override
    public boolean delete(Integer idMarcaCoche) {
        try{
            iMarcaCocheRepository.delete(idMarcaCoche);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
