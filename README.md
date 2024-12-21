# Smart Task Manager CLI

## Overview
The **Smart Task Manager CLI** is a command-line application that helps users efficiently manage their tasks. It allows users to add, view, delete tasks, track the time spent on tasks, and view performance metrics.

This tool is ideal for users who want a simple yet effective task management and time-tracking solution without a graphical user interface.

---

## Features

1. **View Tasks**:
   - Displays the list of tasks with their priority and deadlines.
   - Shows a message if no tasks are available.

2. **Add Task**:
   - Allows users to add tasks with a title, priority (Low, Medium, High), and deadline (YYYY-MM-DD).

3. **Delete Task**:
   - Enables users to delete a task by specifying its number.
   - Automatically removes any associated performance data.

4. **Track Task Time**:
   - Lets users log the time spent on a specific task.
   - Records the time (in minutes) against the task title.

5. **View Performance**:
   - Displays time spent on each task.
   - Shows total time spent across all tasks.
   - Calculates and displays the average time spent per task.

6. **Exit**:
   - Allows the user to exit the application.

---

## Usage Instructions

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or later).
- A terminal or command prompt to run the application.

### How to Run
1. Save the code into a file named `SmartTaskManagerCLI.java`.
2. Compile the program:
   ```
   javac SmartTaskManagerCLI.java
   ```
3. Run the program:
   ```
   java SmartTaskManagerCLI
   ```

### Menu Options
Upon running the application, you will see the following menu:
```plaintext
--- Smart Task Manager ---
1. View Tasks
2. Add Task
3. Delete Task
4. Track Task Time
5. View Performance
6. Exit
Enter your choice:
```

### Example Interaction
1. **Adding a Task**:
   ```plaintext
   --- Add Task ---
   Enter task title: Complete Assignment
   Enter task priority (Low, Medium, High): High
   Enter task deadline (YYYY-MM-DD): 2024-12-31
   Task added successfully.
   ```

2. **Viewing Tasks**:
   ```plaintext
   --- Task List ---
   1. Complete Assignment (Priority: High, Deadline: 2024-12-31)
   ```

3. **Tracking Task Time**:
   ```plaintext
   --- Track Task Time ---
   Enter the task number to track time for: 1
   Enter time spent on the task (in minutes): 120
   Task time tracked successfully.
   ```

4. **Viewing Performance**:
   ```plaintext
   --- Performance Visualization ---
   Task: Complete Assignment, Time Spent: 120 minutes
   Total Time Spent: 120 minutes
   Average Time Spent per Task: 120.00 minutes
   ```

5. **Deleting a Task**:
   ```plaintext
   --- Delete Task ---
   Enter the task number to delete: 1
   Task deleted successfully.
   ```

---

## Code Structure

### Main Class
`SmartTaskManagerCLI`
- Handles all task management and time tracking functionalities.
- Contains methods for:
  - Viewing tasks.
  - Adding tasks.
  - Deleting tasks.
  - Tracking task time.
  - Viewing performance.

### Internal Classes
#### **Task**
- Represents a task with the following attributes:
  - Title
  - Priority
  - Deadline

---

## Future Enhancements
- Add support for saving and loading tasks from a file.
- Enable detailed performance analysis (e.g., time distribution by priority).
- Add a feature to set task reminders.
- Support for sub-tasks and task dependencies.

---

## License
This project is open-source and available under the MIT License.

