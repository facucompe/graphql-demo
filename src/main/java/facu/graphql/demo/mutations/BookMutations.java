package facu.graphql.demo.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sun.xml.bind.v2.TODO;
import facu.graphql.demo.enumerators.Genre;
import facu.graphql.demo.models.Book;
import facu.graphql.demo.repositories.BookRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutations implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    // TODO: Input types are not working. However information can be parsed from dataFetchingEnvironment
    public Book createBook(String name, Integer pageCount, Genre genre, DataFetchingEnvironment dataFetchingEnvironment){
        Book book = new Book();
        book.setName(name);
        book.setPageCount(pageCount);
        book.setGenre(genre);
        return bookRepository.save(book);
    };
}
