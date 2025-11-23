import java.io.BufferedReader;
import java.io.InputStreamReader;

/*TODO:
- 상수
    게임은 3 X 3격자판이다.
- 변수

- 조건
    1. 반드시 첫번째 사람이 X를 놓고 두번째 사람이 O를 놓는다
    2. 어느 때든지 한 사람의 말이 가로, 세로, 대각선 방향으로 3칸을 잇는데 성공하면 게임은 즉시 끝난다.
    3. 게임판이 가득 차도 게임은 끝난다.

- 구하는 값
    게임판의 상태가 주어지면 그 상태가 틱택토 게임에서 발생할 수 있는 최종 상태인지 판별하시오
    최종 상태인게 가능할 경우       valid,
    최종 상태인게 불가능할 경우     invalid

- 아이디어

- 고민 사항
    어떤 조건을 가장 먼저 분기해야 할까?
    최종상태의 정의란?
    -> 게임판이 가득 찼거나, 가로 세로 대각선 방향으로 3칸을 잇는데 성공하는 경우

    가로, 세로 대각선방향으로 3칸이 다 되어야 하나?
    -> 그건 예제를 보면 알 수 있을 듯
    1.
    XXX
    OO.
    XXX -> invalid

    2.
    XOX
    OXO
    XOX

    2
    XXX
    OO.
    XXX

    4.
    XXO
    OOX
    XOX

    XO.OX...X

    5
    XO.
    OX.
    ..X -> 판이 다 꽉 차지 않았는데 최종 상태로 vailid인걸 봐서 셋 중 하나면 되어도 valid인듯

    6.
    .XX
    X.X
    OOO -> O가 이겼는데 X개수가 하나 더 많다.

    7.t
    X.O
    O..
    X.. -> 아무도 이기지 않았다.

    말 놓은 것만 보고 순서는 판단하지 못하나??
    일단 예제를 유심하게 보자



- 문제해결 순서
    0. 나올 수 없는 경우
        X가 5개를 초과하거나
        O가 4개를 초과하는 경우
        승부가 났는데 말이 모든 말

    1. 판이 다 찼을 때
        1.1. 승부가 났을 때
            무조건 x가 5개고 o가 4개임

        1-2. 승부가 나지 았았을 때
           xoxoxoxoxox 로 이어지는 순서가 맞지 않는 경우 -> X가 5개이고 O가 4개가 아닌 경우는 전부 invalid임
           나머지 경우는 valid


    2. 판이 다 차지 않았을 때

        2-1. 승부가 났을 때
            O가 이기면 두개 개수 가 같음
            X가 이기면 X가 하나 더 많음

        2-2. 승부가 나지 않았을 때
            무조건 invalid - 가로, 세로 대각선 모두 3개짜리가 없을 때


*/
public class Main {
    static char[] ticTacToe;
    static final String VALID = "valid";
    static final String INVALID = "invalid";
    static final String END = "end";


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(END)) break;

            ticTacToe = line.toCharArray();
            System.out.println(isValid());
        }
    }

    static int[] count() {
        int xNum = 0;
        int oNum = 0;
        for (char character : ticTacToe) {
            if (character == 'X')
                xNum++;
            else if (character == 'O')
                oNum++;
        }
        return new int[]{oNum, xNum};
    }

    static boolean areMarksInARow(char mark) {

        if (ticTacToe[0] == mark && ticTacToe[1] == mark && ticTacToe[2] == mark) return true;
        if (ticTacToe[3] == mark && ticTacToe[4] == mark && ticTacToe[5] == mark) return true;
        if (ticTacToe[6] == mark && ticTacToe[7] == mark && ticTacToe[8] == mark) return true;
        if (ticTacToe[0] == mark && ticTacToe[3] == mark && ticTacToe[6] == mark) return true;
        if (ticTacToe[1] == mark && ticTacToe[4] == mark && ticTacToe[7] == mark) return true;
        if (ticTacToe[2] == mark && ticTacToe[5] == mark && ticTacToe[8] == mark) return true;
        if (ticTacToe[0] == mark && ticTacToe[4] == mark && ticTacToe[8] == mark) return true;
        if (ticTacToe[2] == mark && ticTacToe[4] == mark && ticTacToe[6] == mark) return true;
        return false;
    }

    static String isValid() {
        int[] counts = count();
        int oNum = counts[0];
        int xNum = counts[1];
        boolean oWin = areMarksInARow('O');
        boolean xWin = areMarksInARow('X');


        // 0. X와 O의 개수 차이가 0 또는 1이 아니면 불가능
        if (!(xNum == oNum || xNum == oNum + 1)) return INVALID;

        // 1. 둘 다 이기면 안됨
        if (xWin && oWin) return INVALID;

        // 2. X가 이겼을 때는 항상 개수가 O보다 하나 많아야 함
        if (xWin) {
            if (xNum == oNum + 1) return VALID;
            return INVALID;
        }

        // 3. O가 이겼을 때는 항상 O의 개수가 x와 같아야 함
        if (oWin) {
            if (xNum == oNum) return VALID;
            return INVALID;
        }

        // 4. 아무도 이기지 않았을 때는 판이 꽉 차있어야 함
        if (xNum + oNum == 9) return VALID;

        return INVALID;
    }
}


