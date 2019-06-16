package main.java.encoding;

import java.util.Base64;

public class HashTest {

    public static void main(String[] args) {
        String name = "Ryan Yao";
        for (int i=0;i<10;++i) {
            System.out.println(Base64.getEncoder().encodeToString(name.getBytes()));
        }

        String url = "https://www.google.com";
        for (int i=0;i<10;++i) {
            System.out.println(Base64.getEncoder().encodeToString(url.getBytes()));
        }
    }
}
