package com.stockmanagementsystem.server.handlers;
import java.util.ArrayList;
import java.util.List;

import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @Created 15/07/2021 - 09:08
 * @Package com.stockmanagementsystem.server.handlers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;

    private ErrorCodes code;

    private String message;

    private List<String> errors = new ArrayList<>();

}

