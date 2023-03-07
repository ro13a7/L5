import java.util.Objects;

public class CircularlyLinkedList<E> {
    private Node<E> tail=null;
    private int size=0;

    public CircularlyLinkedList() {
    }
    public boolean isEmpty()
   {
     return size==0;
   }
    public int size()
   {
     return size;
   }
    public E first()
    {
        if(isEmpty())return null;
        return tail.next.element;
    }
    public E last()
    {
        if(isEmpty())return null;
        return tail.element;
    }
    public void addFirst(E e)
    {

        if(isEmpty())
        {
            tail=new Node<>(e,null);
            tail.next=tail;
        }
        else {
            tail.next =  new Node<>(e, tail.next);
        }
        size++;
    }
    public void addLast(E e)
    {
        addFirst(e);
        tail=tail.next;
    }

    public E removeFirst()
    {
        if(isEmpty()) return null;
        Node<E> x=tail.next;
        if (x==tail)tail=null;
        else
        tail.next=x.next;
        size--;
        return x.element;
    }
    public void rotate()
    {
        if (!isEmpty()) //if(tail!=null)
        tail=tail.next;
    }
    public int size2()
    {
        int size2=0;
        Node<E> x=tail;
        while (tail.next!=x)
        {
            size2++;
            tail=tail.next;
        }
        size2++;
        return size2;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        CircularlyLinkedList l = (CircularlyLinkedList) o;
        if (size != l.size) return false;
        Node x=tail.next;
        Node Head = tail.next;
        Node lHead = l.tail.next;
        while (Head.next !=x) {
            if (!Head.getElement().equals(lHead.getElement())) return false;
            Head = Head.getNext();
            lHead = lHead.getNext();
        }
        return true;
    }

    public void split()
    {
        if(size%2==0)
        {
            CircularlyLinkedList l1=new CircularlyLinkedList();
            CircularlyLinkedList l2=new CircularlyLinkedList();
            Node pointer1=tail;
            Node pointer2;
            Node head1;
            Node head2;
            head1=tail.next;
            for (int i = 0; i <size/2; i++) {
                l1.addLast(pointer1.next.element);
                pointer1=pointer1.next;
            }
            head2=pointer1.next;
            pointer1.next=head1;
            pointer2=head2;
            while (pointer2!=head1)
            {
                l2.addLast(pointer2.element);
                pointer2=pointer2.next;
            }
            pointer2.next=head2;
        }
    }




//    public CircularlyLinkedList clone () throws CloneNotSupportedException {
//        CircularlyLinkedList other=(CircularlyLinkedList) super.clone();
//         if (size > 0) {
//             Node<E> x=tail.next;
//             other.tail.next = new Node<>(x.getElement(), null);
//             Node<E> head = tail.getNext();
//             Node<E> otherTail = other.tail;
//             while (head !=x) {
////                 other.addLast(head.element);
//                 Node<E> newest = new Node<>(head.getElement(), head);
//                 otherTail.setNext(newest);
//                 otherTail = newest;
//                 head = head.getNext();
//             }
//         }
//
//          return other;
//    }

    public boolean SameSeq(CircularlyLinkedList list)
    {
        Node<E> p1;
        Node<E> p2;
        int count=0;
        if (list.size>size)
        {
            p1=list.tail.next;
            p2= tail.next;
        }
        else
        {
            p1=tail.next;
            p2= list.tail.next;
        }
        while(p1.element != p2.element)
        {
            p2=p2.next;
        }
        for (int i = 0;p1.element==p2.element ; i++) {
            count++;
            p1=p1.next;
            p2=p2.next;
        }
        if (count>1) return true;
        return false;
    }

    private class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
