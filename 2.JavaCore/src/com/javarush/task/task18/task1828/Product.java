package com.javarush.task.task18.task1828;

public class Product{

    private static Product instance;

    private int maxQuantity =9999;
    private int maxLengthProduct = 30;
    private int maxLengthId = 8;

    private String operation;
    private int quantity;
    private double price;
    private String name;
    private int id = -1;
    private int indexInListProducts = -1; // Индекс записи в списке после прочтения файла


    private Product() {}
    public static synchronized Product getInstance(){
        if (instance == null) {
            instance = new Product();
        }
        return instance;
    }

    // Блок Количество

    public void setQuantity(int quantity) {
        if (quantity > maxQuantity)
            throw new IllegalArgumentException("Количество товара не может быть больше 9999");
        if (quantity < 0)
            throw new IllegalArgumentException("Количество товара должно быть положительным целым числом");
        this.quantity = quantity;
    }


    public void setQuantity(String strQuantity) {
        int i;
        try {
            i = Integer.parseInt(strQuantity.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Количество товара должно быть положительным целым числом");
        }
        setQuantity(i);
    }

    public int getQuantity() {
        return quantity;
    }

    public String getQuantityStrFormat() {
        return String.format("%-4d", quantity);
    }


    // Блок Цена

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Цена товара должна быть положительным числом");
        this.price = price;
    }

    public void setPrice(String strPrice) {
        double d;
        try {
            d = Double.parseDouble(strPrice.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Цена товара должна быть числом");
        }
        setPrice(d);
    }

    public double getPrice() {
        return price;
    }

    public String getPriceStrFormat() {
        return String.format("%-8.2f", price);
    }


    // Блок операций

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    // Блок имени

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public String getNameStrFormat() {
        return String.format("%-"+ maxLengthProduct +"s", name);
    }


    // Блок ID

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String strId) {
        int i;
        try {
            i = Integer.parseInt(strId.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID должен быть целым числом");
        }
        setId(i);
    }

    public int getId() {
        return id;
    }

    public String getIdStrFormat() {
        return String.format("%-"+ maxLengthId +"s", id);
    }


    public int getIndexInListProducts() {
        return indexInListProducts;
    }

    public void setIndexInListProducts(int indexInListProducts) {
        this.indexInListProducts = indexInListProducts;
    }
}