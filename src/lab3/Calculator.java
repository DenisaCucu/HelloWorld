/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import lab2.*;
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
        System.out.println("Welcome to calculator. Select an option: 1. Add two numbers | 2. Add multiple numbers | 3. Multiply two numbers | 4. Multiply several numbers");
                
        System.out.println("Spreadsheet calculator. Select an option: 5. CellSum of 2 cells | 6. CellSum of multiple cells | 7.CellProduct of 2 cells | 8.CellProduct of multiple cells" );
        
        String inputOption = ReadConsole();
        int option = Integer.parseInt(inputOption);
        
        double result = 0;
        
        switch(option)
        {
            case 1:
                System.out.println("First number: ");
                String input1 = ReadConsole();
                
                System.out.println("Second number: ");
                String input2 = ReadConsole();
                
                Double x = Double.parseDouble(input1);
                Double y = Double.parseDouble(input2);
                               
                NumericCalculator calculator = new NumericCalculator(x, y);
                
                result = calculator.Sum();
                
                System.out.println("Result:" + result);
                
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
            case 2:
                System.out.println("How many numbers: ");
                String inputn = ReadConsole();
                
                int n = Integer.parseInt(inputn);
                
                double[] numbers = ReadConsoleNumbers(n);
                
                NumericCalculator calculator1 = new NumericCalculator(numbers);
                
                result = calculator1.Sum();
                
                System.out.println("Result:" + result);
                
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
            case 3: 
                // here goes the code for multiplication operation               
                
                break;
               // add code for computing the 2 -> 5 use cases
            case 5:
                SpreadSheetCalculator cellCalculator = new SpreadSheetCalculator();
                        
                System.out.println("First cell value:");
                Cell c1 = new Cell("", 1, 'A');                
                c1.value = ReadConsole();
                
                System.out.println("Second cell value:");
                Cell c2 = new Cell("", 2, 'A');                
                c2.value = ReadConsole();
                
                Cell sumResult = cellCalculator.Sum(c1, c2);                
                System.out.println("Sum of cells: " + sumResult.value);
                                
                break;
                
                // add code for computing 7 and 8 spreadsheet operations
        }  
        
        System.out.println("Total number of numeric operations: " + NumericCalculator.nrOperations);
        
        System.out.println("Total number of cells used: " + Cell.totalCells);
    }
    
    private static double[] ReadConsoleNumbers(int n) throws IOException
    {
        double[] result = new double[n];
        
        for (int count = 0; count < n; count++)
        {
            String input = ReadConsole();
            result[count] = Double.parseDouble(input);
        }
        
        return result;
    }

    private static String ReadConsole() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String result = reader.readLine();
        
        return result;
    }    
}
