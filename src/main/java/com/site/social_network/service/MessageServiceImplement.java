package com.site.social_network.service;

import com.site.social_network.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImplement implements MessageService {

    public List<Map<String,String>> messages= new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>(){{put("id","1"); put("text","First message");}});
        add(new HashMap<String, String>(){{put("id","2"); put("text","First message");}});
        add(new HashMap<String, String>(){{put("id","3"); put("text","First message");}});
        add(new HashMap<String, String>(){{put("id","4"); put("text","First message");}});
    }};

    @Override
    public Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(message-> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
