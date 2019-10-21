package facu.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import facu.graphql.demo.models.Book;
import facu.graphql.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    public Book bookById(Integer id) {
        return bookRepository.findById(id).get();
    }
}
