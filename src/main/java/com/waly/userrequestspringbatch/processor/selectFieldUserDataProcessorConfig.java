package com.waly.userrequestspringbatch.processor;

import com.waly.userrequestspringbatch.dto.UserDTO;
import com.waly.userrequestspringbatch.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class selectFieldUserDataProcessorConfig {

    private static Logger logger = LoggerFactory.getLogger(selectFieldUserDataProcessorConfig.class);
    private int counter;

    @Bean
    public ItemProcessor<UserDTO, User> selectFieldUserDataProcessor(){
        return new ItemProcessor<UserDTO, User>() {
            @Override
            public User process(UserDTO item) throws Exception {
                User user = new User();
                user.setLogin(item.getLogin());
                user.setAvatarUrl(item.getAvatarUrl());
                user.setName(item.getName());
                logger.info("processing user fields"+ counter + user);
                counter++;
                return user;
            }
        };
    }
}
