package linked_list;

public class MergeTwoSortedLinkedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //take a node to store all sorted linked list nodes
        ListNode node = new ListNode(0);
        //dummy as a pointer at the head of the node
        ListNode dummy = node;
        //if both nodes head's are not null, then we'll check for sorting
        while(list1 != null && list2 != null) {
            //if head at list1.val < head at list2.val, then take list1 as node's next node, else list2
            if(list1.val < list2.val) {
                node.next = list1;
                //moving the head pointer of list1 by list1.next
                list1 = list1.next;
            } else {
                node.next = list2;
                //moving the head pointer of list2 by list2.next
                list2 = list2.next;
            }
            //moving the head pointer of node to its next node
            node = node.next;
        }
        if(list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};
        ListNode list1 = ListNode.arrayToListNode(arr1);
        ListNode list2 = ListNode.arrayToListNode(arr2);
        ListNode resultNode = mergeTwoLists(list1, list2);
        ListNode.printListNode(resultNode);
    }
}
