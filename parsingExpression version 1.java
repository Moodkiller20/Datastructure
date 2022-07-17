// Name: Giovanni Tshibangu
// Homework 3 part 1:

//        Write a program that performs the following two tasks:
//
//        Part 1: Reads an arithmetic expression in an infix form, stores it in a queue (infix queue) and converts it to a postfix form (saved in a postfix queue).  Must use the operator stack, see lecture notes.
//        Part 2: Evaluates the postfix expression using the value stack.
//        Write a program that performs the following two tasks:
//
//        Part 1: Reads an arithmetic expression in an infix form, stores it in a queue (infix queue) and converts it to a postfix form (saved in a postfix queue).  Must use the operator stack, see lecture notes.
//        Part 2: Evaluates the postfix expression using the value stack.



// Instead of implementing my Node,Queue and stack class with integers, I am using Char instead.

// Node class
class Node {
    private char data;
    private Node next;

    public Node() {
        this('#', null);
    }

    public Node(char d) {
        data = d;
    }

    public Node(char d, Node n) {
        data = d;
        next = n;
    }
    public Node(int d, Node n) {
        data = 0;
        next = n;
    }

    public void setData(char newData) {
        data = newData;
    }
    public void setData(int newData) {
        data = (char) newData;
    }
    public void setNext(Node newNext) {
        next = newNext;
    }

    public char getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void displayNode() {
        System.out.print(data);
    }
}
// Queue interface
interface LLQueue {

    public void enqueue(char item);

    public char dequeue();

    public int size();

    public boolean empty();

    public int front();

}
// Queue ADT class
class LLQueueADT implements LLQueue {

    private int size;
    private Node front;
    private Node rear;

    public LLQueueADT() {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty() {
        return (size == 0);
    }

    public void enqueue(char c) {
        Node newNode = new Node();
        newNode.setData(c);
        newNode.setNext(null);
        if (this.empty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    public char dequeue() {
        char i;
        i = front.getData();
        front = front.getNext();
        size--;
        if (this.empty()) {
            rear = null;
        }
        return i;
    }

    public int front() {
        return front.getData();
    }

    public int size() {
        return size;
    }
}
// Stack interface
interface LLStack {

    public void push(char item);

    public char pop();

    public int size();

    public boolean empty();

    public char ontop();

}
// Stack ADT class
class LLStackADT implements LLStack {

    private Node top;
    private int size;

    public LLStackADT() {
        top = null;
        size = 0;
    }

    public boolean empty() {
        return (top == null);
    }

    public void push(char c) {
        Node newNode = new Node();
        newNode.setData(c);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    public void push(int c) {
        Node newNode = new Node();
        newNode.setData(c);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public char pop() {
        char i;
        i = top.getData();
        top = top.getNext();
        size--;
        return i;
    }

    public char ontop() {
        char i = pop();
        push(i);
        return i;
    }
    public int size() {
        return size;
    }

}



class parsingExpression{

    // Initialize the variable needed for the program.
    private static LLQueueADT inFixQ;
    private static  LLQueueADT postFixQ;
    private static LLStackADT operatorStack;
    private static LLStackADT valueStack;

    // stackPriority method.
    public static int stackPriority(char c) {
        switch (c) {
            case ')':
            case '#':
                return 0;
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '(':
                return 3;
        }
        return -1;
    }
    public static void infixTopostFix(String expression){
         inFixQ =new LLQueueADT();
         postFixQ = new LLQueueADT();
         operatorStack = new LLStackADT();
        operatorStack.push('#');
        for (int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) != ' ')
                inFixQ.enqueue(expression.charAt(i));
        }
        while(!inFixQ.empty())
        {
            int x = inFixQ.dequeue();
            char s= (char)x;
            if(s =='(')
               // operatorStack.push(s);
                System.out.println();

            else if(Character.isLetterOrDigit(s))
            {
                postFixQ.enqueue(s);
            }
            else if(s == ')')
            {
                while(!operatorStack.empty() && ((char)operatorStack.ontop())!='(')
                {
                    postFixQ.enqueue(operatorStack.pop());
                }
            }
            else
            {
                int priority1 = stackPriority(s);
                int priority2 = stackPriority(operatorStack.ontop());
                while(priority1 < priority2)
                {
                    postFixQ.enqueue(operatorStack.pop());
                    priority2 = stackPriority(operatorStack.ontop());
                }
                operatorStack.push(s);
            }
        }
    }
    // evaluatePostfix method
    static int evaluatePostfix(String expression){
        // Initialize the "ValueStack"
        valueStack = new LLStackADT();

        // Loop through the String Array Expression
        for(int i =0; i<expression.length(); i++){
            char e = expression.charAt(i);

            if(Character.isDigit(e)){
                valueStack.push(e);
            }

            else{
                int v1 = valueStack.pop();
                int v2 = valueStack.pop();
                if (e == '+') {
                    valueStack.push(v2 + v1);
                }
                else if (e == '-') {
                    valueStack.push(v2 - v1);
                }
                else if (e == '*') {
                    valueStack.push(v2 * v1);
                }
                else if (e == '/') {
                    valueStack.push(v2 / v1);
                }
                 }
        }
        // Return the last element.
        return valueStack.pop();
    }

    // Main method --- Driver class
        public static void main(String[] args){

        // infixTopostFix method take in expression as a String
        // The queue and stack classes will store these variables as "Char"


        // Case 1 : A*B+(C-D/E)   ---> expexted results : AB*CDE/-+ #
        // Case 2 : C/D*(B+A)   ---> expexted results : CDB*/A+ #
        // Case 3 : A*(D/E)   ---> expexted results : ADE/* #


           infixTopostFix("A*B+(C-D/E)");
            System.out.println ("=======================================");
            System.out.println ("Postfix expression: ");

            System.out.println (evaluatePostfix("231*+9-"));

            while(!postFixQ.empty())
            {
                System.out.print (postFixQ.dequeue() + " ");
            }

        }





        }


