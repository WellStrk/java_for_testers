package ru.stqa.addressbook.common;

import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random(); //ф-ция рандомайзер
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26)); //генерация чисел от 0 до 25
        }
        return result;
    }
}
