package com.exercicis;

import java.util.ArrayList;
import java.util.Random;

public class Exercici0010 {

    public static ArrayList<Integer> generarNumerosAleatoris(int quantitat, int min, int max) {
        Random random = new Random();
        ArrayList<Integer> arr =new ArrayList<>();
        for (int i = 0; i < quantitat;i++){
            arr.add(random.nextInt(min,max));
        }
        return arr;
    }

    public static ArrayList<Integer> multiplicarPerDos(ArrayList<Integer> llista) {
        ArrayList<Integer>resultatmultiplicar= new ArrayList<>();
        for (int numbers : resultatmultiplicar){
            resultatmultiplicar.add((numbers * 2));
        }
        return resultatmultiplicar;
    }

    public static ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista) {
        /*
            TODO: Resol aquí la funció
        */
        return new ArrayList<>();
    }

    public static ArrayList<Double> dividirPerDos(ArrayList<Integer> llista) {
        /*
            TODO: Resol aquí la funció
        */
        return new ArrayList<>();
    }

    public static void main(String[] args) {

        /*
            TODO: Resol aquí l'exercici
        */
    }
}
