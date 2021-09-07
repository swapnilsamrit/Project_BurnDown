package com.burn.com.burn.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class RestConsumer {
    @Autowired
    ConsumerService consumerService;

    private static RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/consume")
    public void get() {
        String url = "https://api.hubapi.com/contacts/v1/lists/all/contacts/all?hapikey=eu1-766c-7f2a-41ed-b52b-f227a0ea111d";
        String response = restTemplate.getForObject(url, String.class);
        consumerService.insert(response);
    }
}
