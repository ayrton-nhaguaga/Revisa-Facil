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
        discipline.setDate(dto.getDate());
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

    public List<Discipline> getDisciplineByDate(LocalDate date){
        return disciplineRepository.findByDate(date);
    }

}
