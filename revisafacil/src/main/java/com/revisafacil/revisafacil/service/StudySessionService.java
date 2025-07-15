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
        studySession.setTopicId(dto.getTopicId());
        studySession.setStartTime(dto.getStartTime());
        studySession.setEndTime(dto.getEndTime());
        studySession.setDurationMinutes(dto.getDurationMinutes());
        return studySessionRepository.save(studySession);
    }

    public List<StudySession> findAll(){
        return studySessionRepository.findAll();
    }

    public Optional<StudySession> findById(ObjectId id){
        return studySessionRepository.findById(id);
    }

    public List<StudySession> findByUserId(ObjectId userId){
        return studySessionRepository.findByUserId(userId);
    }

    public List<StudySession> findByTopicId(ObjectId topicId){
        return studySessionRepository.findByTopicId(topicId);
    }

    public List<StudySession> findByDurationMinutes(int durationMinutes){
        return studySessionRepository.findByDurationMinutes(durationMinutes);
    }

    public List<StudySession> updateStudySession(ObjectId topicId, StudySessionDTO dto){
        List<StudySession> existes = studySessionRepository.findByTopicId(topicId);

        for (StudySession s : existes){
            s.setTopicId(dto.getTopicId());
            s.setDurationMinutes(dto.getDurationMinutes());
            s.setStartTime(dto.getStartTime());
            s.setEndTime(dto.getEndTime());
            studySessionRepository.save(s);
        }
        return existes;
    }

    public boolean deleteStudySession(ObjectId topicId){
        List<StudySession> studySessions = studySessionRepository.findByTopicId(topicId);

        if (!studySessions.isEmpty()){
            studySessionRepository.deleteAll(studySessions);
            return true;
        }
        return false;
    }


}
