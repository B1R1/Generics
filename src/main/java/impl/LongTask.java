package impl;

import api.Task;

public class LongTask implements Task<Long> {

    Long value;

    public LongTask(Long value) {
        this.value = value;
    }

    @Override
    public void execute() {
    }

    @Override
    public Long getResult() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
