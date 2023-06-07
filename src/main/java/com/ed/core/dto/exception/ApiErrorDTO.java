package com.ed.core.dto.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiErrorDTO {
    private String errorCode;
    private String errorMessage;
}
