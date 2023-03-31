/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

/**
 *
 * @author amrkamran
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadModel {

    public static void main(String[] args) {
        List<Thread> defaultThreads = new ArrayList<Thread>();
        defaultThreads.add(new Thread(1, "Thread 1", "Aaron", new Date(), "Thread content", 
            new ArrayList<Comment>() {{
                add(new Comment("Jack", new Date(), "Hey there"));
                add(new Comment("Arthur", new Date(), "Hey to you too"));
            }}));
        defaultThreads.add(new Thread(2, "Thread 2", "Aaron", new Date(), "Thread content 2", 
            new ArrayList<Comment>() {{
                add(new Comment("Jack", new Date(), "Hey there"));
                add(new Comment("Arthur", new Date(), "Hey to you too"));
            }}));

        List<Thread> threads;
        if (System.getProperty("threads") != null) {
            threads = loadThreadsFromSystemProperty();
        } else {
            threads = defaultThreads;
            saveThreadsToSystemProperty(threads);
        }
    }

    private static List<Thread> loadThreadsFromSystemProperty() {
        String threadsJson = System.getProperty("threads");
        return parseThreadsFromJson(threadsJson);
    }

    private static void saveThreadsToSystemProperty(List<Thread> threads) {
        String threadsJson = convertThreadsToJson(threads);
        System.setProperty("threads", threadsJson);
    }

    private static List<Thread> parseThreadsFromJson(String threadsJson) {
        // TODO: Implement this method to parse the JSON string into a list of Thread objects
        return null;
    }

    private static String convertThreadsToJson(List<Thread> threads) {
        // TODO: Implement this method to convert the list of Thread objects into a JSON string
        return null;
    }

    private static class Thread {
        private int id;
        private String title;
        private String author;
        private Date date;
        private String content;
        private List<Comment> comments;

        public Thread(int id, String title, String author, Date date, String content, List<Comment> comments) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.date = date;
            this.content = content;
            this.comments = comments;
        }
    }

    private static class Comment {
        private String author;
        private Date date;
        private String content;

        public Comment(String author, Date date, String content) {
            this.author = author;
            this.date = date;
            this.content = content;
        }
    }
}
