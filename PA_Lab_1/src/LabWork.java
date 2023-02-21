public class LabWork {

    public static void main(String[] args) {
        labWork();
    }
    private static void labWork() {
        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n *= 3;

        //parsing 10101 from binary to decimal
        n += Integer.parseInt("10101", 2);

        //parsing FF from hexadecimal to decimal
        n += Integer.parseInt("FF", 16);

        n *= 6;

        int sumOfDigits = 0;

        //getting sum of digits
        while (n != 0) {
            sumOfDigits += n % 10;
            n /= 10;
        }

        while (sumOfDigits >= 10) {
            int newNumb = 0;
            while (sumOfDigits != 0) {
                newNumb += sumOfDigits % 10;
                sumOfDigits /= 10;
            }
            sumOfDigits = newNumb;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[sumOfDigits]);
    }
}
