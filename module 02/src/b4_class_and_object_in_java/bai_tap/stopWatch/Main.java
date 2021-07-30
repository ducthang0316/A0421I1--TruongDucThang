package b4_class_and_object_in_java.bai_tap.stopWatch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i= 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 100000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.StartTime();
        Arrays.sort(arr);
        stopWatch.stop();
        System.out.println("it take " + stopWatch.getElapsedTime() + " millisecond to sort this array");
    }
}
