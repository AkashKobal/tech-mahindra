package Serialize;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeExample {
    public static void main(String[] args) {
        Student s = new Student("6000", "Akash", "akash@gmail.com", "Pune", 2021);
        
        try (FileOutputStream fileOut = new FileOutputStream("student.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(s);  // Serializing the object
            System.out.println("Serialized data is saved in student.txt");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
