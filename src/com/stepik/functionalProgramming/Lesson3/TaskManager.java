package com.stepik.functionalProgramming.Lesson3;

import java.util.*;
import java.util.function.Supplier;

/*
You need to implement a supplier that returns the next task from the highest priority queue. If the queue is empty,
 the supplier should return a task from the next queue. The tasks of the same priority must be returned in the same
 order as they were added to the queue. To do that, modify the getTaskSupplier method in the TaskManager class
 to create a supplier producing tasks in a correct order.
*/

class TaskManager {
    /**
     * Highest priority queues come first in the list.
     * The 0th queue contains tasks with the highest priority.
     */
    private final List<Queue<Task>> taskQueues = new ArrayList<>();

    public TaskManager(int numberOfQueues) {
        if (numberOfQueues < 1) {
            throw new IllegalArgumentException("The number of queues must be >= 1");
        }
        for (int i = 0; i < numberOfQueues; i++) {
            taskQueues.add(new ArrayDeque<>());
        }
    }

    public void add(Task task, int priority) {
        if (priority < 0 || priority >= taskQueues.size()) {
            throw new IllegalArgumentException("The task has an illegal priority " + priority);
        }
        taskQueues.get(priority).add(task);
    }

    /**
     * Returns a suppliers to access tasks in the right order according to their priority.
     * If all the queues are empty, it returns null.
     */
    public Supplier<Task> getTaskSupplier() {
        return () -> //taskQueues.stream().;
        {
            for (Queue<Task> taskQueue : taskQueues) {
                Task task = taskQueue.poll();
                if (task != null) {
                    return task;
                }
            }
            return null;
        };
        /*taskQueues.stream()
                               .filter(q -> !q.isEmpty())
                               .map(Queue::poll)
                               .findFirst()
                               .orElse(null);*/
                // write your code here
    }
}

class Task {
    private final long number;
    private final int priority;

    public Task(long number, int priority) {
        this.number = number;
        this.priority = priority;
    }

    public long getNumber() {
        return number;
    }

    public int getPriority() {
        return priority;
    }
}

class TasksHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfQueues = Integer.parseInt(scanner.nextLine());
        int numberOfTasks = Integer.parseInt(scanner.nextLine());

        TaskManager manager = new TaskManager(numberOfQueues);

        for (int i = 0; i < numberOfTasks; i++) {
            String[] taskParts = scanner.nextLine().split("\\s+");
            long number = Long.parseLong(taskParts[0]);
            int priority = Integer.parseInt(taskParts[1]);
            Task task = new Task(number, priority);
            manager.add(task, priority);
        }

        Supplier<Task> taskSupplier = manager.getTaskSupplier();
        Task task;
        while ((task = taskSupplier.get()) != null) {
            System.out.println(task.getNumber());
        }
    }
}
