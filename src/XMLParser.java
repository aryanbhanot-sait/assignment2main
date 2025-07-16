import implementations.MyStack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLParser {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar Parser.jar <xml-file>");
            System.exit(1);
        }
        try {
            parse(args[0]);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void parse(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        MyStack<String> stack = new MyStack<>();
        String line;
        int lineNum = 0;

        Pattern tagPattern = Pattern.compile("<(/?)([^\\s>/]+)[^>]*?(/?)>");
        while ((line = reader.readLine()) != null) {
            lineNum++;
            Matcher m = tagPattern.matcher(line);
            while (m.find()) {
                String slashOpen = m.group(1);
                String tagName = m.group(2);
                String selfClose = m.group(3);

                if (tagName.startsWith("?"))
                    continue;

                if (slashOpen.equals("/")) {
                    if (stack.isEmpty() || !stack.peek().equals(tagName)) {
                        System.out.printf("Line %d: mismatched closing tag </%s>%n", lineNum, tagName);
                    } else {
                        stack.pop();
                    }
                } else if (selfClose.equals("/")) {
                } else {
                    stack.push(tagName);
                }
            }
        }
        reader.close();

        while (!stack.isEmpty()) {
            System.out.printf("Missing closing tag for <%s>%n", stack.pop());
        }
    }
}