package com.gojavaonline3.dlenchuk.ee.module051;

import com.gojavaonline3.dlenchuk.ee.module051.calculator1.Parser;

public class TempRunner {

    public static void main(String[] args) {
        final Parser parser = new Parser("52+32");
        parser.parse();
        System.out.println(parser);
    }

}
