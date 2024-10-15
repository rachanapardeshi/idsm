package com.dealersocket.idsm;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.Filter;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.dealersocket.idsm.filters.CorsFilter;
import com.dealersocket.idsm.filters.EventLogHandlerInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

import Validators.CustomStringDeserializer;
import Validators.DataType;
import Validators.DataTypeDeserializer;
import errorHandlers.ConstraintViolationExceptionResolver;
import errorHandlers.DefaultExceptionResolver;
import errorHandlers.HandlerExceptionResolverCompositeWithCause;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;



@SpringBootApplication
@EnableAutoConfiguration(exclude = { RepositoryRestMvcAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableSpringDataWebSupport
@EnableTransactionManagement
public class DealerSocketApplication {

	@Resource
	private Environment env;

	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	@Value("${spring.datasource.username}")
	private String datasourceUsername;
	@Value("${spring.datasource.password}")
	private String datasourcePassword;
	@Value("${spring.datasource.driver-class-name}")
	private String datasourceDriverClassName;
	@Value("${spring.datasource.tomcat.initial-size}")
	private int poolInitialSize;
	@Value("${spring.datasource.tomcat.max-active}")
	private int poolMaxActive;
	@Value("${spring.datasource.tomcat.max-idle}")
	private int poolMaxIdle;
	@Value("${spring.datasource.tomcat.min-idle}")
	private int poolMinIdle;
	@Value("${spring.datasource.tomcat.max-wait}")
	private int poolMaxWaitSeconds;
	@Value("${spring.datasource.tomcat.min-evictable-idle-time-millis}")
	private int poolMinEvictableIdleTimeMillis;
	@Value("${spring.datasource.tomcat.time-between-eviction-runs-millis}")
	private int poolTimeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.tomcat.default-read-only}")
	private boolean poolDefaultReadOnly;
	@Value("${spring.datasource.tomcat.test-on-borrow}")
	private boolean poolTestOnBorrow;
	@Value("${spring.datasource.tomcat.validation-query}")
	private String poolValidationQuery;
	@Value("${spring.datasource.tomcat.validation-query-timeout}")
	private int poolValidationTimeoutSeconds;
	@Value("${spring.datasource.tomcat.remove-abandoned}")
	private boolean poolRemoveAbandoned;
	@Value("${spring.datasource.tomcat.remove-abandoned-timeout}")
	private int poolRemoveAbandonedTimeoutSeconds;
	@Value("${spring.datasource.tomcat.default-transaction-isolation}")
	private int poolTransactionIsolationLevel;

	@Value("${heartbeat.enabled}")
	private boolean heartbeatEnabled;
	@Value("${server.servlet.context-path:}")
	private String servletContextPath;

	@Value("${spring.datasource.tomcat.max-age}")
	private int datasourceMaxAge;
	

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DealerSocketApplication.class, args);

	}
	
	@Bean
	public SessionFactory sessionFactory() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		builder.addProperties(hibernateProperties);
		builder.scanPackages("com.dealersocket.idsm.*");
		return builder.buildSessionFactory();
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		PoolProperties poolProperties = new PoolProperties();
		poolProperties.setInitialSize(poolInitialSize);
		poolProperties.setMaxActive(poolMaxActive);
		poolProperties.setMaxIdle(poolMaxIdle);
		poolProperties.setMinIdle(poolMinIdle);
		poolProperties.setMaxWait(poolMaxWaitSeconds);
		poolProperties.setMinEvictableIdleTimeMillis(poolMinEvictableIdleTimeMillis);
		poolProperties.setTimeBetweenEvictionRunsMillis(poolTimeBetweenEvictionRunsMillis);
		poolProperties.setDefaultReadOnly(poolDefaultReadOnly);
		poolProperties.setTestOnBorrow(poolTestOnBorrow);
		poolProperties.setValidationQuery(poolValidationQuery);
		poolProperties.setValidationQueryTimeout(poolValidationTimeoutSeconds);
		poolProperties.setRemoveAbandoned(poolRemoveAbandoned);
		poolProperties.setRemoveAbandonedTimeout(poolRemoveAbandonedTimeoutSeconds);
		poolProperties.setDefaultTransactionIsolation(poolTransactionIsolationLevel);

		DataSource ds =  new org.apache.tomcat.jdbc.pool.DataSource(poolProperties);

		ds.setUrl(datasourceUrl);
		ds.setUsername(datasourceUsername);
		ds.setPassword(datasourcePassword);
		ds.setDriverClassName(datasourceDriverClassName);
		ds.setMaxAge(datasourceMaxAge);

		return ds;
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI().info(new Info().title("IDSM v1").description("DealerSocket info")
				.version("V1").contact(new Contact().name("Rachana Pardeshi").email("rpardeshi2106@gmail.com")));
	}

	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}


	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
				.indentOutput(Boolean.valueOf(env.getProperty("json_output_indent")))
				.deserializerByType(String.class, new CustomStringDeserializer())
				.deserializerByType(DataType.class, new DataTypeDeserializer())
				.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.featuresToEnable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)
				.serializationInclusion(JsonInclude.Include.NON_NULL)	;

		return builder;
	}

	@Bean
	public MappedInterceptor eventLogInterceptor() {
		MappedInterceptor interceptor = new MappedInterceptor(null,
				new String[] { "/", "/**/*.js", "/**/*.html", "/**/*.css" }, new EventLogHandlerInterceptor());
		return interceptor;
	}


	
	  @Bean public FilterRegistrationBean corsFilter() { 
		  Filter filter = new CorsFilter(); 
		  FilterRegistrationBean registrationBean = new
	      FilterRegistrationBean(filter); registrationBean.setOrder(4);
	      return  registrationBean; 
	      
	  }
	 

	@Bean
	public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
	}
}
