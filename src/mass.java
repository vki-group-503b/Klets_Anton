import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class mass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int x = in.nextInt();
        int[] mass = new int[x];
        int i, z, t;
        float arf = 0, geo = 1;
        System.out.print("Введите массив:\n");
        for (i = 0; i < x; i++) {
            int d = in.nextInt();
            mass[i] = d;
            arf = arf + mass[i];
            geo = geo * mass[i];
        }
        Arrays.sort(mass);
        if (x % 2 == 0) {
            t = x / 2;
            z = (mass[t - 1] + mass[t]) / 2;
        } else {
            t = x / 2;
            z = mass[t];
        }
        System.out.printf("Минимальный элемент массива: %d\n", mass[0]);
        System.out.printf("Максимальный элемент массива: %d\n", mass[x - 1]);
        System.out.printf("Средне арифмитическое: %f\n", arf / x);
        System.out.printf("Средне геометрическое: %f\n", Math.pow(geo, 1.0 / x));
        System.out.printf("Медиана ряда чисел: %d", z);

    }

}