/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexb
 */
public class Calculator {
    
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to calculator. Select an option: 1. Add | 2.Substract | 3. Divide | 4. Multiply | 5. Modulo");
        
        System.out.println("Spreadsheet calculator. Select an option: 6. CellSum | 7. CellIncrement | 8.CellDecrement" );
        
        String inputOption = ReadConsole();
        int option = Integer.parseInt(inputOption);
        
        NumericCalculator numericOperations = new NumericCalculator();
        SpreadSheetCalculator cellOperations = new SpreadSheetCalculator();
        
        double result = 0;
        
        switch(option)
        {
            case 1:
                System.out.println("First number: ");
                String input1 = ReadConsole();
                
                System.out.println("Second number: ");
                String input2 = ReadConsole();
                
                double x = Double.parseDouble(input1);
                double y = Double.parseDouble(input2);
                
                result = numericOperations.Sum(x, y);
                
                System.out.println("Result:" + result);
                
                break;
            case 2: 
                // here goes the code for Substract operation               
                
                break;
               // add code for computing the 2 -> 5 use cases
            case 6:
                System.out.println("First cell value:");
                Cell c1 = new Cell();                
                c1.value = ReadConsole();
                
                System.out.println("Second cell value:");
                Cell c2 = new Cell();                
                c2.value = ReadConsole();
                
                Cell sumResult = cellOperations.Sum(c1, c2);                
                System.out.println("Sum of cells: " + sumResult.value);
                
                cellOperations.Increment(c1);
                cellOperations.Increment(c2);
                cellOperations.Increment(c2);
                System.out.println("Incremented cell 1: " + c1.value);
                
                System.out.println("Incremented cell 2: " + c2.value);
                
                break;
                
                // add code for computing 7 and 8 spreadsheet operations
        }  
    }

    private static String ReadConsole() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String result = reader.readLine();
        
        return result;
    }    
}
