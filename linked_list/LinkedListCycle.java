package linked_list;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        //since fastPointer moving fast, run the loop until it is and it's next node not equal to null
        while(fastPointer != null && fastPointer.next != null) {
            //fastPointer moving speed of 2
            fastPointer = fastPointer.next.next;
            //slowPointer moving speed of 1
            slowPointer = slowPointer.next;
            //if at any point, fastPointer meets slowPointer i.e., fastPointer == slowPointer,
            //then we can say the linked list has cyclic nature in it, so return true
            if(fastPointer == slowPointer) return true;

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,0,-4};
        ListNode head = ListNode.arrayToListNode(arr);
        boolean result = hasCycle(head);
        System.out.println(result);
    }
}
