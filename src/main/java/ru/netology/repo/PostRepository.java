package ru.netology.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.PostMovie;



@NoArgsConstructor

public class PostRepository {
    private PostMovie[] items = new PostMovie[0];

    public void add(PostMovie item) {
        PostMovie[] tmt = new PostMovie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmt[i] = items[i];
        }
        tmt[tmt.length - 1] = item;
        items = tmt;
    }
    public PostMovie[] findAll(){
        return items;
    }

    public void removeId(int id) {
        PostMovie[] tmt = new PostMovie[items.length - 1];
        int index = 0;
        for (PostMovie item : items) {
            if (item.getId() != id) {
                tmt[index] = item;
                index++;
            }

        }
        items = tmt;
    }
}
