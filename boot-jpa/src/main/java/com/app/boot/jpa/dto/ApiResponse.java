package com.app.boot.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Anish
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private String apiMessage;
}
