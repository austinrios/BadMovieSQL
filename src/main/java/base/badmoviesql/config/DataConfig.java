package base.badmoviesql.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.sql.DataSource;
import java.util.List;

import static base.badmoviesql.config.ConfigConstants.*;

/**
 * The @Configuration annotation is a type of Component, therefor will be automatically scanned, instantiated, and
 * managed by the Spring Container.  This component is used to configure individual beans for your custom code, services,
 * beans, or other uses.  Additionally, this configuration is used to enable other processes which will scan other types
 * of beans to be managed by the spring container to prepare for processing.
 *
 * @MapperScan works similarly to @ComponentScan, except it is looking for ...Mapper.java interfaces specifically.
 * @ImportResource imports a resource file into the spring context, in this case the Transaction-Config.xml, as some of
 * those configurations do not have java analogs, and require XML definitions.
 * @EnableAspectJAutoProxy Enables the use of aspectj autoproxying for spring AOP advices.  This allows your AOP code to
 * be managed by the spring container, and with the use of @Component annotations scanned to remove your need for them
 * to be explicitly declared in a file similar to this one.  In addition to easing the use of management, this
 * annotation allows the use of spring managed proxying of target objects, which reduces the complexity of integrating
 * AspectJ code with java spring code.
 */

@Configuration
@MapperScan({"base.badmoviesql.dao.mapper"})
@ImportResource("classpath:/transaction-config.xml")
@EnableAspectJAutoProxy()
public class DataConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(JDBC_DRIVER_CLASS_NAME));
        dataSource.setUrl(env.getProperty(JDBC_URL));
        dataSource.setUsername(env.getProperty(JDBC_USERNAME));
        dataSource.setPassword(env.getProperty(JDBC_PASSWORD));


        // This applies only if ehcache is enabled for MyBatis.
        // Related to DAO is the ehcache cache management which for some reason,
        // checks for updates (and collects OS architecture data) during initialization.
        // Ridiculous!!! Disable the check.
        System.setProperty("net.sf.ehcache.skipUpdateCheck", "true");

        return dataSource;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setPrettyPrint(true);

        ObjectMapper mapper = converter.getObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false); // ISO8601 date/time format

        return converter;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
