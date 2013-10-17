package vsb.fou.batch.spring;

import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.incrementer.AbstractSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;
import org.springframework.transaction.PlatformTransactionManager;
import vsb.fou.common.InfraConfig;

import javax.sql.DataSource;

/**
 * @author Vegard S. Bye
 */
@Configuration
@InfraConfig
public class TestCtxSpringBatch {

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .addScript("/create-product-table.sql")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public MapJobRepositoryFactoryBean jobRepository() {
        return new MapJobRepositoryFactoryBean(transactionManager());
    }

    @Bean
    public AbstractSequenceMaxValueIncrementer productSequence() {
        return new H2SequenceMaxValueIncrementer(dataSource(), "VSB.PRODUCT_SEQ");
    }

}
