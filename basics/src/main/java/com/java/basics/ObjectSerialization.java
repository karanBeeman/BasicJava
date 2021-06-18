package com.java.basics;

import java.io.*;

public class ObjectSerialization implements Serializable {

    public String name;

    private static final long serialVersionUID = 4390482518182625971L;

    public ObjectSerialization(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjectSerialization{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Serialize {

    public static void main(String[] args) {
        ObjectSerialization objectSerialization = new ObjectSerialization("Hello java World");

        try {
            writeToFile(objectSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(ObjectSerialization objectSerialization) throws IOException {
        File file = new File("E:\\newFile.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectSerialization);
            objectOutputStream.flush();
            objectOutputStream.close();
    }

    public static void readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\newFile.txt"));
        ObjectSerialization name = (ObjectSerialization) objectInputStream.readObject();
        System.out.println(name);
    }
}

