package com.gojavaonline3.dlenchuk.ee.module05;

import com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculatorLogger {

    private static Logger logger = LogManager.getLogger(Calculator.class);

    @Around("execution(* com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculator.calculate(String)) && args(expression))")
    public Object log(ProceedingJoinPoint pjp, String expression) throws Throwable {
        logger.info("Calculating expression: " + expression);
        final Object result = pjp.proceed();
        logger.info(result);
        return result;
    }

    @AfterThrowing(pointcut = "execution(* com.gojavaonline3.dlenchuk.ee.module05.calculator.Calculator.calculate(..))", throwing = "ex")
    public void logException(Exception ex) {
        logger.error(ex);
    }

}
