package com.javarush.task.task19.task1918;

/*
Знакомство с тегами
*/

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readF = new BufferedReader(new FileReader(reader.readLine()));
        ) {
            String tag = args[0];
            String html = readF.lines().collect(Collectors.joining());
            Matcher tagOpen = Pattern.compile("<" + tag).matcher(html);
            Matcher tagClose = Pattern.compile("</" + tag + ">").matcher(html);
            LinkedList<Integer> openStack = new LinkedList<>();
            LinkedList<Integer> closeStack = new LinkedList<>();
            int counter=0;
            int next_start=0;
            while (tagClose.find()) {  //пока есть закрывающий тег, находим его.
                closeStack.add(tagClose.end());   //добавить конец закр. тега в стек
                counter--;
                while (tagOpen.find(next_start) && tagOpen.start() < tagClose.end()) {  //от последней обработанной позиции стартового тега, не перескакивая через текущий закрывающий.
                    openStack.add(tagOpen.start());  //добавить начало откр тега в стек2
                    counter++;
                    next_start=tagOpen.end(); //сохраняем последнюю обработанную стартовую позицию
                }
                while (counter>0){  //донаходим концы закрывающих тегов парных количеству открывающих
                    tagClose.find();
                    closeStack.add(tagClose.end()); //ложим в стек
                    counter--;
                }
                while(openStack.size()>0){ //пока в стеке есть теги (т.к. теги парные, стеки равны и все равно какой брать)
                    System.out.println(html.substring(openStack.removeFirst(),closeStack.removeLast()));//содержимое пары тегов, и удаление их из стеков
                }
                tagOpen.reset();  //сбрасываем матчер - возможно лишнее, т.к. поиск по нему всеравно "с позиции".
            }
            System.out.println();
        } catch (IOException e) {

        }
    }
}
