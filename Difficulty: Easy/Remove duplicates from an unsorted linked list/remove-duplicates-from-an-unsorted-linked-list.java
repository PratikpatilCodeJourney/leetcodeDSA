//{ Driver Code Starts
import java.io.*;
import java.util.HashSet;


// } Driver Code Ends

/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // Your code here
        HashSet<Integer> seen = new HashSet<>();
        Node dumyList = new Node(0);
        dumyList.next = head;
        Node curr = head;
        Node prev = dumyList;
        
        while (curr != null) {
            if (seen.contains(curr.data)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                seen.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dumyList.next;
    }
}



//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            return temp;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            Node head = null;
            String[] str = read.readLine().trim().split(" ");
            for (String s : str) {
                head = insert(head, Integer.parseInt(s));
            }
            Solution g = new Solution();
            head = g.removeDuplicates(head);
            printList(head);
        }
    }
}

// } Driver Code Ends