

public class Main {

    public static void main(String[] args) {
        out:
        for (int i=1; i<=10000; i++){
            for (int j=1; j<=i; j++){
                int sum = j; // 초기 합
                int number = j; // 일의 자리부터 N번째 자리까지 더하기

                while (number != 0) {
                    sum += number % 10;
                    number /= 10;
                }

                if(sum == i){
                    continue out;
                }
            }
            System.out.println(i);
        }
    }
}
