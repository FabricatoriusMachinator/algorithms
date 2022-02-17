package org.pg4200.les01.arraylist;


import org.pg4200.ex01.MyArrayListResizable;
import org.pg4200.les02.list.MyList;
import org.pg4200.les02.list.MyListTestTemplate;



public class MyArrayListResizableTest extends MyListTestTemplate {


    @Override
    protected <T> MyList<T> getNewInstance(Class<T> klass) {
        return new MyArrayListResizable<>(1);
    }
}
