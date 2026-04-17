package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "/Users/admin/HUST/OOP/OOP-LAB.20252-202417117/OtherProjects/src/hust/soict/globalict/garbage/text.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        startTime = System.currentTimeMillis();
        String outputString = "";
        for(byte b : inputBytes) {
            outputString += (char) b;
        }
        endTime = System.currentTimeMillis();
        
        System.out.println("GarbageCreator processing time: " + (endTime - startTime) + " ms");
    }
}