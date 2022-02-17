package org.pg4200.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {

    public MyArrayListInteger getInstance(){

        return new MyArrayListInteger();
    }

    private MyArrayListInteger list;

    @BeforeEach
    public void initTest(){
        list = getInstance();
    }

    @Test
    public void testEmpty(){
        assertEquals(0, list.size());
    }

    @Test
    public void testAdd(){
        int n = list.size();
        list.add(11);
        assertEquals(n+1, list.size());
    }

    @Test
    public void testAddAndGet(){
        list.add(9);
        int res = list.get(0);
        assertEquals(9,res);
    }

    @Test
    public void testAddFive(){
        int a = 1;
        int b = 5;
        int c = 7;

        list.add(a);
        list.add(c);
        list.add(b);
        list.add(a);
        list.add(c);

        assertEquals(a, list.get(0));
        assertEquals(c, list.get(1));
        assertEquals(b, list.get(2));
        assertEquals(a, list.get(3));
        assertEquals(c, list.get(4));
    }

    @Test
    public void testOutOfIndex(){
        assertEquals(0,list.get(73));
        assertEquals(0,list.get(15));
    }
}
