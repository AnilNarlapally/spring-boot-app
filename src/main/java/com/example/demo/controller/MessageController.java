package com.example.demo.controller;

import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    @Qualifier("smsService")
    private MessageService messageService;

    public MessageController(Map<String, MessageService> messageServiceMap) {
        this.messageServiceMap = messageServiceMap;
    }

    @GetMapping("/msg1")
    public String getMessage() {
        return messageService.getMessage();
    }

    @GetMapping("/msg2")
    public String getTextMessage() {
        return messageService.getMessage();
    }

    private final Map<String, MessageService> messageServiceMap;



    @GetMapping("/{type}")
    public String getCustomMessage(@PathVariable("type") String messageServiceName) {

        MessageService service = messageServiceMap.get(messageServiceName);
        if(service != null) {
            return service.getMessage();
        }
        return "object type is invalid";
    }
}
