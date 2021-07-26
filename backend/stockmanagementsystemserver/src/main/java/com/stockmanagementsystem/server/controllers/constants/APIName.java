package com.stockmanagementsystem.server.controllers.constants;

/**
 * @Created 22/07/2021 - 13:32
 * @Package com.stockmanagementsystem.server.controllers.constants
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class APIName {
    public static final String APP_ROOT = "gestiondestock/v1";

    public static final String AUTHENTICATE=APP_ROOT+"/authenticate";

    public static final String ARTICLES="/articles";
    public static final String ARTICLE_PATH_VARIABLE_ID ="id";
    public static final String ARTICLE_PATH_VARIABLE_CODE ="code";
    public static final String ARTICLE_PATH_ID ="/{id}";
    public static final String ARTICLE_PATH_CODE ="/{code}";

    public static final String CATEGORY="/categories";
    public static final String CATEGORY_PATH_VARIABLE_ID ="id";
    public static final String CATEGORY_PATH_VARIABLE_CODE ="code";
    public static final String CATEGORY_PATH_ID ="/{id}";
    public static final String CATEGORY_PATH_CODE ="/{code}";

    public static final String CLIENT="/clients";
    public static final String CLIENT_PATH_VARIABLE_ID ="id";
    public static final String CLIENT_PATH_VARIABLE_CODE ="code";
    public static final String CLIENT_PATH_ID ="/{id}";
    public static final String CLIENT_PATH_CODE ="/{code}";

    public static final String COMMANDE_CLIENT="/commandeclients";
    public static final String COMMANDE_CLIENT_PATH_VARIABLE_ID ="id";
    public static final String COMMANDE_CLIENT_PATH_VARIABLE_CODE ="code";
    public static final String COMMANDE_CLIENT_PATH_ID ="/{id}";
    public static final String COMMANDE_CLIENT_PATH_CODE ="/{code}";

    public static final String FOURNISSEUR="/fournisseurs";
    public static final String FOURNISSEUR_PATH_VARIABLE_ID ="id";
    public static final String FOURNISSEUR_PATH_VARIABLE_CODE ="code";
    public static final String FOURNISSEUR_PATH_ID ="/{id}";
    public static final String FOURNISSEUR_PATH_CODE ="/{code}";

    public static final String COMMANDE_FOURNISSEUR="/commandefournisseurs";
    public static final String COMMANDE_FOURNISSEUR_PATH_VARIABLE_ID ="id";
    public static final String COMMANDE_FOURNISSEUR_PATH_VARIABLE_CODE ="code";
    public static final String COMMANDE_FOURNISSEUR_PATH_ID ="/{id}";
    public static final String COMMANDE_FOURNISSEUR_PATH_CODE ="/{code}";


    public static final String ENTREPRISE="/entreprises";
    public static final String ENTREPRISE_PATH_VARIABLE_ID ="id";
    public static final String ENTREPRISE_PATH_VARIABLE_CODE ="code";
    public static final String ENTREPRISE_PATH_ID ="/{id}";
    public static final String ENTREPRISE_PATH_CODE ="/{code}";


    public static final String VENTES="/ventes";
    public static final String VENTES_PATH_VARIABLE_ID ="id";
    public static final String VENTES_PATH_VARIABLE_CODE ="code";
    public static final String VENTES_PATH_ID ="/{id}";
    public static final String VENTES_PATH_CODE ="/{code}";

    public static final String UTILISATEUR="/utilisateur";
    public static final String UTILISATEUR_PATH_VARIABLE_ID ="id";
    public static final String UTILISATEUR_PATH_VARIABLE_CODE ="code";
    public static final String UTILISATEUR_PATH_ID ="/{id}";
    public static final String UTILISATEUR_PATH_CODE ="/{code}";
}
