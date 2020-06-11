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

import static com.example.romanconverter.roman.RomanValidator.isRomanValid;
import static org.junit.Assert.*;

public class RomanValidatorTest {

    @Test
    public void validateRoman_isCorrect() {
        assertTrue(isRomanValid("XXXIX"));
        assertTrue(isRomanValid("CCXLVI"));
        assertTrue(isRomanValid("DCCLXXXIX"));
        assertTrue(isRomanValid("MMCDXXI"));
        assertTrue(isRomanValid("CMXCIX"));
        assertTrue(isRomanValid("MMMCMXCIX"));

        assertTrue(isRomanValid("MMMCM"));
    }

    @Test
    public void validateRoman_isIncorrect() {
        assertFalse(isRomanValid("IIII"));
        assertFalse(isRomanValid("VVVV"));
        assertFalse(isRomanValid("XXXX"));
        assertFalse(isRomanValid("LLLL"));
        assertFalse(isRomanValid("CCCC"));
        assertFalse(isRomanValid("DDDD"));
        assertFalse(isRomanValid("MMMM"));

        assertFalse(isRomanValid("VL"));
        assertFalse(isRomanValid("IM"));
        assertFalse(isRomanValid("VV"));
        assertFalse(isRomanValid("LLL"));
        assertFalse(isRomanValid("DDD"));

        assertFalse(isRomanValid("XIXIXIX"));
        assertFalse(isRomanValid("IXI"));
        assertFalse(isRomanValid("IXV"));
        assertFalse(isRomanValid("IXX"));

        assertFalse(isRomanValid("DCCCXXLX"));

        assertFalse(isRomanValid("MMMM"));
    }
}
