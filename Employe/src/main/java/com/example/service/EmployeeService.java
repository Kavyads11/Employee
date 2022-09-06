package com.example.service;

import org.springframework.stereotype.Component;


import com.example.entity.Employee;

@Component
public interface  EmployeeService {
    public Employee saveBook( Employee book);
    public  Employee findByBookId(int bookId);
}