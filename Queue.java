/**
 * Demonstration of Queues.
 * @author -Hayden Seiberlich
 * @version - 10/17/24
 */
public class Queue {
    //Array.
    private int[] elements;
    //Constant
    private static final int CAPACITY = 100;

    //Varble for size check.
    private int size;

    //Variables to keep track of the queue position.
    private int front;
    private int rear;

    //Constructor for the variables and array.
    public Queue() {
        elements = new int[CAPACITY];
        front = 0;
        //Rear keeps track of index.
        rear = -1;
        size = 0;
    }

    /**
     * Method to retrieve the size of the array.
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if the array is empty.
     */
    public boolean isEmpty() {
        //
        return size == 0;
    }

    /**
     * Method to check if the array is full.
     */
    public boolean isFull() {
        return size == CAPACITY;
    }

    /**
     * Method to insert into the queue -> ENQUEUE
     */
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("LMAO no");
        } else {
            rear = (rear + 1) % CAPACITY;
            elements[rear] = item;
            size++;
        }
    }

    /**
     * Method to remove from the queue -> dequeue
     */
    public int dequeue() {
        if(isEmpty()) {
            return -1;
        }
        //elements[front] -> fetching the front element.
        int item = elements[front];
        front = (front + 1) % CAPACITY;
        size--;
        return item;
    }

    /**
     * Method to determine the next element in the array.
     */
    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return elements[front];
        }
    }

    /**
     * Method to determine if the array contains element item.
     * @param item - the value to be searched for in the array.
     * @return - boolean is the value (true or false) of the element, if it is found or not.
     */
    public boolean contains(int item) {
        for(int i = front; i < size; i++) {
            if(item == elements[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to remove duplicates from the array.
     */
    public void removeDUP() {
       Queue queue2 = new Queue();
       int count = 0;

        int[] index = new int[CAPACITY];
       int index_k = 0;

        for(int i = 0; i <= size - 1; i++) {
           for(int j = i + 1; j <= size; j++) {
               if(elements[i] == elements[j]) {
                   index[index_k++] = j;
               }
           }
       }
        //Displays what indexes hold duplicate values.
//        for(int k = 0; k < index_k; k++) {
//            System.out.println("-> " + index[k]);
//        }

        //Variable for the duplicate index.
        int index_k2 = 0;
        for(int m = 0; m <= size; m++) {
            if (m != index[index_k2]) {
                queue2.enqueue(elements[m]);
                count++;
            } else {
                index_k2++;
            }
        }

        //Displays what indexes hold duplicate values.
        for(int k = 0; k < count; k++) {
            System.out.println("-> " + queue2.dequeue());
        }
    }

    public static void main(String[] eeeeeeee) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println(queue.peek());

        queue.dequeue();
        System.out.println(queue.peek());

        System.out.println(queue.contains(1));
        System.out.println(queue.contains(4));

        queue.removeDUP();
    }
}
