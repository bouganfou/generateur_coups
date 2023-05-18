package com.conding.cegedim;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final char[] pieces = {'♘', '♟'};

    public static void main(String[] args) {
        getPossibleMoves().forEach(System.out::println);

    }

    public static List<String> getPossibleMoves() {
        List<String> tourDeplace = new ArrayList<>();
        String tourPosition = "d5"; // Position de la tour blanche

        // Vérification des déplacements possibles vers le haut
        for (int i = 1; i < 8; i++) {
            String nouveau_position = tourPosition.charAt(0) + String.valueOf(Character.getNumericValue(tourPosition.charAt(1)) + i);
            if (isValidMove(nouveau_position)) {
                tourDeplace.add(tourPosition + "-" + nouveau_position);
                if (isOccupied(nouveau_position)) {
                    break;
                }
            }
        }

        // Vérification des déplacements possibles vers le bas
        for (int i = 1; i < 8; i++) {
            String new_position = tourPosition.charAt(0) + String.valueOf(Character.getNumericValue(tourPosition.charAt(1)) - i);
            if (isValidMove(new_position)) {
                tourDeplace.add(tourPosition + "-" + new_position);
                if (isOccupied(new_position)) {
                    break;
                }
            }
        }

        // Vérification des déplacements possibles vers la droite
        for (int i = tourPosition.charAt(0) + 1; i < 'i'; i++) {
            String new_position = String.valueOf((char) i) + tourPosition.charAt(1);
            if (isValidMove(new_position)) {
                tourDeplace.add(tourPosition + "-" + new_position);
                if (isOccupied(new_position)) {
                    break;
                }
            }
        }

        // Vérification des déplacements possibles vers la gauche
        for (int i = tourPosition.charAt(0) - 1; i >= 'a'; i--) {
            String new_position = String.valueOf((char) i) + tourPosition.charAt(1);
            if (isValidMove(new_position)) {
                tourDeplace.add(tourPosition + "-" + new_position);
                if (isOccupied(new_position)) {
                    break;
                }
            }
        }

        return tourDeplace;
    }

    public static boolean isValidMove(String position) {
        return position.charAt(0) >= 'a' && position.charAt(0) <= 'h' &&
                position.charAt(1) >= '1' && position.charAt(1) <= '8';
    }

    public static boolean isOccupied(String position) {
        for (char piece : pieces) {
            if (position.equals(getPiecePosition(piece))) {
                return true;
            }
        }
        return false;
    }

    public static String getPiecePosition(char piece) {
        // Méthode fictive pour obtenir la position d'une pièce sur l'échiquier
        // en fonction de son caractère de représentation
        switch (piece) {
            case '♘':
                return "d2"; // Position du cavalier blanc
            case '♟':
                return "d7"; // Position du pion noir
            default:
                return null;
        }
    }
}
