package com.example.springbootonline2.controller;

import com.example.springbootonline2.model.MessageInfo;
import org.aspectj.bridge.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello-one-message")
    public MessageInfo sayHelloOneMessage() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("Hello world, welcome to spring boot");
        return messageInfo;
    }

    @RequestMapping("/hello-messages")
    public List<MessageInfo> sayHelloMessages() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("Hello world, welcome to spring boot");

        List<MessageInfo> messageInfos = new ArrayList<>();
        messageInfos.add(messageInfo);
        return messageInfos;
    }

    @RequestMapping("/hello/{id}")
    public MessageInfo getMessage(@PathVariable String id) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("Message ID: " + id);
        return messageInfo;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public void postMessage(@RequestBody MessageInfo messageInfo) {
        System.out.println("Message: " + messageInfo.getMessage());
    }
}
