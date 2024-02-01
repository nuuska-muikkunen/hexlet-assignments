package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.mapstruct.AfterMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookMapper bookMapper;

    @AfterMapping
    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO create(BookCreateDTO bookData) throws ResourceNotFoundException {
        var book = bookMapper.map(bookData);
        authorRepository.findById(bookData.getAuthorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request"));
        var author = authorRepository.getReferenceById(bookData.getAuthorId());
        book.setAuthor(author);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO update(BookUpdateDTO bookData, Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        if (!bookData.getAuthorId().isPresent()) {
            authorRepository.findById(bookData.getAuthorId().orElse(1L));
            throw new ResourceNotFoundException("AuthorId Not Found");
        }
        authorRepository.getReferenceById(bookData.getAuthorId().get());
        bookMapper.update(bookData, book);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    // END
}
