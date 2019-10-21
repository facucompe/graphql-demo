package facu.graphql.demo.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import facu.graphql.demo.enumerators.Genre;
import facu.graphql.demo.models.Book;
import facu.graphql.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutations implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(String name, Integer pageCount, Genre genre){
        Book book = new Book();
        book.setName(name);
        book.setPageCount(pageCount);
        book.setGenre(genre);
        return bookRepository.save(book);
    };
}
