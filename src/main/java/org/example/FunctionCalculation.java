package org.example;

public class FunctionCalculation {
    public static void calculate(String str) {

        int h0, h1, h2, h3, h4, h5;

        // Розбиваємо введений рядок на окремі значення
        int a0 = Integer.parseInt(str.substring(0,1));
        int a1 = Integer.parseInt(str.substring(1,2));
        int a2 = Integer.parseInt(str.substring(2,3));
        int a3 = Integer.parseInt(str.substring(3,4));
        int a4 = Integer.parseInt(str.substring(4,5));
        int a5 = Integer.parseInt(str.substring(5,6));
        int a6 = Integer.parseInt(str.substring(6,7));
        int a7 = Integer.parseInt(str.substring(7,8));
        int a8 = Integer.parseInt(str.substring(8,9));
        int a9 = Integer.parseInt(str.substring(9,10));

        // Задаємо значення для рядків a, b, c, d, e, f
        String a = "100101";
        String b = "101001";
        String c = "101111";
        String d = "110111";
        String e = "111011";
        String f = "111101";

        // Запускаємо цикли для перебору всіх можливих комбінацій значень h0-h4
        for (h0 = 0; h0 <= 1; h0++) {
            for (h1 = 0; h1 <= 1; h1++) {
                for (h2 = 0; h2 <= 1; h2++) {
                    for (h3 = 0; h3 <= 1; h3++) {
                        for (h4 = 0; h4 <= 1; h4++) {
                            // Обчислюємо значення рівнянь
                            int equation1 = h0 * a0  ^ h1 * a1 ^ h2 * a2 ^ h3 * a3 ^ h4 * a4;
                            int equation2 = h0 * a1 ^ h1 * a2 ^ h2 * a3 ^ h3 * a4 ^ h4 * a5;
                            int equation3 = h0 * a2 ^ h1 * a3 ^ h2 * a4 ^ h3 * a5 ^ h4 * a6;
                            int equation4 = h0 * a3 ^ h1 * a4 ^ h2 * a5 ^ h3 * a6 ^ h4 * a7;
                            int equation5 = h0 * a4 ^ h1 * a5 ^ h2 * a6 ^ h3 * a7 ^ h4 * a8;

                            // Перевіряємо, чи значення рівнянь відповідають a5-a9
                            if (equation1 == a5 && equation2 == a6 && equation3 == a7 && equation4 == a8 && equation5 == a9) {
                                h5 = 1;
                                System.out.println("h0 = " + h0);
                                System.out.println("h1 = " + h1);
                                System.out.println("h2 = " + h2);
                                System.out.println("h3 = " + h3);
                                System.out.println("h4 = " + h4);
                                System.out.println("h5 = " + h5);
                                String line = h0+""+h1+""+h2+""+h3+""+h4+""+h5;

                                // Перевіряємо значення рядків a, b, c, d, e, f знайденими значеннями h0-h5
                                checkValue("a", a, line);
                                checkValue("b", b, line);
                                checkValue("c", c, line);
                                checkValue("d", d,line);
                                checkValue("e", e, line);
                                checkValue("f", f, line);

                                return; // Зупиняємо виконання програми після знаходження відповідних значень
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Немає відповідних значень для функції."); // Виводимо, якщо не знайдено відповідних значень
    }

    public static void checkValue(String name, String expectedValue, String valueToCheck) {
        if (expectedValue.equals(valueToCheck)) {
            System.out.println("Поліном \""+name + "=" + valueToCheck+"\"");
        }
    }
}

