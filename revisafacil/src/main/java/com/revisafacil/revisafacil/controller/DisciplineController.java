package com.revisafacil.revisafacil.controller;


import com.revisafacil.revisafacil.dto.DisciplineDTO;
import com.revisafacil.revisafacil.model.Discipline;
import com.revisafacil.revisafacil.service.DisciplineService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody DisciplineDTO dto){
        Discipline discipline = disciplineService.createDiscipline(dto);
        return new ResponseEntity<>(discipline, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines(){
        List<Discipline> disciplines = disciplineService.getAllDisciplines();
        return new ResponseEntity<>(disciplines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Discipline>> getDisciplineById(@RequestParam ObjectId id){
        Optional<Discipline> discipline = disciplineService.getDisciplineById(id);
        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Discipline>> getDisciplineByNameIgnoreCase(@RequestParam String name){
        List<Discipline> disciplines = disciplineService.getDisciplineByNameIgnoreCase(name);
        return new ResponseEntity<>(disciplines, HttpStatus.OK);
    }


    @GetMapping("/create-at")
    public ResponseEntity<List<Discipline>> getDisciplineByDate(@RequestParam LocalDate createAt){
        List<Discipline> disciplines = disciplineService.getDisciplineByDate(createAt);
        return new ResponseEntity<>(disciplines, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Discipline>> updateDisciplineByName(@RequestParam String name, @RequestBody DisciplineDTO dto){
        List<Discipline> updatedList = disciplineService.updateDisciplineByName(name, dto);

        if (updatedList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteDiscipline(@RequestParam String name){
        if (disciplineService.deleteDiscipline(name)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
