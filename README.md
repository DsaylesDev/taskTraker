# Task Tracker CLI (Java)

A simple **Command Line Interface (CLI) task tracker** built in Java.  
This application allows users to manage tasks directly from the command line and stores task data locally in a JSON file.

This project demonstrates core backend programming concepts including:

- Command-line argument handling
- File system interaction
- JSON data storage
- Object-oriented design
- Basic task management operations

---

## Features

The CLI supports the following operations:

- Add a new task
- Update a task description
- Delete a task
- Mark a task as **in-progress**
- Mark a task as **done**
- List all tasks
- List tasks by status

Each task contains the following properties:

| Property | Description |
|--------|-------------|
| id | Unique identifier for the task |
| description | Short task description |
| status | todo, in-progress, or done |
| createdAt | Timestamp when the task was created |
| updatedAt | Timestamp of last update |

---

## Project Structure

### Key Classes

**Main.java**

Handles CLI input and routes commands to the task manager.

**Task.java**

Represents a task object and handles JSON serialization.

**TaskManager.java**

Handles all business logic including:

- Loading tasks
- Saving tasks
- Adding tasks
- Updating tasks
- Deleting tasks
- Listing tasks

---

## Requirements

- Java 17+
- Gradle
- IntelliJ IDEA (recommended)

---

## Running the Application

### Using IntelliJ

1. Open the project in IntelliJ.
2. Create a **Run Configuration** for `com.darion.Main`.
3. Add program arguments to execute commands.

Example program arguments:

---

### Example Commands

Add a task:

List tasks:

Mark task as done:

Mark task as in progress:

Delete a task:

---

## Example Output

Listing tasks:

---

## Data Storage

Tasks are stored locally in a JSON file:

Example:

```json
[
  {
    "id": 1,
    "description": "Buy groceries",
    "status": "todo",
    "createdAt": "2026-03-08T20:45:00",
    "updatedAt": "2026-03-08T20:45:00"
  }
]
