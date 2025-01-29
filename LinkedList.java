import java.util.Scanner;
public class LinkedList {
    class Node {
        int data;
        Node next;

public Node(int data) {
this.data = data;
this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
else 
{
tail.next = newNode;
tail = newNode;
        }
    }

public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int pos=0;
        int data,data1;
        System.out.println("ENTER INTEGERS TO CREATE NODES (ENTER A NON-INTEGER TO EXIT):");
        while (sc.hasNext())
        {
         
            if(sc.hasNextInt())
            {
            data = sc.nextInt();
            list.addNode(data);
            }
          else
          {
            String temp=sc.next();
            System.out.println("LINKED LIST CREATED");
            System.out.println("LINKED LIST BEFORE INSERTING");
            list.displayList();
            System.out.println("ENTER THE POSIITON WHERE YOU WANT TO INSERT");
            if(sc.hasNextInt())
            {
            pos=sc.nextInt();
            System.out.println("ENTER THE ELEMENT TO BE INSERTED:");
            if(sc.hasNextInt())
            {
            data1=sc.nextInt();
            list.insertMiddle(data1,pos);
            System.out.println("ELEMENT INSERTED");
            System.out.println("LINKED LIST AFTER INSERTING");
            list.displayList();
            }
            else
            {
              System.out.println("Enter integers only");
              System.exit(0);
            }
            }
            else
            {
              System.out.println("Enter integers only");
              System.exit(0);
            }
           }
        }
    }
public void insertMiddle(int data, int pos) {
        if (pos < 1) {
            System.out.println("Position should be greater than or equal to 1.");
            return;
        }
        
        Node newNode = new Node(data);

        // If inserting at the beginning
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Traverse to the node just before the insertion point
        Node current = head;
        int currentPos = 1;
        
        while (current != null && currentPos < pos - 1) {
            current = current.next;
            currentPos++;
        }

        // If current is null, the position is out of bounds
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        // Insert the new node at the desired position
        newNode.next = current.next;
        current.next = newNode;
    }
public void displayList() {
        Node current = head;
        while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
        }
System.out.println("null");
    }
}