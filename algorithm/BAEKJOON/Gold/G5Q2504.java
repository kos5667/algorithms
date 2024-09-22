package Gold;

import java.util.Stack;

/**
 * @questionNo 2504
 * @questionTitle 괄호의 값
 * @questionLevel 5
 * @isComplete false
 * @since 2023-03-29
 */
public class G5Q2504 {
    /**
     * ‘()’ 인 괄호열의 값은 2이다.
     * ‘[]’ 인 괄호열의 값은 3이다.
     * ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
     * ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
     * 올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
     */
    final static String X1 = "(", X2 = ")";
    final static String Y1 = "[", Y2 = "]";
    public static void main(String[] args) {
        String temp = "(()[[]])([])";

        Stack<String> stk = new Stack<String>();

        for (String c : temp.split("")) stk.push(c);

        for (String c : stk)
            stk.pop();


    }
}
