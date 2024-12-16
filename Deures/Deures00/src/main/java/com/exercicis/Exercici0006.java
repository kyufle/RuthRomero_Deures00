package com.exercicis;

import java.util.Locale;

public class Exercici0006 {

    public static double calculaEntrada(int numeroAdults, int numNens, int numGrans, String dia) {
        double preuNen = 5;
        double preuFinalAdults=10;
        double preuFinalGentGran=6;
        double compraFinal = 0;

        if (dia.equalsIgnoreCase("dimarts")) {
            double sumaGent = numNens + numeroAdults + numGrans;
            compraFinal = (preuNen*numNens) + (preuFinalAdults*numeroAdults) + (preuFinalGentGran*numGrans);
            double dimarts = (sumaGent + compraFinal) /0.20;
            return dimarts;
        }
        
        else if (dia.equalsIgnoreCase("dijous") && numNens > 0 && numeroAdults > 0){
            double caculEntradaNen = 5/0.50;
            double dijous = (preuFinalAdults+caculEntradaNen);
            return dijous;
        }
        
        compraFinal = (preuNen*numNens) + (preuFinalAdults*numeroAdults) + (preuFinalGentGran*numGrans);
        return compraFinal;
    }

    public static void main(String[] args) {
        System.out.printf(Locale.US,("Cas 1 (2 adults, 2 nens, 1 gran): "+calculaEntrada(2,2, 1, "dimarts")));
        System.out.printf(Locale.US,("Cas 2 (1 adult,  2 nens, 0 grans): "+calculaEntrada(1,2, 0, "dijous")));
        System.out.printf(Locale.US,("Cas 3 (0 adults, 0 nens, 2 grans): "+calculaEntrada(0,0,2, "dissabte")));
        System.out.printf(Locale.US,("Cas 4 (1 adult,  0 nens, 0 grans): "+calculaEntrada(1, 0, 0, "dimenge")));
        System.out.printf(Locale.US,("Cas 5 (1 adult,  3 nens, 4 grans): "+calculaEntrada(1, 3, 4, "dijous")));
        System.out.printf(Locale.US,("Cas 6 (2 adults, 2 nens, 1 gran): "+calculaEntrada(2, 2, 1, "diumenge")));
    }
}
