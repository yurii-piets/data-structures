package collections.list.array.steptest;

import collections.list.List;
import collections.list.array.ArrayList;

import java.lang.reflect.Field;

public class ArrayTestHelper {

    public static int getCoolArraySize(List<?> array) throws NoSuchFieldException, IllegalAccessException {
        Field sizeField = array.getClass().getDeclaredField("size");
        sizeField.setAccessible(true);
        int size = (int) sizeField.get(array);
        sizeField.setAccessible(false);
        return size;
    }

    public static int getCoolArrayEnd(List<?> array) throws NoSuchFieldException, IllegalAccessException {
        Field endField = array.getClass().getDeclaredField("end");
        endField.setAccessible(true);
        int end = (int) endField.get(array);
        endField.setAccessible(false);
        return end;
    }

    public static Object[] getCoolArrayArray(List<?> array) throws NoSuchFieldException, IllegalAccessException {
        Field arrayField = array.getClass().getDeclaredField("elements");
        arrayField.setAccessible(true);
        Object value[] = (Object[]) arrayField.get(array);
        arrayField.setAccessible(false);
        return value;
    }

    public static boolean compareCoolArrayAndVector(List<?> coolArray, Object[] testVector) throws NoSuchFieldException, IllegalAccessException {
        Object mainArray[] = getCoolArrayArray(coolArray);

        for (int i = 0, j = 0; i < testVector.length && j < mainArray.length; ++i, ++j) {
            if (!(testVector[i] == mainArray[j] || testVector[i].equals(mainArray[j]))) {
                return false;
            }
        }

        return true;
    }

    public static boolean compareCoolArrays(List<?> coolArray, List<?> coolArray2) throws NoSuchFieldException, IllegalAccessException {
        Object[] vector = getCoolArrayArray(coolArray);
        Object[] vector2 = getCoolArrayArray(coolArray2);

        if (coolArray.size() != coolArray2.size()) {
            return false;
        }

        for (int i = 0; i < vector.length; ++i) {
            if (vector[i] != (vector2[i])) {
                return false;
            }
        }

        return true;
    }

    public static Object[] createTestArray(){
        return createTestArray(25);
    }

    public static Object[] createTestArray(int size){
        Integer testVector[] = new Integer[size];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        return testVector;
    }
}
