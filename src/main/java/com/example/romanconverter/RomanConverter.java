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

    private static final int[]    ARABIC_NUMBERS = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] ROMAN_NUMBERS  = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static int parseRoman(String roman) {
        roman = roman.trim();
        String romanCapitalized = roman.toUpperCase();

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
        if (arabic <= -4000) {
            throw new IllegalArgumentException("Number must be grater than -4000");
        }
        if (arabic >= 4000) {
            throw new IllegalArgumentException("Number must be lesser than 4000");
        }

        StringBuilder sb        = new StringBuilder();
        int           arabicAbs = Math.abs(arabic);

        for (int i = 0; i < ARABIC_NUMBERS.length; ++i) {
            int times = arabicAbs / ARABIC_NUMBERS[i];

            for (int j = 0; j < times; ++j) {
                sb.append(ROMAN_NUMBERS[i]);
            }

            arabicAbs -= times * ARABIC_NUMBERS[i];
        }

        if (arabic < 0) {
            sb.insert(0, "-");
        }

        return sb.toString();

        /*
        while (arabicAbs > 0) {
            String romanValue;
            int    arabicValue;

            if (arabicAbs >= 1000) {
                romanValue = "M";
                arabicValue = 1000;
            } else if (arabicAbs >= 900) {
                romanValue = "CM";
                arabicValue = 900;
            } else if (arabicAbs >= 500) {
                romanValue = "D";
                arabicValue = 500;
            } else if (arabicAbs >= 400) {
                romanValue = "CD";
                arabicValue = 400;
            } else if (arabicAbs >= 100) {
                romanValue = "C";
                arabicValue = 100;
            } else if (arabicAbs >= 90) {
                romanValue = "XC";
                arabicValue = 90;
            } else if (arabicAbs >= 50) {
                romanValue = "L";
                arabicValue = 50;
            } else if (arabicAbs >= 40) {
                romanValue = "XL";
                arabicValue = 40;
            } else if (arabicAbs >= 10) {
                romanValue = "X";
                arabicValue = 10;
            } else if (arabicAbs >= 9) {
                romanValue = "IX";
                arabicValue = 9;
            } else if (arabicAbs >= 5) {
                romanValue = "V";
                arabicValue = 5;
            } else {
                romanValue = "I";
                arabicValue = 1;
            }

            sb.append(romanValue);
            arabicAbs -= arabicValue;
        }

        if (arabic < 0) {
            sb.insert(0, "-");
        }

        return sb.toString();
         */
    }
}
