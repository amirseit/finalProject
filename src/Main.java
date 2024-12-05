import ast.AmirProgram;
import converter.CSTtoASTConverter;
import parser.*;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] filenames = {
                "projectTests/basicOperations.grammarAmir",
                "projectTests/classDeclarationExample.grammarAmir",
                "projectTests/complexExpressions.grammarAmir",
                "projectTests/conditionalLogic.grammarAmir",
                "projectTests/whileLoop.grammarAmir"
        };

        for (String filename : filenames) {
            try {
                runTest(filename);
            } catch (IOException e) {
                System.err.println("Error processing file " + filename + ": " + e.getMessage());
            }
            System.out.println("---------------------------------------------------------");
        }
    }

    public static void runTest(String filename) throws IOException {
        System.out.println("Running test for file: " + filename);
        CharStream input = CharStreams.fromFileName(filename);

        grammarAmirLexer lexer = new grammarAmirLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammarAmirParser parser = new grammarAmirParser(tokens);

        grammarAmirParser.ProgramContext cst = parser.program();
        System.out.println();
        CSTtoASTConverter converter = new CSTtoASTConverter();
        System.out.println("CST logic shown below");
        AmirProgram ast = converter.convertToAST(cst);
        System.out.println("CST logic stops here");

        System.out.println();
        System.out.println();
        System.out.println("Printing source code: ");
        System.out.println();
        String generatedSourceCode = ast.toSourceCode(0);
        System.out.println(generatedSourceCode);
        System.out.println("Finished printing source code.");
        System.out.println();
        System.out.println();
        System.out.println("Executing code:");
        ast.execute();
        System.out.println("Finished executing code.");
        System.out.println();
        System.out.println();
        printStackAndHeapContents(ast);
    }

    public static void printStackAndHeapContents(AmirProgram ast) {
        System.out.println("Stack contents:");
        Map<String, Integer> currentScopeVariables = ast.getExecutionContext().getStack().getCurrentScopeVariables();
        currentScopeVariables.forEach((varName, address) -> {
            System.out.println(varName + " -> Address: " + address);
        });
        System.out.println();
        System.out.println();
        System.out.println("Heap contents:");
        Map<Integer, Object> heapContents = ast.getExecutionContext().getHeap().getAllValues();
        heapContents.forEach((address, value) -> {
            System.out.println("Address " + address + " -> Value: " + value);
        });
    }
}
