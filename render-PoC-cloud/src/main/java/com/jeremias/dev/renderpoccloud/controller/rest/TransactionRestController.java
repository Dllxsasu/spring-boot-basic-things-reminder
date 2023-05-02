package com.jeremias.dev.renderpoccloud.controller.rest;

import com.jeremias.dev.renderpoccloud.controller.advice.ErrorResponse;
import com.jeremias.dev.renderpoccloud.model.service.TransactionService;
import com.jeremias.dev.renderpoccloud.model.entity.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/transaction")
@Tag(name = "Transaction", description = "The transaction API")
public class TransactionRestController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(
            summary = "Find all the transactions",
            description = "Find all the transactions",
            tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class)))})
    @GetMapping
    public ResponseEntity<Iterable<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @Operation(
            summary = "Find a transaction by id",
            description = "Find a transaction by id",
            tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))})
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable("id") String id) {

        final var optionalTransaction = transactionService.findById(UUID.fromString(id));

        return optionalTransaction.isEmpty() ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(optionalTransaction.get());
    }


}
