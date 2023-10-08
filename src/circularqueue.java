import javax.swing.plaf.synth.SynthLookAndFeel;

public class circularqueue {
    static int[] arr;
    int front;
    int rear;
    int size;

    circularqueue() {
        size = 5;
        arr = new int[size];
        front = -1;
        rear = -1;

    }

    void push(int data) {
        //chech for overflow condition
        if ((front == 0 && rear == size - 1) && rear == (front - 1) % (size - 1)) {
            System.out.print("QUEUE IS FULll");

        } else if (front == -1) {
            front = 0;
            rear = 0;
        }
        else if (rear == size-1 && front != 0) {
            rear = 0;

        } else {
            rear++;
        }
        arr[rear] = data;

    }

    int pop() {
        // if empty or not
        if (front == -1) {
            System.out.print("QUEUE IS EMPTY");

        }
        int ans = arr[front];
        arr[front] = -1;
        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return ans;
    }

    public static void  main(String[] args){
        circularqueue c=new circularqueue();
        c.push(5);
        c.push(3);
        c.push(9);
        c.pop();
        c.push(10);
        c.push(1);
        c.push(12);
        c.pop();
        c.push(14); 
        //System.out.print(top);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }


    }
}
