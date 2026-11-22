package ru.mirea.task21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryLister {
    private DirectoryLister() {
    }

    // содержимое каталога в список
    public static List<String> directoryToList(Path dir) throws IOException {
        List<String> names = new ArrayList<>();
        try (Stream<Path> stream = Files.list(dir)) {
            stream.forEach(p -> names.add(p.getFileName().toString()));
        }
        Collections.sort(names);
        return names;
    }

    // выводим первые 5 элементов
    public static List<String> printFirstFive(Path dir) throws IOException {
        List<String> names = directoryToList(dir);
        System.out.println("Каталог: " + dir.toAbsolutePath() + " (элементов: " + names.size() + ")");
        int limit = Math.min(5, names.size());
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
        return names;
    }

    public static void main(String[] args) {
        // каталог можно передать аргументом, по умолчанию - текущий
        String dir = args.length > 0 ? args[0] : ".";
        try {
            printFirstFive(Paths.get(dir));
        } catch (IOException e) {
            System.out.println("Не удалось прочитать каталог: " + e.getMessage());
        }
    }
}