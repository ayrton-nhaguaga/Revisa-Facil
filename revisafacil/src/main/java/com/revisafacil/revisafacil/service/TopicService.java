package com.revisafacil.revisafacil.service;


import com.revisafacil.revisafacil.dto.TopicDTO;
import com.revisafacil.revisafacil.model.Topic;
import com.revisafacil.revisafacil.repository.TopicRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(TopicDTO dto){
        Topic topic = new Topic();
        topic.setId(dto.getId());
        topic.setDisciplineId(dto.getDisciplineId());
        topic.setTitle(dto.getTitle());
        topic.setContent(dto.getContent());
        topic.setResources(dto.getResources());
        topic.setCompleted(dto.getCompleted());
        topic.setCreatedAt(dto.getCreatedAt());
        return topicRepository.save(topic);
    }

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Optional<Topic> findById (ObjectId id){
        return topicRepository.findById(id);
    }

    public List<Topic> findByDisciplineId(ObjectId disciplineId){
        return topicRepository.findByDisciplineId(disciplineId);
    }

    public List<Topic> findByTitleContaningIgnoreCase(String title){
        return topicRepository.findByTitleContaningIgnoreCase(title);
    }

    public List<Topic> findByContentIgnoreCase(String content){
        return topicRepository.findByContentIgnoreCase(content);
    }

    public List<Topic> findByCopleted(Boolean completed){
        return topicRepository.findByCopleted(completed);
    }

    public List<Topic> updateTopic(String title, TopicDTO dto){
        List<Topic> existes = topicRepository.findByTitleContaningIgnoreCase(title);

        for (Topic t : existes){
            t.setTitle(dto.getTitle());
            t.setCompleted(dto.getCompleted());
            t.setDisciplineId(dto.getDisciplineId());
            t.setResources(dto.getResources());
            t.setContent(dto.getContent());
            topicRepository.save(t);
        }
        return existes;
    }

    public boolean deleteTopic(String title){
        List<Topic> topics = topicRepository.findByTitleContaningIgnoreCase(title);

        if (!topics.isEmpty()){
            topicRepository.deleteAll(topics);
            return true;
        }
        return false;
    }
}
