package ru.mirea.task17;


public class SinglyLinkedList implements StudentList {

    // узел списка: данные + ссылка на следующий узел
    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;   // у последнего узла next = null
        }
    }

    private Node head;   // первый узел (на схеме - указатель u)
    private int size;

    //  создание пустого списка
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    //  добавление в конец списка
    @Override
    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {              // список пустой - новый узел становится первым
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {   // идём до последнего узла
                current = current.next;
            }
            current.next = newNode;          // прицепляем новый узел
        }
        size++;
    }

    //  по номеру (номера с 1)
    @Override
    public boolean remove(int number) {
        if (number < 1 || number > size) {
            return false;
        }
        if (number == 1) {                   // удаляем первый: голова сдвигается на второй
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 1; i < number - 1; i++) {   // ищем узел ПЕРЕД удаляемым
                prev = prev.next;
            }
            prev.next = prev.next.next;      // «перешагиваем» через удаляемый узел
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

    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node current = head;
        int number = 1;
        while (current != null) {            // идём, пока не дойдём до null
            System.out.print(number + ". ");
            current.data.print();
            current = current.next;
            number++;
        }
    }

    //  очистка: достаточно забыть голову, узлы удалит сборщик мусора
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    //  проверка на пустоту
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }
}