package com.revisafacil.revisafacil.controller;


import com.revisafacil.revisafacil.dto.StudySessionDTO;
import com.revisafacil.revisafacil.model.StudySession;
import com.revisafacil.revisafacil.service.StudySessionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studysessions")
public class StudySessionController {

    @Autowired
    private StudySessionService studySessionService;

    @PostMapping
    public ResponseEntity<StudySession> createStudySession(@RequestBody StudySessionDTO dto){
        StudySession studySession = studySessionService.createStudySession(dto);
        return new ResponseEntity<>(studySession, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudySession>> getAll(){
        List<StudySession> studySessions = studySessionService.getdAll();
        return new ResponseEntity<>(studySessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudySession>> getById(@RequestParam ObjectId id){
        Optional<StudySession> studySessions = studySessionService.getById(id);
        return new ResponseEntity<>(studySessions, HttpStatus.OK);
    }

    @GetMapping("/topic-title")
    public ResponseEntity<List<StudySession>> getByTopicTitleContainingIgnoreCase(@RequestParam String title){
        List<StudySession> studySessions = studySessionService.getByTopicTitleContainingIgnoreCase(title);
        return new ResponseEntity<>(studySessions, HttpStatus.OK);
    }

    @GetMapping("/duration")
    public ResponseEntity<List<StudySession>> getByDurationMinutes(@RequestParam int durationMinutes){
        List<StudySession> studySessions = studySessionService.getByDurationMinutes(durationMinutes);
        return new ResponseEntity<>(studySessions, HttpStatus.OK);
    }

    @PutMapping("/title")
    public ResponseEntity<List<StudySession>> updateStudySession(@RequestParam String title,@RequestBody StudySessionDTO dto){
        List<StudySession> updatedList = studySessionService.getByTopicTitleContainingIgnoreCase(title);

        if (updatedList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/title")
    public ResponseEntity<Void> deleteStudySession(@RequestParam String title){
        if (studySessionService.deleteStudySession(title)){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
