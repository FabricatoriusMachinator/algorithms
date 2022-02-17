package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils{
    @java.lang.Override
    public int min(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int value = array[0];
        for (int i=1; i < array.length; i++) {

           if(value > array[i]){
                   value = array[i];
            }
        }
        return value;
    }

    @java.lang.Override
    public int max(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int value = array[0];
        for (int i=1; i < array.length; i++) {

            if(value < array[i]){
                value = array[i];
            }
        }
        return value;
    }

    @java.lang.Override
    public double mean(int[] array) throws IllegalArgumentException {

        int sum = array[0];
        for(int i = 1; i < array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }

    public void checkArray(int array[]) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array is empty");
    }
}
