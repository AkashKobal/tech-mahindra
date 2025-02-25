package Deserialize;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import Serialize.Student;

public class DeserializeExample {
    public static void main(String[] args) {
        Student s = null;
        
        try (FileInputStream fileIn = new FileInputStream("student.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            s = (Student) in.readObject();  // Deserializing the object
            System.out.println("Deserialized Student: " + s);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
