package ru.kpfu.voice_assistant.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import static ru.kpfu.voice_assistant.config.ApplicationConstants.FREEMARKER_RECOVERY_PASSWORD_TEMPLATE_NAME;
import static ru.kpfu.voice_assistant.config.ApplicationConstants.FREEMARKER_TEMPLATE_PATH;
import static ru.kpfu.voice_assistant.config.ApplicationConstants.FREEMARKER_VERIFY_ACCOUNT_TEMPLATE_NAME;

@RequiredArgsConstructor
@Component
public class EmailUtil {

    private final JavaMailSender javaMailSender;

    @Value("${mail.username}")
    private String from;

    public void sendRecoveryPasswordMail(String to, String subject, Map<String, String> data) {
        sendMail(to, subject, data, FREEMARKER_RECOVERY_PASSWORD_TEMPLATE_NAME);
    }

    public void sendVerifyMail(String to, String subject, Map<String, String> data) {
        sendMail(to, subject, data, FREEMARKER_VERIFY_ACCOUNT_TEMPLATE_NAME);
    }

    private void sendMail(String to, String subject, Map<String, String> data,
        String templateName) {
        Configuration configuration = prepareConfiguration();

        configuration.setClassForTemplateLoading(EmailUtil.class, FREEMARKER_TEMPLATE_PATH);

        String string;
        try {
            Template template = configuration.getTemplate(templateName);

            StringWriter stringWriter = new StringWriter();
            template.process(prepareData(data), stringWriter);

            string = stringWriter.toString();

        }
        catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setSubject(subject);
            messageHelper.setTo(to);
            messageHelper.setFrom(from);
            messageHelper.setText(string, true);
        };

        javaMailSender.send(preparator);
    }

    private Configuration prepareConfiguration() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        return configuration;
    }


    private Map<String, Object> prepareData(Map<String, String> freemarkerData) {
        Map<String, Object> data = new HashMap<>();
        data.put("data", freemarkerData);
        return data;
    }

}
