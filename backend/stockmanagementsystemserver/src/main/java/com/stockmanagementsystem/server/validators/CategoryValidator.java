package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 13/07/2021 - 08:43
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class CategoryValidator {
    public static List<String> validate (CategoryDto categoryDto){
        List<String> errors=new ArrayList<>();
        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de le categpry");
        }
        return errors;
    }
}
