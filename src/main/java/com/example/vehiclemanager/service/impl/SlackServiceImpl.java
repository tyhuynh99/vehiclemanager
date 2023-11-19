package com.example.vehiclemanager.service.impl;

import com.example.vehiclemanager.service.SlackService;
import com.slack.api.Slack;
import com.slack.api.SlackConfig;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class SlackServiceImpl implements SlackService {
    private final Slack slack = Slack.getInstance();

    @Value("${slack.url}")
    private String slackUrl;

    @Override
    @Async
    public void sendSlackNotification(String message) {
        Payload payload = Payload.builder()
                .text(message)
                .build();
        try {
            WebhookResponse response = slack.send(slackUrl, payload);
            log.info(response.getMessage());
        } catch (IOException e) {
            log.error("Error when send message to Slack {}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
