package vsb.fou.batch.spring;

import org.mockito.Mockito;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.support.incrementer.AbstractSequenceMaxValueIncrementer;
import org.springframework.transaction.PlatformTransactionManager;
import vsb.fou.common.InfraConfig;

import javax.sql.DataSource;

/**
 * @author Vegard S. Bye
 */
@Configuration
@InfraConfig
public class MockCtxSpringBatch {

    @Bean
    public TaskExecutor taskExecutor() {
        return Mockito.mock(TaskExecutor.class);
    }

    @Bean
    public DataSource dataSource() {
        return Mockito.mock(DataSource.class);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return Mockito.mock(PlatformTransactionManager.class);
    }

    @Bean
    public JobRepository jobRepository() {
        return Mockito.mock(JobRepository.class);
    }

    @Bean
    public AbstractSequenceMaxValueIncrementer productSequence() {
        return Mockito.mock(AbstractSequenceMaxValueIncrementer.class);
    }
}
