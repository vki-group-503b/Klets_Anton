package ru.nsu.hci.Klets.javalabs.lab2;

import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class ArrayContainer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = in.nextInt();
        int[] mass = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите элемент массива №%d: ", i+1);
            int a = in.nextInt();
            mass[i] = a;
        }

        Arrays.sort(mass);
        int min=minimum(mass, n), max = maximum(mass,n);
        float A = average(mass, n);
        double G = geometricMean(mass, n);
        float M = median(mass, n);

        System.out.printf("Минимальный элемент массива: %d\n", min);
        System.out.printf("Максимальный элемент массива: %d\n", max);
        System.out.printf("Средне арифмитическое: %f\n", A);
        System.out.printf("Средне геометрическое: %f\n", G);
        System.out.printf("Медиана ряда чисел: %f", M);
    }

    private static int minimum (int mass[], int n)
    {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(min>mass[i])
                min=mass[i];
        }
        return min;
    }

    private static int maximum (int mass[], int n)
    {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(max<mass[i])
                max=mass[i];
        }
        return max;
    }

    private static float median(int mass[], int n) {
        if(n==0)
            return 1;
        float x;
        int z = n / 2;
        if (n % 2 == 0) {
            x = mass[z - 1] + mass[z];
            x /= 2;
        } else
            x = mass[z];
        return x;
    }

    private static float average(int mass[], int n) {
        if(n==0)
            return 0;
        float x = 0;
        for (int i = 0; i < n; i++)
            x += mass[i];
        x /= n;
        return x;
    }

    private static double geometricMean(int mass[], int n) {
        if(n==0)
            return 1;
        float x = 1;
        double z;
        for (int i = 0; i < n; i++)
            x *= mass[i];
        z = Math.pow(x, 1.0 / n);
        return z;
    }

}