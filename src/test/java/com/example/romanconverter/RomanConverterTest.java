/*
 * Copyright 2020 Adrian
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.romanconverter;

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