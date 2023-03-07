public class CircularlyLinkedListTester {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list=new CircularlyLinkedList<>();
//        System.out.println(list.isEmpty());
        list.addFirst(11);
        list.addLast(12);
        list.addLast(13);
        list.addLast(14);
//      CircularlyLinkedList n= list.clone();
//        for (int i = 0; i <n.size() ; i++) {
//            System.out.println(n.first());
//            list.rotate();
//        }
//        System.out.println(list.size2());

        CircularlyLinkedList<Integer> list2=new CircularlyLinkedList<>();
        list2.addFirst(13);
        list2.addLast(11);
        list2.addLast(12);
        list2.addLast(13);

//        System.out.println(list.equals(list2));
//        list2.addLast(13);
        System.out.println(list.SameSeq(list2));
    }
}
