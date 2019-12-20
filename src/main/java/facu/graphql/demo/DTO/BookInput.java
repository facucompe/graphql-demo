package facu.graphql.demo.DTO;

import facu.graphql.demo.enumerators.Genre;
import lombok.Data;

@Data
public class BookInput {
    private String name;
    private Genre genre;
    private Integer pageCount;
}
