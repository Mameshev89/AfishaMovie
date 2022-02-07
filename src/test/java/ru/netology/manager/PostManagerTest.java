package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PostMovie;
import ru.netology.repo.PostRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



class PostManagerTest {
    private final PostRepository repo=Mockito.mock(PostRepository.class);

    private final PostManager manager=new PostManager(repo);

    private  final  PostManager manager2=new PostManager(repo,2);
    private PostMovie americanHistory = new PostMovie(1, "American history", 2009, "horror");
    private PostMovie spiderMan = new PostMovie(2, "SpiderMan", 2000, "action");
    private PostMovie peakyBlinders = new PostMovie(3, "Peaky Blinders", 2013, "serial");

    @Test
    void save() {
        doNothing().when(repo).add(any());
        doReturn(new PostMovie[]{americanHistory}).when(repo).findAll();
        manager.save(americanHistory);
        Assertions.assertArrayEquals(new PostMovie[]{americanHistory}, manager.lastFilm());

        verify(repo).add(any());
    }

    @Test
    void lastFilm() {
        doReturn(new PostMovie[]{americanHistory, spiderMan, peakyBlinders}).when(repo).findAll();
        PostMovie[] actual = {peakyBlinders, spiderMan, americanHistory};
        PostMovie[] expected = manager.lastFilm();
        assertArrayEquals(actual, expected);
    }

    @Test
    void lastFilmWithLimit() {
        doReturn(new PostMovie[]{americanHistory, spiderMan, peakyBlinders}).when(repo).findAll();
        PostMovie[] actual = {peakyBlinders, spiderMan};
        PostMovie[] expected = manager2.lastFilm();
        assertArrayEquals(actual, expected);
    }

    @Test
    void removeById() {
        doNothing().when(repo).removeId(any());
        doReturn(new PostMovie[]{americanHistory, peakyBlinders}).when(repo).findAll();
        manager.remove(2);
        PostMovie[] actual = {peakyBlinders, americanHistory};
        PostMovie[] expected = manager.lastFilm();
        assertArrayEquals(actual, expected);

        verify(repo).removeId(any());
    }


}

