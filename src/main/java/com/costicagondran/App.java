package com.costicagondran;

import io.github.cdimascio.dotenv.Dotenv;

public class App {

    public static boolean stringEmpty(String str) {
        return (str == null || str.isBlank() || str.isEmpty());
    }

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure()
                .directory("./src/main/resources")
                .load();

        String user = dotenv.get("USER");
        String password = dotenv.get("PASSWORD");

        // Remplacer les valeurs par les arguments au lancement si .env n'existe pas
        // ou n'est pas lu
        if (stringEmpty(user))
            if (args.length < 1) {
                System.err.println(PanicCodes.NO_USER_SPECIFIED.getDescription());
                System.exit(PanicCodes.NO_USER_SPECIFIED.getCode());
            }

        if (stringEmpty(password))
            if (args.length < 2) {
                System.err.println(PanicCodes.NO_PASSWORD_SPECIFIED.getDescription());
                System.exit(PanicCodes.NO_PASSWORD_SPECIFIED.getCode());
            }

        DatabaseManager database = new DatabaseManager(user, password);

        database.connect();
        database.query();
    }
}
