import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownInterpreter {

    public static String interpretMarkdown(String markdown) {
        // 处理标题
        String processed = handleHeadings(markdown);

        // 处理段落
        processed = handleParagraphs(processed);

        // 处理加粗
        processed = handleBold(processed);

        // 处理斜体
        processed = handleItalic(processed);

        // 处理无序列表
        processed = handleUnorderedLists(processed);

        // 处理有序列表
        processed = handleOrderedLists(processed);

        // 处理代码块
        processed = handleCodeBlocks(processed);

        return processed;
    }

    // 处理标题
    private static String handleHeadings(String markdown) {
        String pattern = "^(#+)\\s*(.*)$";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);
        Matcher m = r.matcher(markdown);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            int level = m.group(1).length();
            String title = m.group(2);
            m.appendReplacement(sb, "<h" + level + ">" + title + "</h" + level + ">");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    // 处理段落
    private static String handleParagraphs(String markdown) {
        // 修正：确保不是在其他标签内部才添加段落标签
        return markdown.replaceAll("^((?!<[a-zA-Z]+>).)*$", "<p>$0</p>");
    }

    // 处理加粗
    private static String handleBold(String markdown) {
        String pattern = "(?<!\\w)(__)(?!\\w)(.*?)(?<!\\w)\\1(?!\\w)";
        return markdown.replaceAll(pattern, "<strong>$2</strong>");
    }

    // 处理斜体
    private static String handleItalic(String markdown) {
        String pattern = "(?<!\\w)(_)(?!\\w)(.*?)(?<!\\w)\\1(?!\\w)";
        return markdown.replaceAll(pattern, "<em>$2</em>");
    }

    // 处理无序列表
    private static String handleUnorderedLists(String markdown) {
        String pattern = "^\\*\\s*(.*)$";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);
        Matcher m = r.matcher(markdown);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String item = m.group(1);
            m.appendReplacement(sb, "<li>" + item + "</li>");
        }
        m.appendTail(sb);
        if (sb.length() > 0) {
            // 修正：确保是完整的列表项才添加<ul>
            return sb.toString().replaceAll("(?s)(<li>.*?</li>)\\s*(<li>.*?</li>)", "<ul>$1</ul><ul>$2</ul>");
        }
        return markdown;
    }

    // 处理有序列表
    private static String handleOrderedLists(String markdown) {
        String pattern = "^\\d+\\.\\s*(.*)$";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);
        Matcher m = r.matcher(markdown);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String item = m.group(1);
            m.appendReplacement(sb, "<li>" + item + "</li>");
        }
        m.appendTail(sb);
        if (sb.length() > 0) {
            // 修正：确保是完整的列表项才添加<ol>
            return sb.toString().replaceAll("(?s)(<li>.*?</li>)\\s*(<li>.*?</li>)", "<ol>$1</ol><ol>$2</ol>");
        }
        return markdown;
    }

    // 处理代码块
    private static String handleCodeBlocks(String markdown) {
        String pattern = "```([^`]*)```";
        return markdown.replaceAll(pattern, "<pre><code>$1</code></pre>");
    }

    public static void main(String[] args) {
        String markdownText = "  ";
        String htmlOutput = interpretMarkdown(markdownText);
        System.out.println(htmlOutput);
    }
}