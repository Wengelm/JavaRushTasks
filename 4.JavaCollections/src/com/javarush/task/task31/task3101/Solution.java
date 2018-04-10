package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

        static List<Path> list = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            Path path = Paths.get(args[0]);
            File resultFileAbsolutePath = new File(args[1]);

            MyFileVisitor mfv = new MyFileVisitor();

            Files.walkFileTree(path, mfv);

            Collections.sort(list, new Comparator<Path>() {
                @Override
                public int compare(Path o1, Path o2) {
                    return o1.getFileName().compareTo(o2.getFileName());
                }
            });

            File finalFile;
            FileUtils.renameFile(resultFileAbsolutePath, finalFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt"));

            FileWriter fWriter = new FileWriter(finalFile);
            for(Path p : list){
                FileReader fReader = new FileReader(p.toFile());
                while(fReader.ready()){
                    char[] charBuf = new char[(int)p.toFile().length()];//по заданию, мы работаем с файлами до 50 байт
                    fReader.read(charBuf);
                    fWriter.write(charBuf);
                }
                fReader.close();
                fWriter.write("\n");
                fWriter.flush();
            }
            fWriter.close();

        }

        public static void deleteFile(File file) {
            if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
        }

        private static class MyFileVisitor extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(Files.size(file)>50)
                    FileUtils.deleteFile(file.toFile());
                else if(Files.size(file)<=50)
                    list.add(file);
                return super.visitFile(file, attrs);
            }
        }
    }