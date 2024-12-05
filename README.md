# Python Subset Interpreter

## Project Overview
This project implements an interpreter for a formally defined subset of Python using Java. The goal is to provide hands-on experience in understanding the operational semantic rules of programming languages while developing a functional interpreter. The interpreter is built upon grammar rules defined using **ANTLR** and leverages a robust design architecture to replicate Python's dynamic typing system and execution model.

---

## Key Features
- **Lexer and Parser Generation**: Utilizes ANTLR to generate Lexer and Parser rules for a subset of Python.
- **Operational Semantics**: Implements a semantic interpreter in Java based on carefully crafted operational semantic rules.
- **Dynamic Typing System**: Mimics Python’s dynamic typing system using Java.
- **Error Handling**: Handles both syntax and runtime errors with clear, helpful messages.
- **Text-Based Input and Output**: Users can input Python code via text files and view the results in the IDE’s standard output.
- **Extendable Design**: Designed for scalability, enabling future enhancements and feature additions.

---

## Objectives
1. Develop Lexer and Parser rules in ANTLR for the defined subset of Python.
2. Define and implement operational semantic rules.
3. Build a semantic interpreter in Java for executing Python code.
4. Implement comprehensive testing and debugging processes.
5. Document the entire design and development process for future reference.

---

## Functional Requirements
1. **Parsing Input**: Accurately parses Python code and builds a parse tree.
2. **Code Execution**: Executes Python code based on operational semantic rules.
3. **Error Handling**: Detects and reports both syntax and runtime errors.
4. **Text-Based Interface**: Supports input via text files and outputs to the IDE console.

---

## Tools and Technologies
1. **ANTLR**: Used to define grammar rules and generate Lexer/Parser.
2. **Java**: The primary programming language for implementing the interpreter.
3. **IDE**: IntelliJ IDEA (recommended) with ANTLR plugin for seamless development.
4. **JRE**: Required to run the Java-based interpreter.

---

## How to Run the Project
1. **Setup**: Ensure Java Runtime Environment (JRE) and IntelliJ IDEA are installed.
2. **Clone Repository**: Clone the project repository to your local machine.
3. **ANTLR Integration**: Install the ANTLR plugin in IntelliJ IDEA and configure it for the project.
4. **Input Code**: Write the Python subset code in a `.txt` file and specify it as input to the interpreter.
5. **Run the Interpreter**: Execute the main function in your IDE to process the input file.
6. **View Results**: Check the standard output window for the execution results or error messages.

---

## Project Structure
- `src/`: Contains the Java implementation of the interpreter.
- `test/`: Includes test files and test cases for the interpreter.
- `gen/`: ANTLR-generated files (Lexer, Parser, etc.).
- `.idea/`: IntelliJ IDEA project files.
- `finalProjectTwo.iml`: IntelliJ project configuration file.
- `ReadMe`: Project overview and instructions (this file).

---

## Future Enhancements
1. Explore implementing a static typing system for the subset of Python.
2. Add support for more advanced Python features.
3. Optimize memory allocation strategies for enhanced performance.
4. Expand the testing suite to include edge cases and larger programs.

---

## Contact
For questions or contributions, please contact the project owner or submit a pull request on the repository.

---

**Happy coding!**