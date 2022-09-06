package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;


@Service
public class  EmployeeServiceImpl implements  EmployeeService {
    @Autowired
    private  EmployeeRepository bookRepository;
    public  Employee saveBook( Employee book) {
        Department story = book.getDepartment();
        story.setEmployee(book);
        book = bookRepository.save(book);
        return book;
    }
    public  Employee findByBookId(int bookId) {
    	 Employee book = bookRepository.findByBookId(bookId);
        return book;
    }
}