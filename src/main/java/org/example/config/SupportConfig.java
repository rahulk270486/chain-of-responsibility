package org.example.config;

import org.example.model.Ticket;
import org.example.support.SupportHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SupportConfig {

    @Bean
    public SupportHandler<Ticket> initialHandler(List<SupportHandler<Ticket>> handlers){
        if(handlers.isEmpty()){
            throw new RuntimeException("Missing Ticket SupportHandler bean");
        }
        List<SupportHandler<Ticket>> aligned = handlers.stream().sorted((h1,h2)->h1.getPriority()-h2.getPriority()).toList();
        if(aligned.size()>1){
            for(int i=1; i<handlers.size(); i++){
                aligned.get(i-1).setNextHandler(aligned.get(i));
            }
        }
        return aligned.get(0);
    }
}
