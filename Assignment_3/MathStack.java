import java.util.StringTokenizer;

public class MathStack {
    public static void main(String args[]){
        int num1;
        int num2;
        String thisToken;
        GenericStack<String> expression = new GenericStack<>(2);

        // get an expression from the console that is written all funny
        System.out.print("Enter a mathmatical expression in infixed notation: ");
        String s = System.console().readLine();
        StringTokenizer tokens = new StringTokenizer(s); // tokenizer will cut out the white space and make the individual words/numbers/whatever into 'tokens'

        // the if statement looks for, if an operator is the next token. If so it executes the operation on the last 2 popped integers and pushes the answer onto the stack
        while(tokens.hasMoreTokens()){
            thisToken = tokens.nextToken();
            if(thisToken.equals("+")){                 // If token == +
                num2 = Integer.valueOf(expression.pop());       // pop int 2
                num1 = Integer.valueOf(expression.pop());       // pop int 1
                expression.push(Integer.toString(num1 + num2)); // push 1 + 2  and so on and so forth for the other operators
            } else if(thisToken.equals("-")){
                num2 = Integer.valueOf(expression.pop());
                num1 = Integer.valueOf(expression.pop());
                expression.push(Integer.toString(num1 - num2));
            } else if(thisToken.equals("*")){
                num2 = Integer.valueOf(expression.pop());
                num1 = Integer.valueOf(expression.pop());
                expression.push(Integer.toString(num1 * num2));
            } else if(thisToken.equals("/")){
                num2 = Integer.valueOf(expression.pop());
                num1 = Integer.valueOf(expression.pop());
                expression.push(Integer.toString(num1 / num2));
            } else{
                expression.push(thisToken); // this little guy pushes all of the numbers onto the stack before we hit operators
            }            
        }
        System.out.println("The Answer is: " + expression.pop()); //print the final answer to the console
    }
}
