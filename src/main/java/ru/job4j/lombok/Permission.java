package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
public class Permission {
    @Getter
    @EqualsAndHashCode.Include
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @Singular("rule")
    private List<String> rules;
}