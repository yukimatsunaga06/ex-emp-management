package jp.co.sample.repository;

/**
 * 
 * EmployeeのRepository
 * 
 * @author yukimatsunaga
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	private static final RowMapper<Employee>EMPLOYEE_ROW_MAPPER
	=(rs,i) ->{
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hireDate"));
		employee.setMailAdress(rs.getString("mailAdress"));
		employee.setZipCode(rs.getString("zipCode"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("saraly"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependentsCount"));
		return employee;
	};	
	public List<Employee> findAll(){
		String sql ="SELECT * FROM employees ORDER BY hireDate";
		List<Employee> employeeList=template.query(sql,EMPLOYEE_ROW_MAPPER);
		if(employeeList.size()==0) {
			return null;
		}
		return employeeList;
	}
	public Employee load(Integer id) {
		String sql ="SELECT * FROM employees WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		Employee employee=template.queryForObject(sql,param,EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	public void update(Employee employee) {
	SqlParameterSource param=new BeanPropertySqlParameterSource(employee);
	String updateSql="UPDATE employees SET name=:name,image=:image,gender=:gender,hireDate=:hireDate,mailAdress=:mailAdress,zipCode=:zipCode,address=:address,telephone=:telephone,saraly=:saraly,characteristics=:characteristics,dependentsCount=:dependentsCount";
	template.update(updateSql, param);
	}
	
}
