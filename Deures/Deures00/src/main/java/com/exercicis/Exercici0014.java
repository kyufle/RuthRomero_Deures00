package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class Exercici0014 {

    public static String getMovePC() {
        Random random = new Random();
        int numMoviment = random.nextInt(3);
        if (numMoviment == 1) {
            return "PEDRA";
        } else if (numMoviment == 2) {
            return "PAPER";
        }
        return "TISORA";
    }

    public static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Moviment: ");
            String resposta = scanner.nextLine();
            if (resposta.toUpperCase().equals("SORTIR")) {
                return null;
            } else if (resposta.toUpperCase().equals("PEDRA") || resposta.toUpperCase().equals("PAPER")
                    || resposta.toUpperCase().equals("TISORES")) {
                return resposta;
            }
        }
    }

    public static String getWinner(String playerMove, String pcMove) {
        if (playerMove.equals(pcMove)) {
            return "DRAW";
        } else if ((playerMove.toUpperCase().equals("PAPER") && pcMove.equals("PEDRA"))
                || (playerMove.toUpperCase().equals("PEDRA") && pcMove.equals("TISORES"))
                || (playerMove.toUpperCase().equals("TISORES") && pcMove.equals("PAPER"))) {
            return "PLAYER";
        } else {
            return "PC";
        }
    }

    public static String getScoreMessage(int playerScore, int pcScore) {
        return "Marcador -> JUGADOR: " + playerScore + " - PC: " + pcScore;
    }

    public static String getWinnerMessage(boolean playerWon) {
        if (playerWon) {
            return "Felicitats! Has guanyat la partida!";
        }
        return "";
    }

    public static void updateStats(HashMap<String, Integer> stats, String move, boolean win) {
        if (move.equalsIgnoreCase("PEDRA")) {
            stats.put("PEDRA_COUNT", stats.get("PEDRA_COUNT") + 1);
            if (win) {
                stats.put("PEDRA_WINS", stats.get("PEDRA_WINS") + 1);
            }
        } else if (move.equalsIgnoreCase("PAPER")) {
            stats.put("PAPER_COUNT", stats.get("PAPER_COUNT") + 1);
            if (win) {
                stats.put("PAPER_WINS", stats.get("PAPER_WINS") + 1);
            }
        } else if (move.equalsIgnoreCase("TISORES")) {
            stats.put("TISORES_COUNT", stats.get("TISORES_COUNT") + 1);
            if (win) {
                stats.put("TISORES_WINS", stats.get("TISORES_WINS") + 1);
            }
        }

    }

    public static String getMessage(String winner, String playerMove, String pcMove) {
        if (winner.equalsIgnoreCase("PC")) {
            return "Ho sento! " + pcMove + " guanya a " + playerMove + "!";
        } else if (winner.equalsIgnoreCase("PLAYER")) {
            return "Molt bé! " + playerMove + " guanya a " + pcMove + "!";
        }
        return "Empat! Els dos heu triat " + pcMove + "!";
    }

    public static void showStats(HashMap<String, Integer> stats) {
        System.out.println("Estadístiques finals:");
        System.out.println("------------------");
        int movimentsTotals = stats.get("PEDRA_COUNT") + stats.get("PAPER_COUNT") + stats.get("TISORES_COUNT");
        double totalVictories = ((double) (stats.get("PEDRA_WINS") + stats.get("PAPER_WINS")
                + stats.get("TISORES_WINS")) / movimentsTotals) * 100;
        System.out.println("Total partides: " + movimentsTotals);
        System.out.println("Victòries: " + totalVictories + "%");
        if (stats.get("PEDRA_COUNT") > stats.get("PAPER_COUNT")
                && stats.get("PEDRA_COUNT") > stats.get("TISORES_COUNT")) {
            System.out.println("Moviment més utilitzat: PEDRA (" + stats.get("PEDRA_COUNT") + " vegades)");
        } else if (stats.get("PAPER_COUNT") > stats.get("PEDRA_COUNT")
                && stats.get("PAPER_COUNT") > stats.get("TISORES_COUNT")) {
            System.out.println("Moviment més utilitzat: PAPER (" + stats.get("PAPER_COUNT") + " vegades)");
        } else {
            System.out.println("Moviment més utilitzat: TISORES (" + stats.get("TISORES_COUNT") + " vegades)");
        }
        double pedraWinrate = stats.get("PEDRA_WINS") / stats.get("PEDRA_COUNT") * 100;
        double paperWinrate = stats.get("PAPER_WINS") / stats.get("PAPER_COUNT") * 100;
        double tisoresWinrate = stats.get("TISORES_WINS") / stats.get("TISORES_COUNT") * 100;
        if (pedraWinrate > paperWinrate && pedraWinrate > tisoresWinrate) {
            System.out.println("Moviment més victoriós: PEDRA (" + (int) pedraWinrate + "% victòries)");
        } else if (paperWinrate > pedraWinrate && paperWinrate > tisoresWinrate) {
            System.out.println("Moviment més victoriós: PAPER (" + (int) paperWinrate + "% victòries)");
        } else {
            System.out.println("Moviment més victoriós: TISORES (" + (int) tisoresWinrate + "% victòries)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Definim l'scanner al principi
        try {
            HashMap<String, Integer> stats = new HashMap<>();
            stats.put("PEDRA_COUNT", 0);
            stats.put("PAPER_COUNT", 0);
            stats.put("TISORES_COUNT", 0);
            stats.put("PEDRA_WINS", 0);
            stats.put("PAPER_WINS", 0);
            stats.put("TISORES_WINS", 0);
            int playerScore = 0;
            int pcScore = 0;
            System.out.println("Benvingut a Pedra, Paper, Tisores!");
            System.out.println("El primer en arribar a 3 victòries guanya!");
            System.out.println();

            while (playerScore < 3 && pcScore < 3) {
                String playerMove = getPlayerMove(scanner);
                if (playerMove == null)
                    break;

                String pcMove = getMovePC();
                System.out.println("PC tria: " + pcMove);

                String winner = getWinner(playerMove, pcMove);
                System.out.println(getMessage(winner, playerMove, pcMove));
                if (winner.equals("PLAYER")) {
                    playerScore++;
                } else if (winner.equals("PC")) {
                    pcScore++;
                }
                System.out.println(getScoreMessage(playerScore, pcScore));
                System.out.println();

                updateStats(stats, playerMove, winner.equals("PLAYER"));
            }

            if (playerScore >= 3 || pcScore >= 3) {
                boolean playerWon = playerScore >= 3;
                System.out.println(getWinnerMessage(playerWon));
                System.out.println();
            }

            showStats(stats);
        } finally {
            scanner.close();
        }
    }
}