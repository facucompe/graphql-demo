package facu.graphql.demo.responses.bookById;

import facu.graphql.demo.enumerators.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private Genre genre;
    private Integer pageCount;
}
