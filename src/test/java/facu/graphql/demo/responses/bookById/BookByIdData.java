package facu.graphql.demo.responses.bookById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookByIdData {
    private Book bookById;
}
