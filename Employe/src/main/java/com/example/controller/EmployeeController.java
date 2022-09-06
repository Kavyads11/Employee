package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Employee;

import com.example.service.EmployeeService;

@RestController
@RequestMapping(value = "/book")
public class EmployeeController {
    @Autowired
    private EmployeeService bookService;
    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    @ResponseBody
    public Employee saveBook(@RequestBody Employee book) {
        Employee bookResponse = bookService.saveBook(book);
        return bookResponse;
    }
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getBookDetails(@PathVariable int bookId) {
    	Employee bookResponse = bookService.findByBookId(bookId);
        return bookResponse;
    }
}