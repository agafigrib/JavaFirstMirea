package ru.mirea.task19;

public class InnValidator {
    private static final int[] WEIGHTS_10 = {2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] WEIGHTS_12_FIRST = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] WEIGHTS_12_SECOND = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    private InnValidator() {
    }

    // проверка ИНН: длина, только цифры, контрольные числа
    public static void validate(String inn) throws InvalidInnException {
        if (inn == null || inn.trim().isEmpty()) {
            throw new InvalidInnException("ИНН не введён");
        }
        if (!inn.matches("\\d+")) {
            throw new InvalidInnException("ИНН должен состоять только из цифр: " + inn);
        }
        if (inn.length() != 10 && inn.length() != 12) {
            throw new InvalidInnException(
                    "ИНН должен содержать 10 или 12 цифр, введено: " + inn.length());
        }

        int[] d = new int[inn.length()];
        for (int i = 0; i < d.length; i++) {
            d[i] = inn.charAt(i) - '0';
        }

        boolean ok;
        if (d.length == 10) {
            ok = controlDigit(d, WEIGHTS_10) == d[9];
        } else {
            ok = controlDigit(d, WEIGHTS_12_FIRST) == d[10]
                    && controlDigit(d, WEIGHTS_12_SECOND) == d[11];
        }
        if (!ok) {
            throw new InvalidInnException("Недействительный ИНН (не совпадает контрольное число): " + inn);
        }
    }

    // считаем контрольную цифру по весам
    private static int controlDigit(int[] digits, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += digits[i] * weights[i];
        }
        return (sum % 11) % 10;
    }
}