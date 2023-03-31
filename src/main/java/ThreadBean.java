/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amrkamran
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;


@Named
@ViewScoped
public class ThreadBean implements Serializable{

    private List<Thread> threads;

    @PostConstruct
    public void init() {
        List<Thread> defaultThreads = new ArrayList<>();
        defaultThreads.add(new Thread(1, "Thread 1", "Aaron", new Date(), "Thread content",
                new ArrayList<Comment>() {
            {
                add(new Comment("Jack", new Date(), "Hey there"));
                add(new Comment("Arthur", new Date(), "Hey to you too"));
            }
        }));
        defaultThreads.add(new Thread(2, "Thread 2", "Aaron", new Date(), "Thread content 2",
                new ArrayList<Comment>() {
            {
                add(new Comment("Jack", new Date(), "Hey there"));
                add(new Comment("Arthur", new Date(), "Hey to you too"));
            }
        }));

        if (System.getProperty("threads") != null) {
            threads = loadThreadsFromSystemProperty();
        } else {
            threads = defaultThreads;
            saveThreadsToSystemProperty(threads);
        }
    }

    private List<Thread> loadThreadsFromSystemProperty() {
        String threadsJson = System.getProperty("threads");
        return parseThreadsFromJson(threadsJson);
    }

    private void saveThreadsToSystemProperty(List<Thread> threads) {
        String threadsJson = convertThreadsToJson(threads);
        System.setProperty("threads", threadsJson);
    }

    private List<Thread> parseThreadsFromJson(String threadsJson) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Thread>> typeReference = new TypeReference<List<Thread>>() {
        };
        return objectMapper.readValue(threadsJson, typeReference);
    }


    private String convertThreadsToJson(List<Thread> threads) {
        // TODO: Implement this method to convert the list of Thread objects into a JSON string
        return null;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
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

        // getters and setters

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public Date getDate() {
            return date;
        }

        public String getContent() {
            return content;
        }

        public List<Comment> getComments() {
            return comments;
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

        // getters and setters

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }
}
