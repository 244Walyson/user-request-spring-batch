package com.waly.userrequestspringbatch.Step;

import com.waly.userrequestspringbatch.dto.UserDTO;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
public class fetchUserDataAndStoreDbStepConfig {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Value("${chunkSize}")
    private Integer chunkSize;

    @Bean
    public Step fetchUserDataAndStoreDbStep(ItemReader<UserDTO> fetchUserDataReader, JobRepository jobRepository, ItemWriter<UserDTO> insertUserDataDbWriter){
        return new StepBuilder("fetchUserDataAndStoreDbStep", jobRepository)
                .<UserDTO, UserDTO>chunk(chunkSize, transactionManager)
                .reader(fetchUserDataReader)
                .writer(insertUserDataDbWriter)
                .build();
    }
}
