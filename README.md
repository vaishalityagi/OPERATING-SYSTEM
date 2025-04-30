# Banker's Algorithm Simulation with Deadlock Detection and Prevention

## Overview
This Java-based project simulates the **Banker's Algorithm** for managing resource allocation in a system, with additional features for **deadlock detection and prevention**. The simulation ensures that resources are allocated to processes without leading to unsafe states or deadlocks.

### Features:
- **Banker's Algorithm** for resource allocation and safety checking.
- **Deadlock Detection** using a wait-for graph and depth-first search (DFS).
- **Deadlock Prevention** by denying resource requests that would lead to unsafe states or deadlocks.

## Requirements
- Java 8 or later
- Any IDE or text editor to run Java code (e.g., IntelliJ IDEA, Eclipse, VS Code, etc.)
- Command-line interface (CLI) for compilation and execution (optional)

## How It Works

### 1. **Resource Allocation:**
   - Processes request resources that are granted based on the **Banker's Algorithm** safety check.
   - If a resource request would result in an unsafe state, it is denied to prevent deadlock.
  
### 2. **Deadlock Detection:**
   - The system builds a **wait-for graph** to check for cycles (indicating deadlock).
   - If a cycle is detected, the system identifies the processes involved and prints the deadlock information.
   
### 3. **Deadlock Prevention:**
   - If a resource request would lead to deadlock, the system will deny the request and inform the user.
   - The system also reverts any resource allocations if granting the request leads to deadlock.

## How to Use

### 1. **Clone the Repository:**
 

### 2. **Compile the Java files:**
   ```bash
   javac *.java
   ```

### 3. **Run the Program:**
   ```bash
   java Main
   ```

### 4. **User Input:**
   The program will prompt you to input the following:
   - **Number of resource types** and the available resources.
   - **Number of processes** and the allocation and maximum resource needs for each process.
   - **Resource request** from a specific process.

### Example Interaction:

```
Enter the number of resource types: 3
Enter available resources: 
10 5 7
Enter the number of processes: 3
Enter data for Process 0:
Enter allocation for Process 0: 
2 1 3
Enter max requirement for Process 0: 
7 5 6
Enter data for Process 1:
Enter allocation for Process 1: 
3 2 2
Enter max requirement for Process 1: 
6 4 5
Enter data for Process 2:
Enter allocation for Process 2: 
2 3 2
Enter max requirement for Process 2: 
5 4 3
Initial State is SAFE
Enter process ID for resource request: 1
Enter the request for Process 1: 
1 2 1
Request by P1 for resources: GRANTED
```

### 5. **Deadlock Handling:**
   If deadlock is detected, the system will output:
   ```
   Deadlock detected among processes: [1, 2]
   Preventing deadlock by denying request.
   ```

## Project Structure

```
bankers-algorithm-deadlock/
│
├── Process.java          # Process class that holds allocation, max, and need arrays.
├── BankersAlgorithm.java # Banker's Algorithm safety check.
├── DeadlockDetector.java # Deadlock detection using DFS.
├── ResourceManager.java  # Manages resources, requests, and safety checks.
├── Main.java             # Main class to run the simulation and handle user input.
├── README.md             # Project documentation.
```

