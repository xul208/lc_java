import java.util.Arrays;
import java.util.Objects;

public class LC23 {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode root = new ListNode(0);
            ListNode current = root;
            while (Arrays.stream(lists).anyMatch(Objects::nonNull)) {
                int minVal = Integer.MAX_VALUE;
                int minNodeIndex = 0;
                int i = 0;
                for (; i < lists.length; ++i) {
                    if (lists[i] != null && lists[i].val < minVal) {
                        minNodeIndex = i;
                        minVal = lists[i].val;
                    }
                }
                current.next = lists[minNodeIndex];
                assert lists[minNodeIndex] != null;
                lists[minNodeIndex] = lists[minNodeIndex].next;
                current = current.next;
            }
            return root.next;
        }
    }
}
