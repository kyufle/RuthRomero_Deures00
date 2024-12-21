package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {
        ArrayList<String> nomsAleatoris = new ArrayList<>();
        Random random = new Random();
        if (quantitat > noms.size()){
            throw new IllegalArgumentException("La quantitat no pot ser més gran que "+noms.size()+".");       
        }
        for (int i = 0; i<quantitat;i++){
            int numeroRandom = random.nextInt(noms.size());
            if (!nomsAleatoris.contains(noms.get(numeroRandom))){
                nomsAleatoris.add(noms.get(numeroRandom));
            }
            else{
                i--; //això es fa per si es repeteix qualsevol nom, lo que fa es restar-li un a la variable del iterador.
            }
        }
        return nomsAleatoris;
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        ArrayList<String> nomsAcabenVocalLlista = new ArrayList<>();
        for (String nomsLlista : noms){
            if (nomsLlista.endsWith("a") || nomsLlista.endsWith("e") || nomsLlista.endsWith("i") || nomsLlista.endsWith("o") || nomsLlista.endsWith("u")){
                nomsAcabenVocalLlista.add(nomsLlista);
            }
        }
        return nomsAcabenVocalLlista;
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        ArrayList<String> nomsCompostosLista = new ArrayList<>();
        for (String nomsLlista : noms){
            if (nomsLlista.indexOf(" ") != -1){
                nomsCompostosLista.add(nomsLlista);
            }
        }
        return nomsCompostosLista;
    }

    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));
        System.out.println("Noms escollits a l'atzar: "+escullNomsAleatoris(noms, 5));
        try {
            escullNomsAleatoris(noms, 25);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("Noms que acaben amb vocal: "+nomsAcabenVocal(noms));
        System.out.println("Noms compostos: "+nomsCompostos(noms));       
    }
}
