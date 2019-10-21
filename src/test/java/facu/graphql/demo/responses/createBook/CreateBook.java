package facu.graphql.demo.responses.createBook;

import facu.graphql.demo.responses.bookById.BookByIdData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBook {
    private CreateBookData data;
}
