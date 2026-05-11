static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

    DoublyLinkedListNode current = head;
    DoublyLinkedListNode temp = null;

    while (current != null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
    }

    if (temp != null) {
        head = temp.prev;
    }

    return head;
}