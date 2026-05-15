static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if (head == null) {
        return newNode;
    }
    SinglyLinkedListNode temp = head;

    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = newNode;

    return head;
}