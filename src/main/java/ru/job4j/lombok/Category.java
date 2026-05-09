package ru.job4j.lombok;

import lombok.*;

@RequiredArgsConstructor
public class Category {
    @NonNull
    @Getter
    @EqualsAndHashCode.Include
    private Integer id;
    @Getter
    @Setter
    private String name;
}
