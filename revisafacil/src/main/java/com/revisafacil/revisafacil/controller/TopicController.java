package com.revisafacil.revisafacil.controller;

import com.revisafacil.revisafacil.dto.TopicDTO;
import com.revisafacil.revisafacil.model.Topic;
import com.revisafacil.revisafacil.service.TopicService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody TopicDTO dto){
        Topic topic = topicService.createTopic(dto);
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAll(){
        List<Topic> topics = topicService.getAll();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Topic>> getById (@RequestParam ObjectId id){
        Optional<Topic> topic = topicService.getById(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping("/discipline_name")
    public ResponseEntity<List<Topic>> getByDisciplineName(@RequestParam String name){
        List<Topic> topics = topicService.getByDisciplineNameIgnoreCase(name);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Topic>> getByTitleContaningIgnoreCase(@RequestParam String title){
        List<Topic> topics = topicService.getByTitleContaningIgnoreCase(title);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/content")
    public ResponseEntity<List<Topic>> getByContentIgnoreCase(@RequestParam String content){
        List<Topic> topics = topicService.getByContentIgnoreCase(content);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Topic>> getByCopleted(@RequestParam Boolean completed){
        List<Topic> topics = topicService.getByCompleted(completed);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @PutMapping("/title")
    public ResponseEntity<List<Topic>> updateTopic(@RequestParam String title, @RequestBody TopicDTO dto){
        List<Topic> updatedList = topicService.updateTopic(title, dto);

        if (updatedList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/title")
    public ResponseEntity<Void> deleteTopic(@RequestParam String title){
        if (topicService.deleteTopic(title)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
