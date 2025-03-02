/**
 * Demonstrations of stacks.
 * @author - Hayden Seiberlich
 * @version - 10/17/24
 */
public class Stack {
    private int[] elements;
    private static final int MAX_SIZE = 100;
    private int top;

    public Stack() {
        elements = new int[MAX_SIZE];
        top = -1;
    }

    //Check if a stack is empty
    public boolean isEmpty() {
        //elements == null; //Null reference

        //Method 2
        return top == -1;
    }

    //Get the number of elements
    public int size() {


        //Method 2
        return top+1;
    }

    //Add something to a stack -- PUSH
    public void push(int data){
        if (top < MAX_SIZE){
            elements[++top] = data;
        }
    }

    //To check the element on top -- PEEK
    public int peek(){
        if(!isEmpty()){
            return elements[top];
        }
        return -1;
        //return Integer.MIN_VALUE;
    }

    // Remove top -- POP
    public int pop(){
        if(!isEmpty()){
            return elements[top--];
        }
        return -1;
        //return Integer.MIN_VALUE;
    }


    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(stack.size());

        stack.pop();
        stack.push(50);
        System.out.println(stack.peek());


        //Reverse stack
        Stack reverse = new Stack();
        while(!stack.isEmpty()){
            reverse.push(stack.pop());
        }
        System.out.println(reverse.peek());

        //MAX
        int max_ = stack.pop();
        while(!stack.isEmpty()){
            int max_2 = stack.pop();
            if(max_ < max_2)
            {
                max_ = max_2;
            }
        }
        System.out.println(max_);
    }
}