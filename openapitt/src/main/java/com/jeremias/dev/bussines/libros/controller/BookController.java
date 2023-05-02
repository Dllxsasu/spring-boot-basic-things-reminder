package com.jeremias.dev.bussines.libros.controller;

import com.jeremias.dev.bussines.libros.controller.dto.BookRequest;
import com.jeremias.dev.bussines.libros.controller.dto.BookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Operation(summary = "Create book", description = "This can only be done by the logged in book.", tags = { "book" })
    @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BookRequest.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = BookRequest.class)) }) })
    @PostMapping
    public ResponseEntity<Object> create(@Parameter(description = "Created book object", required = true) @Valid @RequestBody BookRequest book){
        return ResponseEntity.accepted().body("asd");
    }
    @Operation(summary = "Find book by ID", description = "Returns a single book", tags = { "book" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = BookRequest.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> create( @Parameter(description = "ID of book", required = true)
                                              @PathVariable long id){
        return ResponseEntity.accepted().body("asd");
    }

    @Operation(summary = "Get books", description = "Returns a collection of books", tags = { "book" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponse.class))),
            @ApiResponse(responseCode = "404", description = "Books not found")
    })@GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findBooks(){
        return List.of();
    }
}
