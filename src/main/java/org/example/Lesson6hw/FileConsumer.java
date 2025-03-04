package org.example.Lesson6hw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileConsumer {

    public static void main(String[] args) {
        String file1 = "src/main/resources/les6test1.txt";
        String file2 = "src/main/resources/les6test2.txt";
        String file3 = "src/main/resources/les6test3.txt";
        String file4 = "src/main/resources/les6test4.txt";

//        1.
        System.out.println(fileReader(file1));

//        2.
        fileWriter("Hello Java!", file2, false);

//        3.
        twoFilesReaderAndWriter(file1, file2, file3);

//        4.
        replacingCharacters(file4);

    }

    private static List<String> fileReader(String fileRead) {
        List<String> list = new ArrayList<>();
        try (FileReader read = new FileReader(fileRead);
             BufferedReader bufferedRead = new BufferedReader(read)) {
            while (bufferedRead.ready()) {   //пока в bufferedRead есть непрочитанные данные
                list.add(bufferedRead.readLine()); //записываем в list построчно
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private static void fileWriter(String string, String fileWrite, boolean append) {
        try (FileWriter fileWriter = new FileWriter(fileWrite, append);//указываем append чтобы добавлять или перезаписывать данные в файл
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.append(string); //записываем строку string в файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void twoFilesReaderAndWriter(String fileRead1, String fileRead2, String fileWrite) {
        List<String> list = fileReader(fileRead1); //сохраняем в list данные из первого файла fileRead1
        list.addAll(fileReader(fileRead2));        //сохраняем в list данные из второго файла fileRead2
        for (String s : list) {
            fileWriter(s + "\n", fileWrite, true); //дописываем данные с новой строки в файл fileWrite
        }
    }

    private static void replacingCharacters(String file) {
        List<String> list = fileReader(file);        //читаем в list содержимое файла
        fileWriter("", file, false);    //очищаем содержимое файла
        for (String s : list) {
            s = s.replaceAll("[^A-Za-zА-Яа-я0-9]", "\\$");//меняем построчно значения кроме букв и цифр
            fileWriter(s, file, true);         //записываем в файл
        }
    }

}
