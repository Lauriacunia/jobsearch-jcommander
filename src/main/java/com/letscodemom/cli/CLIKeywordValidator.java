package com.letscodemom.cli;

import com.beust.jcommander.IParameterValidator;

public class CLIKeywordValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) {
        if(!value.matches("^[a-zA-Z]+[0-9]+$")){
            throw new IllegalArgumentException("The keyword must contain only letters or numbers and must start with a letter.");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("The keyword must be at least 1 character long");
        }
    }

}
