package com.revisafacil.revisafacil.service;


import com.revisafacil.revisafacil.dto.StudySessionDTO;
import com.revisafacil.revisafacil.model.StudySession;
import com.revisafacil.revisafacil.repository.StudySessionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudySessionService {

    @Autowired
    private StudySessionRepository studySessionRepository;

    public StudySession createStudySession(StudySessionDTO dto){
        StudySession studySession = new StudySession();
        studySession.setId(dto.getId());
        studySession.setUserId(dto.getUserId());
        studySession.setTopic(dto.getTopic());
        studySession.setStartTime(dto.getStartTime());
        studySession.setEndTime(dto.getEndTime());
        studySession.setDurationMinutes(dto.getDurationMinutes());
        return studySessionRepository.save(studySession);
    }

    public List<StudySession> getdAll(){
        return studySessionRepository.findAll();
    }

    public Optional<StudySession> getById(ObjectId id){
        return studySessionRepository.findById(id);
    }


    public List<StudySession> getByTopicTitleContainingIgnoreCase(String title){
        return studySessionRepository.findByTopicTitleContainingIgnoreCase(title);
    }

    public List<StudySession> getByDurationMinutes(int durationMinutes){
        return studySessionRepository.findByDurationMinutes(durationMinutes);
    }

    public List<StudySession> updateStudySession(String title, StudySessionDTO dto){
        List<StudySession> existes = studySessionRepository.findByTopicTitleContainingIgnoreCase(title);

        for (StudySession s : existes){
            s.setTopic(dto.getTopic());
            s.setDurationMinutes(dto.getDurationMinutes());
            s.setStartTime(dto.getStartTime());
            s.setEndTime(dto.getEndTime());
            studySessionRepository.save(s);
        }
        return existes;
    }

    public boolean deleteStudySession(String title){
        List<StudySession> studySessions = studySessionRepository.findByTopicTitleContainingIgnoreCase(title);

        if (!studySessions.isEmpty()){
            studySessionRepository.deleteAll(studySessions);
            return true;
        }
        return false;
    }


}
