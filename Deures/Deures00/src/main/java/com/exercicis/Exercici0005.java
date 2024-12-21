package com.exercicis;


public class Exercici0005 {

    public static boolean isPalindrom(String text) {
        text = normalize(text);
        String texto = "";
        for (int i = text.length()-1;i>=0;i--){
            texto += text.charAt(i);  
        }
        return texto.equals(text);
    }

    public static String normalize(String text) {
        text = text.replaceAll(" ", "").replaceAll("·", "").replaceAll("'", "").toLowerCase();

        String[] accents = {"à","á","è","é","ì","í","ò","ó","ù","ú"};
        String[] canviaAccents = {"a","a","e","e","i","i","o","o","u","u"};
        
        for (int i = 0; i<accents.length-1;i++){
            text.replaceAll(accents[i], canviaAccents[i]);
        }
        
        return text;
    }
   
    public static void main(String[] args) {
        String[] exemples = {
            "Anul·la la lluna",
            "Atrapa la lluna",
            "Atrapa'l o l'aparta",
            "Aparta'l o atrapa'l",
            "No sap pas on",
            "On sap pas qui",
            "Tramaran anar a Mart",
            "A Mart trobaràn art",
            "Un pop nu",
            "Nu pop un"
        };
        for (String text : exemples) {
            boolean esPalindrom = isPalindrom(text);
            System.out.println(text + " (" + (esPalindrom ? "Si" : "No") + ")");
        }
    }
}

