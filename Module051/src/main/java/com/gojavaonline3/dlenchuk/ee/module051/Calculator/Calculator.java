package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Calculator {

    public Validator validator;
    public OperatorFactory operatorFactory;


    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        context.getBean("calculator", Calculator.class).execute();
    }

    private void execute() {
        String expression;
        printHelp();
        do {
            System.out.print(">>");
            expression = scanner.nextLine().replaceAll("\\s+", "");
            switch (expression) {
                case ":h":
                case ":help": {
                    printHelp();
                    break;
                }
                case ":!":
                case ":e":
                case ":exit":
                case ":quit": {
                    return;
                }
                default: {
                    if (valid(expression)) {
                        System.out.println(expression);
                    }
                }
            }
        } while (true);

    }

    private void printHelp() {
        System.out.println("Please, enter a valid expression or a command.");
        System.out.println("The commands are:");
        System.out.println("\t':h', ':help' - type to see this message;");
        System.out.println("\t':!', ':e', ':exit', ':quit' - type to exit.");
    }

    private boolean valid(String expression) {
        return validator.valid(expression);
    }

}
