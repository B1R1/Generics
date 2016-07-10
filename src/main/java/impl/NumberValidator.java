package impl;

import api.Validator;

public class NumberValidator implements Validator<Number> {

    @Override
    public boolean isValid(Number result) {
        return result.toString().length() == 0;
    }
}