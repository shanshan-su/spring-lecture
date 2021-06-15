package com.codeup.springlecture.services;

import org.springframework.stereotype.Service;

@Service("stringService")
public class StringService {

    public String shortenString(String originalString) {
        return "short string";
    }
}
