package org.vbaklaiev.view;

import java.util.Scanner;

public class ConsoleCommandInterface implements CommandInterface {
    //TODO a good place for mocking
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
