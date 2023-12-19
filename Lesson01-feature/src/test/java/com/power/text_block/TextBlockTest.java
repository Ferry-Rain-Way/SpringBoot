package com.power.text_block;

import org.junit.Test;

public class TextBlockTest {
    @Test
    public void test01(){
         String s1 = """
                <html>
                    <body>这是一个文本块</body>
                </html>
         """;

        System.out.println(s1);
    }

}
