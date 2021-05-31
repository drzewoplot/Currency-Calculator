package pl.abramczyk.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    public void close() {
        sc.close();
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw e;
        } finally {
            sc.nextLine();
        }
    }

    public String getString() {
        try {
            return sc.nextLine();
        } catch (InputMismatchException e) {
            throw e;
        }
    }

    public double getDouble() {
        try {
            return sc.nextDouble();
        } catch (InputMismatchException e) {
            throw e;
        } finally {
            sc.nextLine();
        }
    }


}
