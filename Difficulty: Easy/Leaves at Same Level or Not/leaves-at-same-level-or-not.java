//{ Driver Code Starts
// Initial Template for Java

// INITIAL CODE
import java.io.*;
import java.lang.*;
import java.util.*;

// A Binary Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Is_Leaves_At_Same_Level {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    // driver function to test the above functions
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution g = new Solution();
            boolean b = g.check(root);
            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    boolean check(Node root) {
        // Your code here
        if (root == null) {
            return false;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        int leafLevel = -1;
        int currentLevel = 0;
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = q.poll();
                
                if (currentNode.left == null && currentNode.right == null) {
                    if (leafLevel == -1) {
                        leafLevel = currentLevel;
                    } else if (currentLevel != leafLevel) {
                        return false;
                    }
                }
                
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }
            
            currentLevel++;
        }
        
        return true;
    }
}
