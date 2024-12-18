package com.exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici0008 {

    public static ArrayList<Integer> generaImparells(int numero) {
        ArrayList<Integer> imparells = new ArrayList<>();
        // 9 <= 2
        for (int cnt = 2; numero >= cnt;cnt++){
            if (cnt%2!=0){
                imparells.add(cnt);
            }
        }
        return imparells;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix un número: ");
        int numero = scanner.nextInt();
        System.out.println("Nombres imparells entre 2 i "+numero+": "+generaImparells(numero));
        scanner.close();
    }
}
