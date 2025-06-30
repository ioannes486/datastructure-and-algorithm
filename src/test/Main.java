package test;

public class Main {

    static int a = 0;

    class A {
        public static void add(){
            a++;
            System.out.println(a);
        }
    }



    public static void main(String[] args) {
        System.out.println("초기화 전 : " + a);
        a++;
        System.out.println("메인메서드에서 더한 후 : " + a);
        A.add();
        System.out.println("클래스의 메서드에서 더한 후 : " + a);

    }
}
