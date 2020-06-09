import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanConverterTest {

    @Test
    public void parsingRoman_isCorrect() {
        assertEquals(39, RomanConverter.parseRoman("XXXIX"));
        assertEquals(246, RomanConverter.parseRoman("CCXLVI"));
        assertEquals(789, RomanConverter.parseRoman("DCCLXXXIX"));
        assertEquals(2421, RomanConverter.parseRoman("MMCDXXI"));
        assertEquals(999, RomanConverter.parseRoman("CMXCIX"));
        assertEquals(3999, RomanConverter.parseRoman("MMMCMXCIX"));
    }

    @Test
    public void parsingArabic_isCorrect() {
        assertEquals("XXXIX", RomanConverter.parseArabic(39));
        assertEquals("CCXLVI", RomanConverter.parseArabic(246));
        assertEquals("DCCLXXXIX", RomanConverter.parseArabic(789));
        assertEquals("MMCDXXI", RomanConverter.parseArabic(2421));
        assertEquals("CMXCIX", RomanConverter.parseArabic(999));
        assertEquals("MMMCMXCIX", RomanConverter.parseArabic(3999));
    }
}