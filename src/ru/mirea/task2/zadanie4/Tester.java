package ru.mirea.task2.zadanie4;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList computer = new ArrayList<String>(); //Список всех Компьютеров (БЕЗ НЕГО НИЧЕГО НЕ РАБОТАЕТ)

        Shop.Computers(computer); //Отображает все Компьютеры в списке

        Shop.ComputerAdd(computer, "New"); //Добавление Компьютера в список

        Shop.ComputerDelete(computer, "New"); //Удаление Компьютера из списка

        Shop.ComputerSearchName(computer, "New"); //Искать Компьютер по названию

        Shop.ComputerSearchIndex(computer, 1); //Искать Компьютер по номеру в списке

    }
}
