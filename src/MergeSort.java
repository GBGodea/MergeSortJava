import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MergeSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> strings = Arrays.asList("Hello", "World", "Hello", "Abc", "Ab", "ddd", "Aa");
        strings.sort((e1, e2) -> e1.charAt(0) - e2.charAt(0));
        System.out.println("Java function completed in: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        divide(Arrays.asList("Hello", "World", "Hello", "Abc", "Ab", "ddd", "Aa"));
        System.out.println("Merge sort function completed in: " + (System.currentTimeMillis() - start));
    }

    public static List<String> divide(List<String> listOfStrings) {
        if (listOfStrings.size() <= 1) {
            return listOfStrings;
        }

        int divideSize = listOfStrings.size() / 2;

        List<String> leftSide = new ArrayList<>();
        List<String> rightSide = new ArrayList<>();

        for (int i = 0; i < divideSize; i++) {
            leftSide.add(listOfStrings.get(i));
        }

        for (int i = divideSize; i < listOfStrings.size(); i++) {
            rightSide.add(listOfStrings.get(i));
        }

        leftSide = divide(leftSide);
        rightSide = divide(rightSide);

        return merge(leftSide, rightSide);
    }

    public static List<String> merge(List<String> left, List<String> right) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while(i < left.size() && j < right.size()) {
            if (left.get(i).charAt(0) < right.get(j).charAt(0)) {
                result.add(k++, left.get(i++));
            } else {
                result.add(k++,right.get(j++));
            }
        }

        while(i < left.size()) {
            result.add(k++, left.get(i++));
        }

        while(j < right.size()) {
            result.add(k++, right.get(j++));
        }
        return result;
    }

}
