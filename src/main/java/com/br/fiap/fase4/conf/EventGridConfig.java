package com.br.fiap.fase4.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.eventgrid.EventGridEvent;
import com.azure.messaging.eventgrid.EventGridPublisherClient;
import com.azure.messaging.eventgrid.EventGridPublisherClientBuilder;

@Configuration
public class EventGridConfig {

    @Bean
    public EventGridPublisherClient<EventGridEvent> eventGridClient() {

        return new EventGridPublisherClientBuilder()
                .endpoint("https://evaluation-topic.brazilsouth.eventgrid.azure.net/api/events")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildEventGridEventPublisherClient();
    }
}