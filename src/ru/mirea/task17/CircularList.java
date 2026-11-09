package ru.mirea.task17;


public class CircularList implements StudentList {

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
        }
    }

    private Node head;   // первый узел (u на схеме)
    private Node last;   // последний узел - его next всегда указывает на head
    private int size;

    //  создание пустого списка
    public CircularList() {
        head = null;
        last = null;
        size = 0;
    }

    //  добавление в конец
    @Override
    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            last = newNode;
            newNode.next = newNode;      // единственный узел ссылается сам на себя
        } else {
            last.next = newNode;         // старый последний -> новый
            newNode.next = head;         // новый последний -> первый (замыкаем кольцо)
            last = newNode;
        }
        size++;
    }

    //  удаление по номеру
    @Override
    public boolean remove(int number) {
        if (number < 1 || number > size) {
            return false;
        }
        if (size == 1) {                 // удаляем единственный элемент
            head = null;
            last = null;
        } else if (number == 1) {        // удаляем первый
            head = head.next;
            last.next = head;            // кольцо снова замыкается на новый первый
        } else {
            Node prev = head;
            for (int i = 1; i < number - 1; i++) {
                prev = prev.next;
            }
            Node removed = prev.next;
            prev.next = removed.next;
            if (removed == last) {       // удалили последний - последним стал prev
                last = prev;
            }
        }
        size--;
        return true;
    }

    @Override
    public Student get(int number) {
        if (number < 1 || number > size) {
            return null;
        }
        Node current = head;
        for (int i = 1; i < number; i++) {
            current = current.next;
        }
        return current.data;
    }

    // обход кольца: null не встретится никогда, поэтому идём ровно size шагов
    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node current = head;
        for (int number = 1; number <= size; number++) {
            System.out.print(number + ". ");
            current.data.print();
            current = current.next;
        }
    }

    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }
}