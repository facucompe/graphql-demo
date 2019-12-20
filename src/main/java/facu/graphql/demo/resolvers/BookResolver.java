package facu.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import facu.graphql.demo.DTO.BookInput;
import facu.graphql.demo.models.Book;
import facu.graphql.demo.repositories.BookRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    public Book bookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public Book createBook(BookInput bookInput, DataFetchingEnvironment dataFetchingEnvironment){
        Book book = new Book();
        book.setName(bookInput.getName());
        book.setGenre(bookInput.getGenre());
        book.setPageCount(bookInput.getPageCount());
        return bookRepository.save(book);
    }
}
