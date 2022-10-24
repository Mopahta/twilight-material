package by.mopahta.laba.task4;

public class PrimeValidator {
    public void testFunction () {
        int[] digits = new int[20];
        for (int i = 0; i < 20; i++) {
            digits[i] = (int) (Math.random() * 20 + 1);

        }
        for (int i = 0; i < 20; i++) {
            if (isPrime(digits[i])) {
                System.out.print(i + " ");
            }
        }
    }

    private boolean isPrime (int x) {
        if (x == 1 || x == 2) {
            return true;
        }
        int i = 1;
        do {
            i++;
            if (x % i == 0) {
                return false;
            }
        } while ((i < Math.sqrt(x)) || (Math.abs(i - Math.sqrt(x)) < 0.0001));
        return true;
    }
}
