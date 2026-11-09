package ru.mirea.task17;


public class DoublyLinkedList implements StudentList {

    private static class Node {
        Student data;
        Node prev;
        Node next;

        Node(Student data) {
            this.data = data;
        }
    }

    private Node head;   // начало (Begin на схеме)
    private Node tail;   // конец (End на схеме)
    private int size;

    //  создание пустого списка
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //  добавление в конец - сразу через tail, без прохода по списку
    @Override
    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;     // старый последний -> новый
            newNode.prev = tail;     // новый <- старый последний
            tail = newNode;          // новый становится последним
        }
        size++;
    }

    // поиск узла по номеру: с начала или с конца - откуда ближе
    private Node getNode(int number) {
        if (number <= size / 2) {
            Node current = head;
            for (int i = 1; i < number; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node current = tail;
            for (int i = size; i > number; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    //  удаление по номеру
    @Override
    public boolean remove(int number) {
        if (number < 1 || number > size) {
            return false;
        }
        Node node = getNode(number);

        if (node.prev == null) {         // удаляем первый
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {         // удаляем последний
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
        return true;
    }

    @Override
    public Student get(int number) {
        if (number < 1 || number > size) {
            return null;
        }
        return getNode(number).data;
    }

    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node current = head;
        int number = 1;
        while (current != null) {
            System.out.print(number + ". ");
            current.data.print();
            current = current.next;
            number++;
        }
    }

    // вывод в обратном порядке - возможность, которой нет у односвязного списка
    public void printReverse() {
        Node current = tail;
        int number = size;
        while (current != null) {
            System.out.print(number + ". ");
            current.data.print();
            current = current.prev;
            number--;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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