 
package integration.com.satya;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.BeforeClass;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
 

public class IntegrationTestBase {
    public static final int waitTime = 1000;

    @BeforeClass
    public static void initJndi() throws Exception {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();

        DataSource dataSource = new DataSource();

        Resource resource = new ClassPathResource("/test.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);

        dataSource.setUrl(props.getProperty("spring.datasource.url"));
        dataSource.setDriverClassName(props.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUsername(props.getProperty("spring.datasource.username"));
        dataSource.setPassword(props.getProperty("spring.datasource.password"));

        resource = new ClassPathResource("/application.properties");
        props = PropertiesLoaderUtils.loadProperties(resource);

        builder.bind(props.getProperty("spring.datasource.jndi-name"), dataSource);
        builder.activate();
    }
}