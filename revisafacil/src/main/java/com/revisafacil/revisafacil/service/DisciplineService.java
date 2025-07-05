package com.revisafacil.revisafacil.service;

import com.revisafacil.revisafacil.dto.DisciplineDTO;
import com.revisafacil.revisafacil.model.Discipline;
import com.revisafacil.revisafacil.repository.DisciplineRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    public Discipline createDiscipline(DisciplineDTO dto){
        Discipline discipline = new Discipline();
        discipline.setName(dto.getName());
        discipline.setDescription(dto.getDescription());
        discipline.setUserId(dto.getUserId());
        discipline.setColor(dto.getColor());
        discipline.setCreateAt(dto.getCreateAt());
        return disciplineRepository.save(discipline);
    }

    public List<Discipline> getAllDisciplines(){
        return disciplineRepository.findAll();
    }

    public Optional<Discipline> getDisciplineById(ObjectId id){
        return disciplineRepository.findById(id);
    }

    public List<Discipline> getDisciplineByNameIgnoreCase(String name){
        return disciplineRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Discipline> getDisciplineByUserId(ObjectId userId){
        return disciplineRepository.findByUserId(userId);
    }

    public List<Discipline> getDisciplineByDate(LocalDate createAt){
        return disciplineRepository.findByDate(createAt);
    }

    public List<Discipline> updateDisciplineByName(String name, DisciplineDTO dto){
        List<Discipline> existes = disciplineRepository.findByNameContainingIgnoreCase(name);

        for (Discipline d : existes){
            d.setName(dto.getName());
            d.setColor(dto.getColor());
            d.setDescription(dto.getDescription());
            disciplineRepository.save(d);
        }
        return existes;
    }

    public boolean deleteDiscipline(String name){
        List<Discipline> disciplines = disciplineRepository.findByNameContainingIgnoreCase(name);

        if(!disciplines.isEmpty()){
            disciplineRepository.deleteAll(disciplines);
            return  true;
        }
        return false;
    }
}
