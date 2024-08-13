import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> openParentheses = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!process(s.charAt(i), openParentheses)) return false;
        }
        return openParentheses.isEmpty();
    }

    private boolean process(char c, Deque<Character> openParentheses) {
        switch (c) {
            case '(', '{', '[' -> openParentheses.push(c);
            case ')' -> {
                if (openParentheses.isEmpty() || openParentheses.pop() != '(') return false;
            }
            case '}' -> {
                if (openParentheses.isEmpty() || openParentheses.pop() != '{') return false;
            }
            case ']' -> {
                if (openParentheses.isEmpty() || openParentheses.pop() != '[') return false;
            }
            default -> {
                return false;
            }
        }
        return true;
    }
}