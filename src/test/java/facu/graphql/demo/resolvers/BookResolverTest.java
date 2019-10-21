package facu.graphql.demo.resolvers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import facu.graphql.demo.enumerators.Genre;
import facu.graphql.demo.models.Book;
import facu.graphql.demo.repositories.BookRepository;
import facu.graphql.demo.responses.bookById.BookById;
import facu.graphql.demo.responses.createBook.CreateBook;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static graphql.Assert.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookResolverTest extends GraphQLBaseTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    private Book book;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        book = new Book();
        book.setName("1984");
        book.setGenre(Genre.DRAMA);
        book.setPageCount(250);
        bookRepository.save(book);
    }

    @After
    public void after() {
        bookRepository.delete(book);
    }

    @Test
    public void bookById() throws IOException {
        final ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("id", book.getId());

        GraphQLResponse findResponse = graphQLTestTemplate.perform("queries/bookById.graphqls", rootNode);

        log.info(String.format("Response: %s", findResponse.getRawResponse().toString()));

        BookById bookById = objectMapper.readValue(
                findResponse.getRawResponse().getBody(),
                BookById.class);

        assertNotNull(findResponse);
        assertTrue(findResponse.isOk());
        assert (bookById.getData().getBookById().getId()).equals(book.getId());
        assert (bookById.getData().getBookById().getName()).equals(book.getName());
        assertNull(bookById.getData().getBookById().getGenre());
    }

    @Test
    public void createBook() throws IOException {
        final ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("name", "Brave new world");
        rootNode.put("genre", Genre.DRAMA.name());
        rootNode.put("pageCount", 123);

        GraphQLResponse findResponse = graphQLTestTemplate.perform("queries/createBook.graphqls", rootNode);

        log.info(String.format("Response: %s", findResponse.getRawResponse().toString()));

        CreateBook createBook = objectMapper.readValue(
                findResponse.getRawResponse().getBody(),
                CreateBook.class);

        assertNotNull(findResponse);
        assertTrue(findResponse.isOk());
        assert (createBook.getData().getCreateBook().getName()).equals("Brave new world");
        assertNull(createBook.getData().getCreateBook().getGenre());
    }
}
