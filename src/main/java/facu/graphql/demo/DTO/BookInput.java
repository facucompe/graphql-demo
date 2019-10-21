package facu.graphql.demo.DTO;

import facu.graphql.demo.enumerators.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

    private String name;

    private Integer pageCount;

    private Genre genre;
}
