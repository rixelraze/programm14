package com.company;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String save = "save";
        String upload = "upload";

        double x = scanner.nextDouble();

        String str = scanner.nextLine();
        calculator calculator = new calculator(x);

        calculator.calc();

        if (str.equals(save)) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SaveUpload"))) {

                oos.writeDouble(x);
                System.out.println("Файл был записан");

            } catch (InputMismatchException | IOException ex) {
                System.out.println("Error " + ex);
            }

        }


        if (str.equals(upload)) {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SaveUpload"))) {

                x = ois.readDouble();
                System.out.println("x = " + x);


            } catch (IOException e) {
                System.out.println("Error " + e);
            }
        }


    }


    public static class calculator implements Serializable {

        double x;

        public calculator(double x) {
            this.x = x;
        }

        public void calc() {
            double y;

            y = x - Math.sin(x);
            System.out.println(y);

        }

    }

}

