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
        topic.setDiscipline(dto.getDiscipline());
        topic.setTitle(dto.getTitle());
        topic.setContent(dto.getContent());
        topic.setResources(dto.getResources());
        topic.setCompleted(dto.getCompleted());
        topic.setCreatedAt(dto.getCreatedAt());
        return topicRepository.save(topic);
    }

    public List<Topic> getAll(){
        return topicRepository.findAll();
    }

    public Optional<Topic> getById (ObjectId id){
        return topicRepository.findById(id);
    }

    public List<Topic> getByDisciplineNameIgnoreCase(String name){
        return topicRepository.findByDisciplineNameIgnoreCase(name);
    }

    public List<Topic> getByTitleContaningIgnoreCase(String title){
        return topicRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Topic> getByContentIgnoreCase(String content){
        return topicRepository.findByContentIgnoreCase(content);
    }

    public List<Topic> getByCompleted(Boolean completed){
        return topicRepository.findByCompleted(completed);
    }

    public List<Topic> updateTopic(String title, TopicDTO dto){
        List<Topic> existes = topicRepository.findByTitleContainingIgnoreCase(title);

        for (Topic t : existes){
            t.setTitle(dto.getTitle());
            t.setCompleted(dto.getCompleted());
            t.setDiscipline(dto.getDiscipline());
            t.setResources(dto.getResources());
            t.setContent(dto.getContent());
            topicRepository.save(t);
        }
        return existes;
    }

    public boolean deleteTopic(String title){
        List<Topic> topics = topicRepository.findByTitleContainingIgnoreCase(title);

        if (!topics.isEmpty()){
            topicRepository.deleteAll(topics);
            return true;
        }
        return false;
    }
}
