import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //1. tc용 for문 넣기
        for (int tc = 0; tc < T; tc++){
            String inputString = br.readLine();
            System.out.println(solve(inputString));
        }
    }

    static int solve(String inputString){

        // l과 l사이에 다른 알파벳이 있는 경우
        if (inputString.contains("lol")) return 0;

        if (
                inputString.contains("lal") 
                || inputString.contains("lbl")
                || inputString.contains("lcl")
                || inputString.contains("ldl")
                || inputString.contains("lel")
                || inputString.contains("lfl")
                || inputString.contains("lgl")
                || inputString.contains("lhl")
                || inputString.contains("lil")
                || inputString.contains("ljl")
                || inputString.contains("lkl")
                || inputString.contains("lll")
                || inputString.contains("lml")
                || inputString.contains("lnl")
                || inputString.contains("lpl")
                || inputString.contains("lql")
                || inputString.contains("lrl")
                || inputString.contains("lsl")
                || inputString.contains("ltl")
                || inputString.contains("lul")
                || inputString.contains("lwl")
                || inputString.contains("lxl")
                || inputString.contains("lyl")
                || inputString.contains("lzl")
        ) return 1;
        
        if (inputString.contains("ll")
                || inputString.contains("lo")
                || inputString.contains("ol")
        ) return 1;

        if (inputString.contains("l")
                || inputString.contains("o")
        ) return 2;

        // 수정을 해야 하는경우
        return 3;
    }
}


