import java.util.*;

public class SmartTaskManagerCLI {

    private List<Task> tasks;
    private Map<String, Long> taskCompletionTimes;

    public static void main(String[] args) {
        SmartTaskManagerCLI manager = new SmartTaskManagerCLI();
        manager.run();
    }

    public SmartTaskManagerCLI() {
        tasks = new ArrayList<>();
        taskCompletionTimes = new HashMap<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Smart Task Manager ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Track Task Time");
            System.out.println("5. View Performance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewTasks();
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    trackTaskTime(scanner);
                    break;
                case 5:
                    viewPerformance();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewTasks() {
        System.out.println("\n--- Task List ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.printf("%d. %s (Priority: %s, Deadline: %s)%n", i + 1, task.getTitle(), task.getPriority(), task.getDeadline());
        }
    }

    private void addTask(Scanner scanner) {
        System.out.println("\n--- Add Task ---");

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        System.out.print("Enter task deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        tasks.add(new Task(title, priority, deadline));
        System.out.println("Task added successfully.");
    }

    private void deleteTask(Scanner scanner) {
        System.out.println("\n--- Delete Task ---");
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            Task removedTask = tasks.remove(taskNumber - 1);
            taskCompletionTimes.remove(removedTask.getTitle());
            System.out.println("Task deleted successfully.");
        }
    }

    private void trackTaskTime(Scanner scanner) {
        System.out.println("\n--- Track Task Time ---");
        System.out.print("Enter the task number to track time for: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task task = tasks.get(taskNumber - 1);
        System.out.print("Enter time spent on the task (in minutes): ");
        long timeSpent = scanner.nextLong();
        scanner.nextLine();

        taskCompletionTimes.put(task.getTitle(), timeSpent);
        System.out.println("Task time tracked successfully.");
    }

    private void viewPerformance() {
        System.out.println("\n--- Performance Visualization ---");
        if (taskCompletionTimes.isEmpty()) {
            System.out.println("No performance data available.");
            return;
        }
        for (Map.Entry<String, Long> entry : taskCompletionTimes.entrySet()) {
            System.out.printf("Task: %s, Time Spent: %d minutes%n", entry.getKey(), entry.getValue());
        }

        long totalTimeSpent = taskCompletionTimes.values().stream().mapToLong(Long::longValue).sum();
        double averageTimeSpent = totalTimeSpent / (double) taskCompletionTimes.size();
        System.out.printf("Total Time Spent: %d minutes%n", totalTimeSpent);
        System.out.printf("Average Time Spent per Task: %.2f minutes%n", averageTimeSpent);
    }

    private static class Task {
        private final String title;
        private final String priority;
        private final String deadline;

        public Task(String title, String priority, String deadline) {
            this.title = title;
            this.priority = priority;
            this.deadline = deadline;
        }

        public String getTitle() {
            return title;
        }

        public String getPriority() {
            return priority;
        }

        public String getDeadline() {
            return deadline;
        }
    }
}
