package com.exercicis;

import java.util.*;

public class Exercici0012 {

    public static HashMap<String, Object> createWonder(String name, String location, int age) {
        HashMap<String,Object> nameLocationAge = new HashMap<>();
        nameLocationAge.put("name",name);
        nameLocationAge.put("location", location);
        nameLocationAge.put("age", age);

        return nameLocationAge;
    }

    public static void showInformation(ArrayList<HashMap<String, Object>> wonders) {
        for (HashMap<String, Object> monuments : wonders){
            System.out.printf("* Name: "+monuments.get("name")+"%n  Location: "+monuments.get("location")+"%n  Age: "+monuments.get("age")+" years%n");
        }
    }

    public static ArrayList<HashMap<String, Object>> sortWondersByName(ArrayList<HashMap<String, Object>> wonders) {
        ArrayList<HashMap<String, Object>> ordenatsPerNom = new ArrayList<>(wonders);
        ordenatsPerNom.sort((anterior, siguiente) -> {
            String stringAnterior = (String) anterior.get("name");
            String stringsiguiente = (String) siguiente.get("name");
            return stringAnterior.compareTo(stringsiguiente);
        });
        return ordenatsPerNom;
    }
  
    public static ArrayList<HashMap<String, Object>> getSortedWondersByName(ArrayList<HashMap<String, Object>> wonders, int quantity) {
        ArrayList<HashMap<String, Object>> ordenats = sortWondersByName(wonders);
        ArrayList<HashMap<String, Object>> ordenatsQuantitat = new ArrayList<>();
        for (int i = 0; i < quantity; i++){
            ordenatsQuantitat.add(ordenats.get(i));
        }
        return ordenatsQuantitat;
    }
   
    public static ArrayList<String> sortNames(ArrayList<HashMap<String, Object>> wonders) {
        ArrayList<String> llistaNomsOrdenats = new ArrayList<>();

        for (int i = 0; i<wonders.size();i++){
            llistaNomsOrdenats.add((String) wonders.get(i).get("name"));
        }
        llistaNomsOrdenats.sort((nomAnterior, nomSeguent) ->{
            return nomAnterior.compareTo(nomSeguent);
        });
        return llistaNomsOrdenats;
    }

    public static ArrayList<HashMap<String, Object>> getOlder(ArrayList<HashMap<String, Object>> wonders, int quantity) {
        ArrayList<HashMap<String, Object>> ordenatPerNumero = new ArrayList<>(wonders); 
        ordenatPerNumero.sort((anterior, seguent) ->{
            Integer anteriorNum = (int) anterior.get("age");
            Integer seguentNum = (int) seguent.get("age");
            return seguentNum.compareTo(anteriorNum);
        });
        ArrayList<HashMap<String, Object>> ordenatsQuantity = new ArrayList<>();
        for (int i = 0; i < quantity; i++){
            ordenatsQuantity.add(ordenatPerNumero.get(i));
        }
        return ordenatsQuantity;
    }
   
    public static ArrayList<HashMap<String, Object>> getRegion(ArrayList<HashMap<String, Object>> wonders, String region) {
        ArrayList<HashMap<String, Object>> wonderRegion = new ArrayList<>();
        for (HashMap<String, Object> regionInWonders : wonders){
            if(((String)regionInWonders.get("location")).contains(region)){
                wonderRegion.add(regionInWonders);
            }
        }
        return wonderRegion;
    }

    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(createWonder("Great Pyramid of Giza", "Egypt", 4500));
        wonders.add(createWonder("Hanging Gardens of Babylon", "Babylon, Mesopotamia", 2500));
        wonders.add(createWonder("Statue of Zeus at Olympia", "Olympia, Greece", 2500));
        wonders.add(createWonder("Temple of Artemis at Ephesus", "Ephesus, Turkey", 2400));
        wonders.add(createWonder("Mausoleum at Halicarnassus", "Halicarnassus, Turkey", 2300));
        wonders.add(createWonder("Colossus of Rhodes", "Island of Rhodes, Greece", 2300));
        wonders.add(createWonder("Lighthouse of Alexandria", "Alexandria, Egypt", 2200));

        System.out.println("All Wonders:");
        showInformation(wonders);
        System.out.println("-------------------------\nSorted Names:");
        System.out.println(sortNames(wonders));
        System.out.println("-------------------------");
        System.out.println("Top 3 Oldest Wonders:");
        showInformation(getOlder(wonders, 3));
        System.out.println("-------------------------");
        System.out.println("Wonders in Turkey:");
        showInformation(getRegion(wonders, "Turkey"));

        
    }
}
