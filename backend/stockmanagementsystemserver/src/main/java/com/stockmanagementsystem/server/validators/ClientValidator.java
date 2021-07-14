package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 11:49
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class ClientValidator {

    public static List<String> validate (ClientDto clientDto){
        List<String> errors=new ArrayList<>();

        if(clientDto == null){
            errors.add("Veuillez renseigner le nom");
            errors.add("Veuillez renseigner le prenom");
            errors.add("Veuillez renseigner l'email");
            errors.add("Veuillez renseigner l'address");
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("Veuillez renseigner la nom");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("Veuillez renseigner la prenom");
        }
        if (!StringUtils.hasLength(clientDto.getEmail())) {
            errors.add("Veuillez renseigner l'email");
        }
        if (clientDto.getAddress()== null) {
            errors.add("Veuillez renseigner l'address");
        }

        return errors;
    }
}
