package org.example;

public class LinearFeedbackShiftRegister {
    private int[] register;
    private int[] polynomialCoefficients;

    public LinearFeedbackShiftRegister(int size, int[] polynomialCoefficients) {
        this.register = new int[size];
        this.polynomialCoefficients = polynomialCoefficients;
    }

    public void shift() {
        // Обчислюємо зворотній зворотній зв'язок
        int feedback = calculateFeedback();

        // Здвигаємо значення у регістрі вправо
        for (int i = register.length - 1; i > 0; i--) {
            register[i] = register[i - 1];
        }

        // Встановлюємо нове значення найбільшого (найстаршого) біту регістру
        register[0] = feedback;
    }

    public void setRegister(int[] values) {
        // Встановлюємо значення регістру з заданих значень
        if (values.length != register.length) {
            throw new IllegalArgumentException("Invalid register length");
        }
        System.arraycopy(values, 0, register, 0, register.length);
    }

    public int generateOutput() {
        String line = "";
        for (int i = 0; i < register.length; i++) {
            line += register[i];
        }
        String[] characters = line.split(""); // Розбиваємо рядок на окремі символи

        String result = String.join("|", characters); // З'єднуємо символи з роздільником "|"

        System.out.println(result);
        return register[register.length - 1]; // Повертаємо значення останнього (наймолодшого) біту регістру
    }

    private int calculateFeedback() {
        int feedback = 0;
        for (int i = 0; i < polynomialCoefficients.length; i++) {
            // Обчислюємо зворотній зворотній зв'язок, використовуючи XOR операцію
            if (polynomialCoefficients[i] == 1) {
                feedback ^= register[i];
            }
        }
        return feedback;
    }

    public String printGeneratedNumbers(int numIterations) {
        String line = "";
        int[] matrix = new int[numIterations];
        for (int i = 0; i < numIterations; i++) {
            System.out.print(i + "  -  ");

            int output = generateOutput();
            matrix[i] = output;
            line += output;

            shift();
        }
        System.out.println(line);
        return line;
    }
}
