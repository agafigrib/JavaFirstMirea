package ru.mirea.task2.zadanie4;
import java.util.ArrayList;

public class Shop {
    public static ArrayList Computers(ArrayList PC){
        int SizeP = PC.size();
        for (int i = 0; i < SizeP; i++){
            System.out.println(PC.get(i));
        }
        return null;
    }
    public static ArrayList ComputerAdd(ArrayList PC, String computer){ //Добавить в список Компьютер
        PC.add(computer); //Добавить в список
        return PC; //Вернуть список
    }
    public static ArrayList ComputerDelete(ArrayList PC, String computer){ //Удалить из списка Компьютер
        PC.remove(computer); //Удалить из списка
        return PC; //Вернуть список
    }
    public static String ComputerSearchName(ArrayList PC, String Search){ //Искать в списке Компьютер по его названию
        int Index = PC.indexOf(Search); //Получение индекса списка искаемого значения
        String result = (String) PC.get(Index); //Значение списка от индекса
        System.out.println(result); //Отображение выбранного Компьютера
        return result; //Возвращение искаемого Компьютера
    }
    public static String ComputerSearchIndex(ArrayList PC, int Index){ //Искать в списке Компьютер по номеру в списке
        String result = (String) PC.get(Index); //Значение списка от индекса
        System.out.println(result); //Отобразить выбранный компьютер
        return result; //Вернуть искомый Компьютер
    }
}