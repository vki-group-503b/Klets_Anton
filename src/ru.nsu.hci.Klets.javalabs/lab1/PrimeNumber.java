package ru.nsu.hci.Klets.javalabs.lab1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        int x = in.nextInt();

        boolean z = isCorrect(x);
        if (z) {
            System.out.print("Число простое");
        } else {
            System.out.print("Число не простое");
        }

    }

    private static boolean isCorrect(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}