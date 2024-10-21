package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        List<String> ansList = new ArrayList<>();
        int openedBrackets = 0;
        int closedBrackets = 0;
        backTrack(n, stack, ansList, openedBrackets, closedBrackets);

        return ansList;

    }

    public static void backTrack(int n, Stack<String> stack, List<String> ans, int openedBrackets, int closedBrackets) {
        //all brackets are used
        if(openedBrackets == n && closedBrackets == n) {
            System.out.println(stack);
            Iterator<String> iterator = stack.iterator();
            StringBuilder sb = new StringBuilder();
            while(iterator.hasNext()) {
                sb.append(iterator.next());
            }
            ans.add(sb.toString());
        }
        //we still have opened brackets with us, so use them
        if(openedBrackets < n) {
            stack.add("(");
            //we used one open bracket here, so increment its value
            backTrack(n, stack, ans, openedBrackets + 1, closedBrackets);
            //backtracking - so pop here after returning
            stack.pop();
        }
        //if we have closed brackets with us and its count < opened brackets, then use them
        if(closedBrackets < openedBrackets) {
            stack.add(")");
            backTrack(n, stack, ans, openedBrackets, closedBrackets + 1);
            //backtracking - so pop here after returning
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }
}
