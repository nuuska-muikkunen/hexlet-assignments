package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.model.Book;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> index() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO show(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<BookDTO> create(@RequestBody BookCreateDTO bookData) {
        try {
            var bookDTO = bookService.create(bookData);
            return ResponseEntity.status(201)
                    .body(bookDTO);
        } catch (DataIntegrityViolationException e) {
            var bookDTO = bookService.create(bookData);
            return ResponseEntity.status(400)
                    .body(bookDTO);
    }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO update(@RequestBody BookUpdateDTO authorData, @PathVariable Long id) {
        return bookService.update(authorData, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    // END
}
