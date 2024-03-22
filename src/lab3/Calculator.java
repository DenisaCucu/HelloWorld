/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

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
                System.out.println("First number:");
                String input3 = ReadConsole(); 
                Double x1 = Double.parseDouble(input3);

                System.out.println("Second number:");
                String input4 = ReadConsole();
                Double y1 = Double.parseDouble(input4);

                NumericCalculator calculator2 = new NumericCalculator(x1, y1);
                result = calculator2.Multiply();

                System.out.println("Result:" + result);
                System.err.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;

            case 4:
                System.out.println("How many numbers:");
                String inputn1 = ReadConsole();
                int n1 = Integer.parseInt(inputn1);
                
                double[] numbers1 = ReadConsoleNumbers(n1);
                
                NumericCalculator calculator3 = new NumericCalculator(numbers1);
                
                result = calculator3.Multiply();
                
                System.out.println("Result:" + result);
                
                System.out.println("Number of operations: " + NumericCalculator.GetNumberOfOperations());
                
                break;
            
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
                
            case 6:
                SpreadSheetCalculator cellCalculator1 = new SpreadSheetCalculator();
                
                System.out.println("How many cells:");
                String inputn2 = ReadConsole();
                int n2 = Integer.parseInt(inputn2);
                
                Cell[] cells = new Cell[n2];
                
                for (int i = 0; i < n2; i++)
                {
                    System.out.println("Cell value:");
                    cells[i] = new Cell("", i + 1, 'A');
                    cells[i].value = ReadConsole();
                }
                
                Cell sumResult1 = cellCalculator1.Sum(cells);
                System.out.println("Sum of cells: " + sumResult1.value);
                
                break;
            
            case 7:
                SpreadSheetCalculator cellCalculator2 = new SpreadSheetCalculator();
                
                System.out.println("First cell value:");
                Cell c3 = new Cell("", 1, 'A');
                c3.value = ReadConsole();
                
                System.out.println("Second cell value:");
                Cell c4 = new Cell("", 2, 'A');
                c4.value = ReadConsole();
                
                Cell productResult = cellCalculator2.Multiply(c3, c4);
                System.out.println("Product of cells: " + productResult.value);
                
                break;
            
            case 8:
                SpreadSheetCalculator cellCalculator3 = new SpreadSheetCalculator();
                
                System.out.println("How many cells:");
                String inputn3 = ReadConsole();
                int n3 = Integer.parseInt(inputn3);
                
                Cell[] cells1 = new Cell[n3];
                
                for (int i = 0; i < n3; i++)
                {
                    System.out.println("Cell value:");
                    cells1[i] = new Cell("", i + 1, 'A');
                    cells1[i].value = ReadConsole();
                }
                
                Cell productResult1 = cellCalculator3.Multiply(cells1);
                System.out.println("Product of cells: " + productResult1.value);
                
                break;

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
