package linked_list;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Method to convert an array to a ListNode
    public static ListNode arrayToListNode(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]); // Create the head node
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]); // Create the next node
            current = current.next; // Move to the next node
        }

        return head;
    }

    // Method to print the ListNode for verification
    public static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
  }

// 1 -> 2 -> 3 -> 4 -> 5
// 1 <- 2 <- 3 <- 4 <- 5

public class ReverseLinkedList {

    /* swapping the linking between two nodes
     * prev -> current -> next_node
     * for swapping the links, take current node and change its linking of next_node to previous
     * current -> next_node becomes current -> prev
     * prev <- current <- next_node
     * then for next loop, current node will become prev, and next_node become current node
     */

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            //storing the next_node
            ListNode next_node = current.next;
            //changing the linking of current node next to previous node
            current.next = prev;
            //for next iteration, current node become previous node
            prev = current;
            //and, next_node becomes current node
            current = next_node;
        }
        //return previous where it contains the head of the reversed linked list
        return prev;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arrayToListNode(nums);
        ListNode reversedList = reverseList(head);
        ListNode.printListNode(reversedList);
    }
}
