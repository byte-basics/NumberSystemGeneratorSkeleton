package com.bytebasics;


public class App 
{
    public static void main(String[] args) {
        try {
            int numberBase = Integer.parseInt(args[0]);
            NumberSystemGenerator gen = new NumberSystemGenerator();
            System.out.println(gen.generateSingleDigitValueString(numberBase));
            System.out.println(gen.generateColumnValues(numberBase));
        } catch (NumberFormatException e) {
            System.out.println("The first argument must be an integer");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("A single argument must be provided with the value of 2 to 36 inclusive");
            System.exit(1);
        }
    }
}
