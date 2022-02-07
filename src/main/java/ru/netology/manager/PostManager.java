package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.netology.domain.PostMovie;
import ru.netology.repo.PostRepository;

//@NoArgsConstructor

@RequiredArgsConstructor
@AllArgsConstructor
public class PostManager {


    private final PostRepository repository;
    private int limit = 10;



    public PostMovie[] lastFilm() {
        PostMovie[] result = repository.findAll();
        PostMovie[] tmt=new PostMovie[Math.min(result.length, limit)];
        for (int i=0;i<tmt.length;i++){
            tmt[i]=result[result.length-i-1];
        }
        return  tmt;
    }

    public void save(PostMovie item)
    {
        repository.add(item);
    }

    public void remove(int id){
        repository.removeId(id);

    }
}
