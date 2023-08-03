package com.waly.userrequestspringbatch.writer;

import com.waly.userrequestspringbatch.dto.UserDTO;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class insertUserDataDbWriterConfig {

    @Bean
    public ItemWriter<UserDTO> insertUserDataDbWriter(){
        return users -> users.forEach(System.out::println);
    }
}
