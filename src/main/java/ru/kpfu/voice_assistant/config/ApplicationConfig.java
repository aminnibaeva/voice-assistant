package ru.kpfu.voice_assistant.config;

import java.util.Objects;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class ApplicationConfig {
    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("mail.host"));
        mailSender.setPort(
            Integer.parseInt(Objects.requireNonNull(environment.getProperty("mail.port"))));
        mailSender.setUsername(environment.getProperty("mail.username"));
        mailSender.setPassword(environment.getProperty("mail.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
        props.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable",
            environment.getProperty("mail.smtp.starttls.enable")
        );
        props.put("mail.debug", environment.getProperty("mail.debug"));
        props.put("mail.smtp.ssl.trust", environment.getProperty("mail.smtp.ssl.trust"));

        return mailSender;
    }
}
