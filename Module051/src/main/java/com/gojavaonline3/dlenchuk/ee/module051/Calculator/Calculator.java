package com.gojavaonline3.dlenchuk.ee.module051.Calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Calculator {

    private Validator validator;
    private Parser parser;
    private OperatorFactory operatorFactory;

    private Scanner scanner = new Scanner(System.in);

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void setOperatorFactory(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

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
                    calculate(expression);
                }
            }
        } while (true);

    }

    private void calculate(String expression) {
        if (valid(expression)) {
            parser.parse(expression);
        }
    }

    private boolean valid(String expression) {
        return validator.valid(expression);
    }

    private void printHelp() {
        System.out.println("Please, enter a valid expression or a command.");
        System.out.println("The commands are:");
        System.out.println("\t':h', ':help' - type to see this message;");
        System.out.println("\t':!', ':e', ':exit', ':quit' - type to exit.");
    }

}
