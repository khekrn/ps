package list;

/**
 * Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Given the heads of two singly linked-lists headA and headB, return the
 * node at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 * 
 * Note that the linked lists must retain their original structure after
 * the function returns.
 * 
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5],
 * skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be
 * 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5].
 * From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the
 * intersected node in A; There are 3 nodes before the intersected node in B.
 * 
 * Note that the intersected node's value is not 1 because the nodes with value
 * 1 in A
 * and B (2nd node in A and 3rd node in B) are different node references. In
 * other words,
 * they point to two different locations in memory, while the nodes with value 8
 * in
 * A and B (3rd node in A and 4th node in B) point to the same location in
 * memory.
 * 
 * Example 2:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it
 * reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 * while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * 
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        var aPointer = headA;
        var bPointer = headB;
        while(aPointer != bPointer){
            if(aPointer == null){
                aPointer = headB;
            }else{
                aPointer = aPointer.next;
            }

            if(bPointer == null){
                bPointer = headA;
            }else{
                bPointer = bPointer.next;
            }
            
        } 
        return aPointer;
    }

    public static void main(String[] args) {
        var interSection = new Intersection();
        var a = new int[]{4,1,8,4,5};
        var b = new int[]{5,6,1,8,4,5};

        ListNode headA = new ListNode(a[0]);
        fillListData(a, headA);

        ListNode headB = new ListNode(b[0]);
        fillListData(b, headB);

        print(headA);
        print(headB);

        var result = interSection.getIntersectionNode(headA, headB);
        System.out.println(result);
    }

    private static void fillListData(int[] a, ListNode headA) {
        ListNode aCurrent = headA;
        for(int i = 1; i < a.length; i++){
           var temp = new ListNode(a[i]);
           aCurrent.next = temp;
           aCurrent = temp;
        }
    }

    private static void print(ListNode node){
        var builder = new StringBuilder();
        builder.append("[");
        while(node != null){
            builder.append(node.val).append(",");
            node = node.next;
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        System.out.println("Node = "+ builder.toString());
    }
}
