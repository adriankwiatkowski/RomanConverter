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
package com.example.romanconverter.roman;

import org.junit.Test;

import static com.example.romanconverter.roman.RomanConverter.parseArabic;
import static com.example.romanconverter.roman.RomanConverter.parseRoman;
import static org.junit.Assert.assertEquals;

public class RomanConverterTest {

    @Test
    public void parsingRoman_isCorrect() {
        assertEquals(39, parseRoman("XXXIX"));
        assertEquals(246, parseRoman("CCXLVI"));
        assertEquals(789, parseRoman("DCCLXXXIX"));
        assertEquals(2421, parseRoman("MMCDXXI"));
        assertEquals(999, parseRoman("CMXCIX"));
        assertEquals(3999, parseRoman("MMMCMXCIX"));
    }

    @Test
    public void parsingArabic_isCorrect() {
        assertEquals("XXXIX", parseArabic(39));
        assertEquals("CCXLVI", parseArabic(246));
        assertEquals("DCCLXXXIX", parseArabic(789));
        assertEquals("MMCDXXI", parseArabic(2421));
        assertEquals("CMXCIX", parseArabic(999));
        assertEquals("MMMCMXCIX", parseArabic(3999));
    }
}