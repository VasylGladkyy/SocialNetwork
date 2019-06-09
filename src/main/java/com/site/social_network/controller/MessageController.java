package com.site.social_network.controller;

import com.site.social_network.service.MessageServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {

@Autowired
MessageServiceImplement messageServiceImplement;

    @GetMapping
    public List<Map<String, String>> list(){
        return messageServiceImplement.messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
        return messageServiceImplement.getMessage(id);
    }



    @PostMapping
    public Map<String,String> create(@RequestBody Map<String,String> message){
        int counter= messageServiceImplement.messages.size();
        message.put("id",String.valueOf(++counter));
        messageServiceImplement.messages.add(message);

        return message;
    }

    @PutMapping("{id}")
    public Map<String,String> update(@PathVariable String id,@RequestBody Map<String,String>message){
        Map<String,String>messageFromDb=messageServiceImplement.getMessage(id);
        messageFromDb.putAll(message);
        messageFromDb.put("id",id);

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> message = messageServiceImplement.getMessage(id);
        messageServiceImplement.messages.remove(message);

    }
}
