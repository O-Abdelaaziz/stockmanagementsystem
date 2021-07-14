package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 12:01
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto commandeClientDto) {
        List<String> errors = new ArrayList<>();
        if (commandeClientDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeClientDto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (commandeClientDto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (commandeClientDto.getClientDto() == null || commandeClientDto.getClientDto().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }
}
