package pl.config;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@AllArgsConstructor
public class ValidationMessageConfig extends WebMvcConfigurationSupport {
  private MessageSource messageSource;

  @Override
  public Validator getValidator () {
    LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
    factory.setValidationMessageSource(messageSource);
    return factory;
  }

  @Bean
  public LocalValidatorFactoryBean mvcValidator (MessageSource messageSource) {
    LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
    factory.setValidationMessageSource(messageSource);
    return factory;
  }
}
