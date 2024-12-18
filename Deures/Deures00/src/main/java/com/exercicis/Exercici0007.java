package com.exercicis;

import java.util.Locale;

public class Exercici0007 {

    public static double calculaCostLloc(String tipusLloc) {
        double sala = 0;
        if (tipusLloc.equalsIgnoreCase("sala estàndard")){
            sala = 100;
            return sala;
        }
        else if (tipusLloc.equalsIgnoreCase("jardí amb piscina")){
            sala = 200;
            return sala;
        }
        else if (tipusLloc.equalsIgnoreCase("saló gran amb escenari")){
            sala = 500;
            return sala;   
        }
        throw new IllegalArgumentException("Tipus de lloc desconegut: "+tipusLloc);
    }

    public static double calculaCostMenjar(String tipusMenjar, int numConvidats) {
        double menjar;
        if (tipusMenjar.equalsIgnoreCase("menú bàsic")){
            menjar = 15;
            menjar = menjar * numConvidats;
            if (numConvidats > 50){
                double preuFinal = menjar - (menjar * 0.05);
                return preuFinal;
            }
            return menjar;
        }
        else if (tipusMenjar.equalsIgnoreCase("menú premium")){
            menjar = 30;
            menjar = menjar * numConvidats;
            if (numConvidats > 50){
                double preuFinal = menjar - (menjar * 0.05);
                return preuFinal;
            }
            return menjar;
        }
        throw new IllegalArgumentException("Tipus de menú desconegut: "+tipusMenjar);
    }

    public static double calculaCostEntreteniment(String tipusEntreteniment) {
        double entreteniment;
        if (tipusEntreteniment.equalsIgnoreCase("màgia")){
            entreteniment = 250;
            return entreteniment;
        }
        else if (tipusEntreteniment.equalsIgnoreCase("música en directe")){
            entreteniment = 500;
            return entreteniment;
        }
        else if (tipusEntreteniment.equalsIgnoreCase("cap")){
            entreteniment = 0;
            return entreteniment;
        }
        throw new IllegalArgumentException("Tipus d'entreteniment desconegut: "+tipusEntreteniment);
    }

    public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats) {
        double lloc = calculaCostLloc(tipusLloc);
        double menjar = calculaCostMenjar(tipusMenjar, numConvidats);
        double entreteniment = calculaCostEntreteniment(tipusEntreteniment);

        if (tipusLloc.equalsIgnoreCase("saló gran amb escenari")){
            entreteniment = entreteniment - 100;
        }
        return lloc + menjar + entreteniment;
    }

    public static void main(String[] args) {
        String template = "%-75s%.2f€";
        System.out.println(String.format(Locale.US,template,"Cas 1 (\"sala estàndard\", \"menú bàsic\", \"cap\", 20):",calculaFesta("sala estàndard", "menú bàsic", "cap", 20)));
        System.out.println(String.format(Locale.US,template,"Cas 2 (\"jardí amb piscina\", \"menú premium\", \"màgia\", 60): ",calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)));
        System.out.println(String.format(Locale.US,template,"Cas 3 (\"jardí amb piscina\", \"menú bàsic\", \"música en directe\", 40): ",calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)));
        System.out.println(String.format(Locale.US,template,"Cas 4 (\"saló gran amb escenari\", \"menú premium\", \"música en directe\", 70): ",calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)));
        System.out.println(String.format(Locale.US,template,"Cas 5 (\"sala estàndard\", \"menú premium\", \"màgia\", 15): ",calculaFesta("sala estàndard", "menú premium", "màgia", 15)));
    }
}
