package com.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrudResponseDto implements Serializable {

    private String timeStamp;

    private String status;

    private String message;

}
