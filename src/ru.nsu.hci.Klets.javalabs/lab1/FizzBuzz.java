package ru.nsu.hci.Klets.javalabs.lab1;

public class FizzBuzz {

    public static void main(String[] args) {
        int i = 1;
        do {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.print("FizzBuzz\n");
            } else if (i % 3 == 0) {
                System.out.print("Fizz\n");
            } else if (i % 5 == 0) {
                System.out.print("Buzz\n");
            } else {
                System.out.printf("%d\n", i);
            }
            i++;
        } while (i < 101);
    }
}