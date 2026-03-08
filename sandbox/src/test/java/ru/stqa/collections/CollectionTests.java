package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTests {

    @Test
    void arrayTests() {
        //var array = new String[3];
        var array = new String[] {"a", "b", "c"};
        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);

        array[0] ="d";
        Assertions.assertEquals("d", array[0]);
    }


    @Test
    void listTests() {
        //var list = List.of("a", "b", "c"); // немодифицируемый

        //или можно так. сначала создался немоцифицируемый список, а затем он делается модифицируемым
        var list = new ArrayList<String>(List.of("a", "b", "c", "a"));

        //var list = new ArrayList<String>(); модифицируемый список
        //Assertions.assertEquals(0, list.size());

        //list.add("a");
        //list.add("b");
        //list.add("c");
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0,"d");
        Assertions.assertEquals("d", list.get(0));
    }

    @Test
    void setTests() {
        var set = new HashSet<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(3, set.size());
        //var element = set.stream().findAny().get(); //получить элемент множества

        set.add("d"); //добавление в множество
        Assertions.assertEquals(4, set.size());
    }
}


