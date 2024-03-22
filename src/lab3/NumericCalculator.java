/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author alexb
 */
public class NumericCalculator {    
    
    double number1;
    double number2;
    
    double[] numbers;
    
    static int nrOperations = 0;
    
    public NumericCalculator()
    {}
    
    public NumericCalculator(double nr1, double nr2)
    {
        this.number1 = nr1;
        this.number2 = nr2;
        
        this.numbers = new double[2];        
        numbers[0] = nr1;
        numbers[1] = nr2;
    }
    
    public NumericCalculator(double[] nrs)
    {
        this.numbers = nrs;
    }
    
    
    public double Sum(double n1, double n2)
    {
        nrOperations++;
        
        return n1 + n2;
    }
    
    public Double Sum()
    {
        if (this.numbers.length == 2)
        {
            nrOperations++;
            return this.number1 + this.number2;
        }
        else if (this.numbers.length > 2)
        {
            double sum = 0.0;
            for (int i = 0; i < numbers.length; i++)
            {
                sum += numbers[i];
                
                nrOperations++;
            }
            
            return sum;
        }
        else
        {
            System.err.println("Insuficient numbers");
            return null;
        }
    }    

    public double Multiply(double n1, double n2)
    {
        nrOperations++;
        
        return n1 * n2;
    }

    public Double Multiply()
    {
        if (this.numbers.length == 2)
        {
            nrOperations++;
            return this.number1 * this.number2;
        }
        else if (this.numbers.length > 2)
        {
            double product = 1.0;
            for (int i = 0; i < numbers.length; i++)
            {
                product *= numbers[i];
                
                nrOperations++;
            }
            
            return product;
        }
        else
        {
            System.err.println("Insuficient numbers");
            return null;
        }
    }
    
    public static int GetNumberOfOperations()
    {
      return nrOperations;   
    }   
    
}
