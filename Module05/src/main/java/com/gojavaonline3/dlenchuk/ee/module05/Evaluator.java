package com.gojavaonline3.dlenchuk.ee.module05;

import com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Evaluator {

    private Scanner scanner = new Scanner(System.in);

    private CalculatorFactory calculatorFactory;

    public void setCalculatorFactory(CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "aop-context.xml");
        ((Evaluator) context.getBean("evaluator")).execute();
    }

    private void execute() {
        String expression;
        printHelp();
        do {
            try {
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
                        Calculable calculator = calculatorFactory.getCalculator();
                        System.out.println(calculator.calculate(expression));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);

    }

    private void printHelp() {
        System.out.println("Please, enter a valid expression or a command.");
        System.out.println("The commands are:");
        System.out.println("\t':h', ':help' - type to see this message;");
        System.out.println("\t':!', ':e', ':exit', ':quit' - type to exit.");
    }

}
