package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import parser.grammarAmirLexer;

public class LexerTest {

    private CommonTokenStream generateTokenStream(String input) {
        grammarAmirLexer lexer = new grammarAmirLexer(CharStreams.fromString(input));
        return new CommonTokenStream(lexer);
    }

    @Test
    public void testOperators() {
        String input = "+ - * /";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.OPERATOR, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.OPERATOR, tokens.get(1).getType());
        assertEquals(grammarAmirLexer.OPERATOR, tokens.get(2).getType());
        assertEquals(grammarAmirLexer.OPERATOR, tokens.get(3).getType());
    }

    @Test
    public void testComparisonOperators() {
        String input = "== != < > <= >=";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.COMP_OP, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.COMP_OP, tokens.get(1).getType());
        assertEquals(grammarAmirLexer.COMP_OP, tokens.get(2).getType());
        assertEquals(grammarAmirLexer.COMP_OP, tokens.get(3).getType());
        assertEquals(grammarAmirLexer.COMP_OP, tokens.get(4).getType());
        assertEquals(grammarAmirLexer.COMP_OP, tokens.get(5).getType());
    }

    @Test
    public void testStringLiterals() {
        String input = "\"Amir\" \"Seit\"";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.STRING, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.STRING, tokens.get(1).getType());
        assertTrue(tokens.get(0).getText().equals("\"Amir\""));
        assertTrue(tokens.get(1).getText().equals("\"Seit\""));
    }

    @Test
    public void testIntegerLiterals() {
        String input = "123 456";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.INT, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.INT, tokens.get(1).getType());
        assertEquals("123", tokens.get(0).getText());
        assertEquals("456", tokens.get(1).getText());
    }

    @Test
    public void testIdentifiers() {
        String input = "age _mood";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.ID, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.ID, tokens.get(1).getType());
    }

    @Test
    public void testSelfIdentifiers() {
        String input = "self.age self.mood";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.SELF_ID, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.SELF_ID, tokens.get(1).getType());
    }

    @Test
    public void testNewlines() {
        String input = "\n \r\n";
        CommonTokenStream tokens = generateTokenStream(input);
        tokens.fill();
        assertEquals(grammarAmirLexer.NEWLINE, tokens.get(0).getType());
        assertEquals(grammarAmirLexer.NEWLINE, tokens.get(1).getType());
    }

    @Test
    public void testWhitespace() {
        String input = "    \t";
        grammarAmirLexer lexer = new grammarAmirLexer(CharStreams.fromString(input));
        Token token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType());
    }
}

