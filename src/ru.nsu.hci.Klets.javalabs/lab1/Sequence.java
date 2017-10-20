package ru.nsu.hci.Klets.javalabs.lab1;

import java.util.Scanner;
import java.lang.String;

public class Sequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String x = in.nextLine();

        boolean count = isPosledCorrect(x);
        if (count) {
            System.out.print("Последовательность правильная");
        } else {
            System.out.print("Последовательность не правильная");
        }
    }

    private static boolean isPosledCorrect(String x) {
        int count = 0;
        int n = x.length();

        for (char chr : x.toCharArray()) {
            switch (chr) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                default:
            }
            if (count < 0) return false;
        }
        return count == 0;
    }
}

