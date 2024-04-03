CREATE TABLE IF NOT EXISTS language_codes
(
    language VARCHAR(100),
    country  VARCHAR(100),
    code     VARCHAR(100),
    CONSTRAINT unique_language_code UNIQUE (language, code, country)
);

INSERT INTO public.language_codes (language, country, code)
VALUES ('Afrikaans', 'South Africa', 'af-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Albanian', 'Albania', 'sq-AL');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Amharic', 'Ethiopia', 'am-ET');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Tunisia', 'ar-TN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Syria', 'ar-SY');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Algeria', 'ar-DZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Bahrain', 'ar-BH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Egypt', 'ar-EG');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Iraq', 'ar-IQ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Israel', 'ar-IL');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Jordan', 'ar-JO');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Kuwait', 'ar-KW');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Lebanon', 'ar-LB');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Mauritania', 'ar-MR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Morocco', 'ar-MA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Oman', 'ar-OM');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Qatar', 'ar-QA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'State of Palestine', 'ar-PS');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Saudi Arabia', 'ar-SA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'Yemen', 'ar-YE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Arabic', 'United Arab Emirates', 'ar-AE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Armenian', 'Armenia', 'hy-AM');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Azerbaijani', 'Azerbaijan', 'az-AZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Basque', 'Spain', 'eu-ES');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Bengali', 'Bangladesh', 'bn-BD');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Bengali', 'India', 'bn-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Bosnian', 'Bosnia and Herzegovina', 'bs-BA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Bulgarian', 'Bulgaria', 'bg-BG');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Burmese', 'Myanmar', 'my-MM');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Catalan', 'Spain', 'ca-ES');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Chinese, Cantonese', 'Traditional Hong Kong', 'yue-Hant-HK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Chinese, Mandarin', 'Traditional, Taiwan', 'zh-TW');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Chinese, Mandarin', 'Simplified, China', 'zh');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Croatian', 'Croatia', 'hr-HR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Czech', 'Czech Republic', 'cs-CZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Danish', 'Denmark', 'da-DK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Dutch', 'Belgium', 'nl-BE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Dutch', 'Netherlands', 'nl-NL');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Ghana', 'en-GH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Hong Kong', 'en-HK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'India', 'en-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Ireland', 'en-IE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Kenya', 'en-KE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'New Zealand', 'en-NZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Nigeria', 'en-NG');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Pakistan', 'en-PK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Philippines', 'en-PH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Singapore', 'en-SG');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'South Africa', 'en-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'United Kingdom', 'en-GB');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Tanzania', 'en-TZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'United States', 'en-US');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Australia', 'en-AU');
INSERT INTO public.language_codes (language, country, code)
VALUES ('English', 'Canada', 'en-CA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Estonian', 'Estonia', 'et-EE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Filipino', 'Philippines', 'fil-PH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Finnish', 'Finland', 'fi-FI');
INSERT INTO public.language_codes (language, country, code)
VALUES ('French', 'Switzerland', 'fr-CH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('French', 'Canada', 'fr-CA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('French', 'France', 'fr-FR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('French', 'Belgium', 'fr-BE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Galician', 'Spain', 'gl-ES');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Georgian', 'Georgia', 'ka-GE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('German', 'Switzerland', 'de-CH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('German', 'Austria', 'de-AT');
INSERT INTO public.language_codes (language, country, code)
VALUES ('German', 'Germany', 'de-DE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Greek', 'Greece', 'el-GR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Gujarati', 'India', 'gu-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Hebrew', 'Israel', 'iw-IL');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Hindi', 'India', 'hi-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Hungarian', 'Hungary', 'hu-HU');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Icelandic', 'Iceland', 'is-IS');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Indonesian', 'Indonesia', 'id-ID');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Italian', 'Italy', 'it-IT');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Italian', 'Switzerland', 'it-CH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Japanese', 'Japan', 'ja-JP');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Javanese', 'Indonesia', 'jv-ID');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Kannada', 'India', 'kn-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Kazakh', 'Kazakhstan', 'kk-KZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Khmer', 'Cambodia', 'km-KH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Kinyarwanda', 'Rwanda', 'rw-RW');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Korean', 'South Korea', 'ko-KR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Lao', 'Laos', 'lo-LA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Latvian', 'Latvia', 'lv-LV');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Lithuanian', 'Lithuania', 'lt-LT');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Macedonian', 'North Macedonia', 'mk-MK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Malay', 'Malaysia', 'ms-MY');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Malayalam', 'India', 'ml-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Marathi', 'India', 'mr-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Mongolian', 'Mongolia', 'mn-MN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Nepali', 'Nepal', 'ne-NP');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Norwegian BokmР“Тђl', 'Norway', 'no-NO');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Persian', 'Iran', 'fa-IR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Polish', 'Poland', 'pl-PL');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Portuguese', 'Portugal', 'pt-PT');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Portuguese', 'Brazil', 'pt-BR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Punjabi', 'Gurmukhi India', 'pa-Guru-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Romanian', 'Romania', 'ro-RO');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Russian', 'Russia', 'ru-RU');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Serbian', 'Serbia', 'sr-RS');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Sinhala', 'Sri Lanka', 'si-LK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Slovak', 'Slovakia', 'sk-SK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Slovenian', 'Slovenia', 'sl-SI');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Southern Sotho', 'South Africa', 'st-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Panama', 'es-PA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Argentina', 'es-AR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Bolivia', 'es-BO');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Chile', 'es-CL');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Colombia', 'es-CO');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Costa Rica', 'es-CR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Dominican Republic', 'es-DO');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Ecuador', 'es-EC');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'El Salvador', 'es-SV');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Guatemala', 'es-GT');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Honduras', 'es-HN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Mexico', 'es-MX');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Nicaragua', 'es-NI');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Paraguay', 'es-PY');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Peru', 'es-PE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Puerto Rico', 'es-PR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Spain', 'es-ES');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'United States', 'es-US');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Uruguay', 'es-UY');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Spanish', 'Venezuela', 'es-VE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Sundanese', 'Indonesia', 'su-ID');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Swahili', 'Tanzania', 'sw-TZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Swahili', 'Kenya', 'sw-KE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Swati', 'Latin, South Africa', 'ss-Latn-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Swedish', 'Sweden', 'sv-SE');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Tamil', 'Singapore', 'ta-SG');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Tamil', 'Sri Lanka', 'ta-LK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Tamil', 'India', 'ta-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Tamil', 'Malaysia', 'ta-MY');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Telugu', 'India', 'te-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Thai', 'Thailand', 'th-TH');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Tsonga', 'South Africa', 'ts-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Tswana', 'Latin, South Africa', 'tn-Latn-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Turkish', 'Turkey', 'tr-TR');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Ukrainian', 'Ukraine', 'uk-UA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Urdu', 'Pakistan', 'ur-PK');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Urdu', 'India', 'ur-IN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Uzbek', 'Uzbekistan', 'uz-UZ');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Venda', 'South Africa', 've-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Vietnamese', 'Vietnam', 'vi-VN');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Xhosa', 'South Africa', 'xh-ZA');
INSERT INTO public.language_codes (language, country, code)
VALUES ('Zulu', 'South Africa', 'zu-ZA');

create table users
(
    id           bigserial primary key,
    confirm_code varchar(255),
    email        varchar(255) not null
        constraint user_unique_email
            unique,
    password     varchar(255) not null,
    role         varchar(255) not null,
    state        varchar(255),
    username     varchar(255) not null
        constraint user_unique_username
            unique
);

CREATE TABLE IF NOT EXISTS application
(
    application_id bigserial primary key,
    user_id        bigint            NOT NULL,
    domain         character varying NOT NULL
);

ALTER TABLE ONLY application
    ADD CONSTRAINT application_user_id FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE IF NOT EXISTS page
(
    page_id        bigserial primary key,
    application_id bigint            NOT NULL,
    page_name      character varying NOT NULL,
    associations   character varying NOT NULL
);

ALTER TABLE ONLY page
    ADD CONSTRAINT application_pages_application_id FOREIGN KEY (application_id) REFERENCES application (application_id);

create table trained_models
(
    model          bytea,
    application_id bigint not null
        constraint trained_models_application_id
            references application
);

create table users_application
(
    application_id bigint not null
        constraint trained_models_application_id
            references application,
    user_id        bigint not null
        constraint user_id_users
            references users
);

create table users_query
(
    user_query_id bigserial primary key,
    query         varchar(255) not null,
    user_id       bigint       not null
        constraint user_id_users
            references users
);