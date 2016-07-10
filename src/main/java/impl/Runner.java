package impl;

import api.Executor;
import api.SerialExecutor;
import api.Task;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Task<Long>> tasks = new ArrayList<>();
    public static void main(String[] args) {
        test(tasks);
    }

    public static void test (List<Task<Long>> list) {
        Executor<Number> numberExecutor = new SerialExecutor<>();
        numberExecutor.addTask(new LongTask(2L));
        numberExecutor.addTask(new LongTask(3L));
        numberExecutor.addTask(new LongTask(4L));

        for (Task<Long> task : list) {
            numberExecutor.addTask(task);
        }

        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
