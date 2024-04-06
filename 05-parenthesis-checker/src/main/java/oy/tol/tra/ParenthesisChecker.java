package oy.tol.tra;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      int count = 0;

      for (int i = 0; i < fromString.length(); i++) {
         char ch = fromString.charAt(i);
         if (ch == '(' || ch == '[' || ch == '{') {
            try {
               stack.push(ch);
               count++;
            } catch (StackAllocationException e) {
               throw new ParenthesesException("Stack allocation failed", ParenthesesException.STACK_FAILURE);
            }
         } else if (ch == ')' || ch == ']' || ch == '}') {
            if (stack.isEmpty()) {
               throw new ParenthesesException("There are too many closing parentheses", ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
            }
            char open = stack.pop();
            if (open == '(' && ch != ')' || open == '[' && ch != ']' || open == '{' && ch != '}') {
               throw new ParenthesesException("Wrong kind of parenthesis were in the text.", ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
            }
            count++;
         }
      }
      
      if (!stack.isEmpty()) {
         throw new ParenthesesException("There are too few closing parentheses.", ParenthesesException.TOO_FEW_CLOSING_PARENTHESES);
      }
      
      return count;
   }
}
