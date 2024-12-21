package com.exercicis;

import java.util.*;

public class Exercici0013 {

    public static int generateId(ArrayList<HashMap<String, Object>> cities) {
        Random random = new Random();
        while (true) {
            int idNumber = random.nextInt(1000, 9000);
            if (!idExists(cities, idNumber)) {
                return idNumber;
            }
        }
    }

    public static boolean idExists(ArrayList<HashMap<String, Object>> cities, int id) {
        for (HashMap<String, Object> city : cities) {
            if (city.get("id").equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static int getIdByName(ArrayList<HashMap<String, Object>> cities, String name) {
        for (HashMap<String, Object> city : cities) {
            if (city.get("name").equals(name)) {
                return (int) city.get("id");
            }
        }
        return -1; // -1 si no troba la ciutat
    }

    public static void addCity(ArrayList<HashMap<String, Object>> cities,
            String name, int population, int height, boolean sealand) {
        HashMap<String, Object> nuevaCiudad = new HashMap<>();
        nuevaCiudad.put("name", name);
        nuevaCiudad.put("id",generateId(cities));
        nuevaCiudad.put("population", population);
        nuevaCiudad.put("height", height);
        nuevaCiudad.put("sealand",sealand);
        cities.add(nuevaCiudad);
    }

    public static void removeCity(ArrayList<HashMap<String, Object>> cities, int id) {
        for (int i = 0; i<cities.size();i++){
            if (cities.get(i).get("id").equals(id)){
                cities.remove(cities.get(i));
            }   
        }
        
    }

    public static void updateData(ArrayList<HashMap<String, Object>> cities,
            int id, String field, Object value) {
        for (int i = 0;i<cities.size();i++){
            if (cities.get(i).get("id").equals(id)){
                cities.get(i).put(field, value);
            }
        }
    }

    public static void showInformation(ArrayList<HashMap<String, Object>> cities) {
        System.out.println("----------------------------------------------\n" + //
                        "|ID   |Name      |Population| Height| Sealand|\n" + //
                        "----------------------------------------------");
        for (HashMap<String, Object> city : cities){
            System.out.printf("|%s |%-10s|%10s|%7s|%8s|%n",city.get("id"), city.get("name"),city.get("population"),city.get("height"),city.get("sealand"));
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> cities = new ArrayList<>();

        // Afegir les ciutats inicials
        addCity(cities, "Barcelona", 1620343, 12, true);
        addCity(cities, "Madrid", 3207247, 667, false);
        addCity(cities, "València", 791413, 15, true);
        addCity(cities, "Màlaga", 569130, 11, true);
        addCity(cities, "Sevilla", 688711, 7, false);
        addCity(cities, "Alicante", 330525, 12, true);
        addCity(cities, "Zaragoza", 664938, 220, false);
        addCity(cities, "Gijón", 275735, 3, true);
        addCity(cities, "Palma de M", 22610, 14, true);
        addCity(cities, "Bilbao", 345821, 30, false);

        // Eliminar Sevilla
        int sevillaId = getIdByName(cities, "Sevilla");
        if (sevillaId != -1) {
            removeCity(cities, sevillaId);
        }

        // Actualitzar diverses dades
        int barcelonaId = getIdByName(cities, "Barcelona");
        updateData(cities, barcelonaId, "population", 1621000);

        int valenciaId = getIdByName(cities, "València");
        updateData(cities, valenciaId, "height", 16);

        int palmaId = getIdByName(cities, "Palma de M");
        updateData(cities, palmaId, "name", "Palma");

        int zaragozaId = getIdByName(cities, "Zaragoza");
        updateData(cities, zaragozaId, "sealand", false);

        // Afegir una nova ciutat
        addCity(cities, "Tarragona", 132299, 70, true);

        // Mostrar la informació final
        showInformation(cities);
    }
}