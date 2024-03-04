package ru.kpfu.voice_assistant.security.domain.dto;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ApiModel(description = "Ответ")
public class ResponseDto {

    //    @ApiModelProperty(name = "Код ответа", example = "400")
    private String statusCode;

    //    @ApiModelProperty(name = "Сообщение", example = "Пользователь не найден")
    private String message;
}
