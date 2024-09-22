import java.util.ArrayList;
import java.util.List;
public class MaxWidthString{
    public static void main(String[] args) {
        List<String> words1 = List.of("This", "is", "an", "example", "of", "text", "justification.");
        int maxWidth1 = 16;
        List<String> result1 = fullJustify(words1, maxWidth1);
        printResult(result1);
    }
    public static List<String> fullJustify(List<String> words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLineLength = 0;
        for (String word : words) {
            if (currentLineLength + word.length() + currentLine.size() > maxWidth) {
                result.add(justifyLine(currentLine, currentLineLength, maxWidth, false));
                currentLine = new ArrayList<>();
                currentLineLength = 0;
            }
            currentLine.add(word);
            currentLineLength += word.length();
        }
        result.add(justifyLine(currentLine, currentLineLength, maxWidth, true));
        return result;
    }

    private static String justifyLine(List<String> line, int lineLength, int maxWidth, boolean isLastLine) {
        if (isLastLine || line.size() == 1) {
            StringBuilder sb = new StringBuilder(String.join(" ", line));
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int totalSpaces = maxWidth - lineLength;
        int numberOfGaps = line.size() - 1;
        int spaceBetweenWords = totalSpaces / numberOfGaps;
        int extraSpaces = totalSpaces % numberOfGaps;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i < numberOfGaps) {
                int spacesToAdd = spaceBetweenWords + (i < extraSpaces ? 1 : 0);
                for (int j = 0; j < spacesToAdd; j++) {
                    sb.append(' ');
                }
            }
        }

        return sb.toString();
    }

    private static void printResult(List<String> result) {
        System.out.println("[");
        for (String line : result) {
            System.out.println("   \"" + line + "\",");
        }
        System.out.println("]");
    }
}
