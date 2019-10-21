package facu.graphql.demo.responses.createBook;

import facu.graphql.demo.responses.bookById.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookData {
    private Book createBook;
}
