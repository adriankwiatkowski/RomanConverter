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

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {

    private RomanConverter() {
    }

    private static final Map<Character, Integer> ROMAN_INT_MAP =
            new HashMap<Character, Integer>() {
                {
                    put('I', 1);
                    put('V', 5);
                    put('X', 10);
                    put('L', 50);
                    put('C', 100);
                    put('D', 500);
                    put('M', 1000);
                }
            };

    private static final int[] ARABIC_NUMBERS_DEC = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    private static final String[] ROMAN_NUMBERS_DEC = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static int parseRoman(String roman) {
        roman = roman.trim();
        String romanCapitalized = roman.toUpperCase();

        if (!RomanValidator.isRomanNumeral(roman)) {
            System.out.println("Invalid roman literal.");
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < romanCapitalized.length(); ++i) {
            char romanChar = romanCapitalized.charAt(i);

            if (!ROMAN_INT_MAP.containsKey(romanChar)) {
                throw new IllegalArgumentException(romanChar + " is not legal roman numeral.");
            }

            int currentRomanValue = ROMAN_INT_MAP.get(romanChar);

            int romanValueToAdd = currentRomanValue;

            if (i + 1 < romanCapitalized.length()) {
                int nextRomanValue = ROMAN_INT_MAP.get(romanCapitalized.charAt(i + 1));

                if (nextRomanValue > currentRomanValue) {
                    romanValueToAdd = nextRomanValue - currentRomanValue;
                    ++i;
                }
            }

            sum += romanValueToAdd;
        }

        return sum;
    }

    public static String parseArabic(int arabic) {
        if (arabic <= -4000 || arabic >= 4000) {
            throw new IllegalArgumentException("Number " + arabic + " out of bounds: {-3999; 3999}");
        }

        StringBuilder sb        = new StringBuilder();
        int           arabicAbs = Math.abs(arabic);

        for (int i = 0; i < ARABIC_NUMBERS_DEC.length; ++i) {
            int times = arabicAbs / ARABIC_NUMBERS_DEC[i];

            for (int j = 0; j < times; ++j) {
                sb.append(ROMAN_NUMBERS_DEC[i]);
            }

            arabicAbs -= times * ARABIC_NUMBERS_DEC[i];
        }

        assert RomanValidator.isRomanNumeral(sb.toString()) : "Generated invalid roman numeral!";

        if (arabic < 0) {
            sb.insert(0, "-");
        }

        return sb.toString();
    }
}
