package com.exercicis;

import java.util.Scanner;

public class Exercici0004 {

    public static int contaMajuscules(String contrasenya) {
        int contMajusculas = 0;
        char[] contrasenyaChar = contrasenya.toCharArray();
        for (char c : contrasenyaChar){
            if (Character.isUpperCase(c)){
                contMajusculas++;
            }
        }
        return contMajusculas;
    }

    public static int contaMinuscules(String contrasenya) {
        int contMinuscules = 0;
        char[] contrasenyaChar = contrasenya.toCharArray();
        for (char minusculas : contrasenyaChar){
            if (Character.isLowerCase(minusculas)){
                contMinuscules++;
            }
        }
        return contMinuscules;
    }

    public static String validaContrasenya(String contrasenya) {
        if (contrasenya.length() < 8 || contaMinuscules(contrasenya) < 2 || contaMajuscules(contrasenya)<2){
            return "La contrasenya \'"+contrasenya+"\': La contrasenya NO és vàlida";
        }
        return "La contrasenya \'"+contrasenya+"\': La contrasenya és vàlida";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escriu una contrasenya: ");
        String contrasenya = scanner.nextLine();
        System.out.println(validaContrasenya(contrasenya));
        scanner.close();
    }
}
