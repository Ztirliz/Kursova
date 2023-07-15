package org.example;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть поліном:");
        String input1 = scanner.nextLine();
        int count = input1.length() - 1;

        // Створюємо масив для збереження коефіцієнтів полінома
        int[] polynomialCoefficients = new int[count];
        for (int i = 0; i < count; i++) {
            polynomialCoefficients[i] = Integer.parseInt(input1.substring(i + 1, i + 2));
        }

        // Створюємо об'єкт LinearFeedbackShiftRegister з переданими коефіцієнтами полінома
        LinearFeedbackShiftRegister lfsr1 = new LinearFeedbackShiftRegister(count, polynomialCoefficients);

        System.out.println("Введіть початковий стан LFSR:");
        input1 = scanner.nextLine();
        count = input1.length();

        // Створюємо масив для збереження початкового стану регістру LFSR
        int[] initialRegister1 = new int[count];
        for (int i = 0; i < count; i++) {
            initialRegister1[i] = Integer.parseInt(input1.substring(i, i + 1));
        }
        lfsr1.setRegister(initialRegister1);

        System.out.println("LFSR1:");

        // Викликаємо метод printGeneratedNumbers() для генерації чисел LFSR
        String line = lfsr1.printGeneratedNumbers(32);
        line = new StringBuilder(line).reverse().toString();

        // Розділяємо рядок line на окремі частини A, B і C
        int A = Integer.parseInt(line.substring(0, 11), 2);
        int B = Integer.parseInt(line.substring(11, 21), 2);
        int C = Integer.parseInt(line.substring(21, 32), 2);

        System.out.println(line.substring(0, 11) + "\n" + line.substring(11, 21) + "\n" + line.substring(21, 31));
        System.out.println("A=" + A + "; " + "B=" + B + "; " + "C=" + C);

        System.out.println("Введіть 10 значень (без пробілу)");
        String str = scanner.next();

        // Викликаємо функцію calculate() з класу FunctionCalculation для перевірки значень
        FunctionCalculation.calculate(str);
    }
}
