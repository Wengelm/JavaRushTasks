package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream lol;

    public QuestionFileOutputStream(AmigoOutputStream lol) {
        this.lol = lol;
    }

    @Override
    public void flush() throws IOException {
        lol.flush();
    }

    @Override
    public void write(int b) throws IOException {
        lol.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        lol.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        lol.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (reader.readLine().equals("Д")) lol.close();
    }
}

