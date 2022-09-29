package com.example.demo.service;

import java.util.List;




import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeAddressMaster;







public interface EmployeService {
	
	//public Employe insertEmploye(Employe employe);
	//public Employe updateEmploye(Employe employe);
	public Optional<Employe> findEmploye(Integer id);
	public Iterable<Employe> findAllEmploye(); 
	//public boolean deleteEmploye(Employe employe);
	
	
	
	public Employe addEmploye(Employe emp);
	public Employe updateEmploye(Employe emp);
	public String deleteEmploye(int id);
	public Employe  getEmploye(int id);
    public List<Employe> findPaginated(int pageNo , int pageSize);
		
	
	
}
