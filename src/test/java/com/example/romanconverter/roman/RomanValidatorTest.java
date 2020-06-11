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

import static com.example.romanconverter.roman.RomanValidator.isRomanNumeral;
import static org.junit.Assert.*;

public class RomanValidatorTest {

    @Test
    public void validateRoman_isCorrect() {
        assertTrue(isRomanNumeral("XXXIX"));
        assertTrue(isRomanNumeral("CCXLVI"));
        assertTrue(isRomanNumeral("DCCLXXXIX"));
        assertTrue(isRomanNumeral("MMCDXXI"));
        assertTrue(isRomanNumeral("CMXCIX"));
        assertTrue(isRomanNumeral("MMMCMXCIX"));

        assertTrue(isRomanNumeral("MMMCM"));
    }

    @Test
    public void validateRoman_isIncorrect() {
        assertFalse(isRomanNumeral("IIII"));
        assertFalse(isRomanNumeral("VVVV"));
        assertFalse(isRomanNumeral("XXXX"));
        assertFalse(isRomanNumeral("LLLL"));
        assertFalse(isRomanNumeral("CCCC"));
        assertFalse(isRomanNumeral("DDDD"));
        assertFalse(isRomanNumeral("MMMM"));

        assertFalse(isRomanNumeral("VL"));
        assertFalse(isRomanNumeral("IM"));
        assertFalse(isRomanNumeral("VV"));
        assertFalse(isRomanNumeral("LLL"));
        assertFalse(isRomanNumeral("DDD"));

        assertFalse(isRomanNumeral("XIXIXIX"));
        assertFalse(isRomanNumeral("IXI"));
        assertFalse(isRomanNumeral("IXV"));
        assertFalse(isRomanNumeral("IXX"));

        assertFalse(isRomanNumeral("DCCCXXLX"));

        assertFalse(isRomanNumeral(""));
    }
}
