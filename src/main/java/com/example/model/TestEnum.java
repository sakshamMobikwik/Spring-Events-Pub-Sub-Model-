package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TestEnum {

        VA("VA", "Virtual Payment Address"),
        AC("AC", "Account Number");

        private String type;
        private String description;


}
