package com.waly.userrequestspringbatch.Step;

import com.waly.userrequestspringbatch.dto.UserDTO;
import com.waly.userrequestspringbatch.entities.User;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
public class fetchUserDataAndStoreDbStepConfig {

    @Autowired
    @Qualifier("transactionManagerApp")
    private PlatformTransactionManager transactionManager;

    @Value("${chunkSize}")
    private Integer chunkSize;

    @Bean
    public Step fetchUserDataAndStoreDBStep(ItemReader<UserDTO> fetchUserDataReader,
                                            ItemProcessor<UserDTO, User> selectFieldsUserDataProcessor, ItemWriter<User> insertUserDataDBWriter,
                                            JobRepository jobRepository) {
        return new StepBuilder("fetchUserDataAndStoreDBStep", jobRepository)
                .<UserDTO, User>chunk(chunkSize, transactionManager)
                .reader(fetchUserDataReader)
                .processor(selectFieldsUserDataProcessor)
                .writer(insertUserDataDBWriter)
                .build();
    }

}
