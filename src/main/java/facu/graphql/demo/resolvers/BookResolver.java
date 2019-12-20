package facu.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import facu.graphql.demo.enumerators.Genre;
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

    // TODO: Input types are not working. However information can be parsed from dataFetchingEnvironment
    public Book createBook(String name, Integer pageCount, Genre genre, DataFetchingEnvironment dataFetchingEnvironment){
        Book book = new Book();
        book.setName(name);
        book.setPageCount(pageCount);
        book.setGenre(genre);
        return bookRepository.save(book);
    }
}
