package ru.netology.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Afisha;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AfishaRepository {
    private Afisha[] items = new Afisha[0];

    public void save(Afisha item) {
        Afisha[] tmt = new Afisha[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmt[i] = items[i];
        }
        tmt[tmt.length - 1] = item;
        items = tmt;
    }
}
