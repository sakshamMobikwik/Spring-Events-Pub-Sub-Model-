package com.example.test;

import com.example.model.TestEnum;
import com.example.model.UPIError;

public class Test {
    public static void main(String[] g) {
        try {
            UPIError upiError = UPIError.getByStatusCode("ZJ");
            System.out.println(upiError.getMessage());
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
