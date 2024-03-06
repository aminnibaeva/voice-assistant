package ru.kpfu.voice_assistant.config;

import java.time.format.DateTimeFormatter;

public class ApplicationConstants {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(
        "HH:mm dd.MM.uuuu");

    public static final DateTimeFormatter BIRTH_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(
        "dd.MM.uuuu");

    public static final String SUBJECT_FOR_RECOVERY_PASSWORD_MAIL = "Восстановление пароля";

    public static final String SUBJECT_FOR_VERIFY_ACCOUNT_MAIL = "Подтверждение email адреса";

    public static final String FREEMARKER_TEMPLATE_PATH = "/templates";

    public static final String FREEMARKER_RECOVERY_PASSWORD_TEMPLATE_NAME = "recovery_password.ftlh";

    public static final String FREEMARKER_VERIFY_ACCOUNT_TEMPLATE_NAME = "confirm_mail.ftlh";

    public static final String TOKEN_EXPIRED_EXCEPTION_REFRESH_TOKEN_OVERDUE_MESSAGE = "Токен обновления просрочен, войдите в приложение заново.";

    public static final String TOKEN_EXPIRED_EXCEPTION_ACCESS_TOKEN_OVERDUE_MESSAGE = "Токен доступа просрочен, обновите токены.";

}
