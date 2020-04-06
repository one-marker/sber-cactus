package tasks.serializable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        User user =new User();
        user.level = 55;

        FileOutputStream fileOutputStream = new FileOutputStream("tmpFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("tmpFile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User newUser = (User) objectInputStream.readObject();
        objectInputStream.close();

    }
}
