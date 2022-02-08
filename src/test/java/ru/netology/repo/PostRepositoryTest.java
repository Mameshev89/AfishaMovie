package ru.netology.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PostMovie;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {
    private final PostRepository repo=new PostRepository();
    private PostMovie americanHistory = new PostMovie(1,"American history",2009,"horror");
    private PostMovie spiderMan = new PostMovie(2, "SpiderMan", 2000,"action");
    private PostMovie peakyBlinders = new PostMovie(3, "Peaky Blinders", 2013,"serial");


    @BeforeEach
    void setUp(){
      repo.add(americanHistory);
      repo.add(spiderMan);
      repo.add(peakyBlinders);

    }
    @Test
    void findAll() {
       PostMovie[] actual= {americanHistory,spiderMan,peakyBlinders};
       PostMovie[] expected=repo.findAll();
       assertArrayEquals(actual,expected);
    }
}