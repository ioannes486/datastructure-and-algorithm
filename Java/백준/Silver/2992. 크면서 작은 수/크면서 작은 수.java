import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static int X;
    static int result;
    static int max_x;



    static int[] convertNumberIntoSortedArray(int number, int x_length){
        int[] arr = new int[x_length];

        int idx = x_length-1;
        while (number > 0) {
            int new_number = number % 10;
            arr[idx] = new_number;
            number = number / 10;
            idx--;
        }

        Arrays.sort(arr);
        return arr;
    }


    static void recur(int number, int x_length, int[] x_arr){

        if (number > max_x) {
            result = 0;
            return;
        }

        int[] sortedArray = convertNumberIntoSortedArray(number, x_length);
        if (Arrays.equals(sortedArray, x_arr)){
            if (number > X){
                result = number;
                return;
            }
        }
        recur(number +1, x_length, x_arr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int x_length = line.length();
        X = Integer.parseInt(line);
        int[] x_arr = convertNumberIntoSortedArray(X, x_length);
        // x가 가질 수 있는 최댓값

        max_x = 0;
        for (int i = 0; i<x_length; i++) {
            int power = (int) Math.pow(10, i);
            max_x = max_x + x_arr[i] * power;
        }

        recur(X+1, x_length, x_arr);

        System.out.println(result);

    }
}


