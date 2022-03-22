package az.phober.device.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mediaEntityManagerFactory",
        transactionManagerRef = "mediaTransactionManager",
        basePackages = {"az.phober.media"}
)
public class MediaDatabaseConfig {

    @Bean(name = "mediaDataSource")
    @ConfigurationProperties(prefix = "media.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mediaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    mediaEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mediaDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("az.phober.media")
                        .build();
    }

    @Bean(name = "mediaTransactionManager")
    public PlatformTransactionManager mediaTransactionManager(
            @Qualifier("mediaEntityManagerFactory") EntityManagerFactory
                    mediaEntityManagerFactory
    ) {
        return new JpaTransactionManager(mediaEntityManagerFactory);
    }
}