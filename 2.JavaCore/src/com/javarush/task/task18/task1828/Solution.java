package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.*;

import static java.util.Arrays.asList;


public class Solution {

    private static List<String> legalOperations = asList("-c", "-u", "-d");
    private static Product product = Product.getInstance();
    private static ArrayList<String> listProducts = new ArrayList<>();
    private static String fileName = "";

    public static void main(String[] args) throws Exception {

//        fileName = "d:/tmp.txt";
        try {
            initFileName();
            prepareArgs(args);
            readProductsFile();

            switch (product.getOperation()) {
                case "-c":
                    addProduct();
                    break;
                case "-u":
                    updateProduct();
                    break;
                case "-d":
                    deleteProduct();
                    break;
            }

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void prepareArgs(String[] args) throws IllegalArgumentException {

        if (!legalOperations.contains(args[0])) throw new IllegalArgumentException("Неверный аргумент типа операции");
        product.setOperation(args[0]);

        switch (product.getOperation()){
            case "-c":
                prepareArgsSubFunc(args,4); // Должно быть минимум 4 аргумента
                break;
            case "-u":
                prepareArgsSubFunc(args,5); // Должно быть минимум 5 аргументов
                product.setId(args[1]);
                break;
            case "-d":
                product.setId(args[1]);
                break;
        }
    }

    public static void prepareArgsSubFunc(String[] args,int countNeedArgs){

        int countFactArgs = args.length;  // Название товара может быть не заключено в кавычки

        if (countFactArgs < countNeedArgs)
            throw new IllegalArgumentException("Неверное количество аргументов в командной строке");

        // Инициализация продукта
        product.setQuantity(args[countFactArgs - 1]); // Количество товара. Целое число.
        product.setPrice(args[countFactArgs - 2]); // Цена товара. Дробное число.
        String tmpName = "";
        for (int i = countNeedArgs - 3; i < countFactArgs - 2; i++) {
            tmpName += args[i] + " ";
        }
        product.setName(tmpName);
    }

    public static void initFileName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fileName = br.readLine();
    }

    public static void readProductsFile() throws IOException {

        String s;

        String strId = product.getIdStrFormat().trim();
        strId= String.format("%-8s" ,strId );
        int intId = product.getId();   // ID продукта. Должен быть -1 для нового продукта
        int indexInListProducts = product.getIndexInListProducts();  // Индекс товара с нужным ID в ArrayList listProducts по умолчанию -1
        boolean isNew = false;
        if (intId == -1)
            isNew = true; //если id = -1, то это новый продукт. Надо искать макс. id и не надо считывать файл в память

        try (FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNext()) {
                s = scan.nextLine();
                if (isNew) {
                    int i = Integer.parseInt(s.substring(0, 8).trim());
                    if (i > intId) intId = i;
                } else {
                    if (s.indexOf(strId) == 0) {        // если начало строки совпадает с заданным ID мы нашли строку для изменения
                        indexInListProducts = listProducts.size();
                    }
                    listProducts.add(s);
                }
            }
            if (isNew) product.setId(intId + 1);
            else product.setIndexInListProducts(indexInListProducts);

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Указанный файл с базой продуктов не найден");
        } catch (IOException e) {
            throw new IOException("Ошибка чтения файла");
        }
    }

    public static String getResultStrProduct(){

        String result = product.getIdStrFormat()+
                product.getNameStrFormat()+
                product.getPriceStrFormat()+
                product.getQuantityStrFormat();
        return result;
    }

    public static void addProduct() {
        writeProductFile(getResultStrProduct());
    }

    public static void updateProduct() throws IOException {
        String result = getResultStrProduct();
        listProducts.set(product.getIndexInListProducts(),result);
        writeProductFile(listProducts);
    }


    public static void deleteProduct()  {
        listProducts.remove(product.getIndexInListProducts());
        writeProductFile(listProducts);
    }

    public static void writeProductFile(Object obj){

        PrintStream printStream = null;
        try {
            if (obj instanceof String)
                printStream = new PrintStream(new FileOutputStream(fileName, true), true);
            if (obj instanceof ArrayList)
                printStream = new PrintStream(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (obj instanceof String)
            printStream.println((String) obj);
        if (obj instanceof ArrayList) {
            ArrayList<String> list = (ArrayList<String>) obj;
            for (String s :list) {
                printStream.println(s);
            }
        }
        printStream.close();
    }

}
