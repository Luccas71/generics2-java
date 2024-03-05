package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import service.CalculationService;

public class Main {

     public static void main(String[] args) {
        
          List<Product> list = new ArrayList<>();
          String path = "/home/lucas/Documentos/in.txt";

          try (BufferedReader br = new BufferedReader(new FileReader(path))){
              String line = br.readLine();
              while(line != null) {
               String[] fields = line.split(",");
               String name = fields[0];
               Double price = Double.parseDouble(fields[1]);
               list.add(new Product(name, price));
               line = br.readLine();
              }

              Product x = CalculationService.max(list);
              System.out.println("Most expansive: ");
              System.out.println(x);
              
          } catch (IOException e) {
               System.out.println("Error: " + e.getMessage());
          }
     }
}