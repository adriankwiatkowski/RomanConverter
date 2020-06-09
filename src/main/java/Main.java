public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        System.out.println(RomanConverter.parseRoman("XXXIX"));
        System.out.println(RomanConverter.parseRoman("CCXLVI"));
        System.out.println(RomanConverter.parseRoman("DCCLXXXIX"));
        System.out.println(RomanConverter.parseRoman("MMCDXXI"));

        System.out.println(RomanConverter.parseArabic(39));
        System.out.println(RomanConverter.parseArabic(246));
        System.out.println(RomanConverter.parseArabic(789));
        System.out.println(RomanConverter.parseArabic(2421));
        System.out.println(RomanConverter.parseArabic(3999));
        System.out.println(RomanConverter.parseArabic(999));
    }
}
