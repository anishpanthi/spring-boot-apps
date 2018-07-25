package com.app.boot.swagger2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse implements Serializable {

    @Builder.Default
    private Integer status = 200;

    @Builder.Default
    private boolean isError = false;

}
