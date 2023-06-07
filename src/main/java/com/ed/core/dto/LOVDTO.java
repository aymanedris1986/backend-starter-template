package com.ed.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LOVDTO {
    @Size(max = 50)
    private String id;
    @Size(max = 500)
    @NotNull
    private String name;
}
