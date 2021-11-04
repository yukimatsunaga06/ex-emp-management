package jp.co.sample.repository;
/**
 * 
 * AdministratorのRepository
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

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	private static final RowMapper<Administrator>ADMINISTRATOR_ROW_MAPPER
	=(rs,i) ->{
		Administrator administorator = new Administrator();
		administorator.setId(rs.getInt("id"));
		administorator.setName(rs.getString("name"));
		administorator.setMailAdress(rs.getString("mailAdress"));
		administorator.setPassword(rs.getString("password"));
		return administorator;
	};	
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String insertSql
			="INSERT INTO administrator(name,mailAdress,password)"
				+"VALUES(:name,:mailAdress,:password)";
				template.update(insertSql, param);
	}

	public Administrator findByMailAddressAndfPassword(String mailAdress,String password) {
		String sql ="SELECT mailAdress,password FROM administrators WHERE mailAdress=:mailAdress,password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAdress",mailAdress).addValue("password",password);
		List<Administrator> administratorList=template.query(sql,param,ADMINISTRATOR_ROW_MAPPER);
		if(administratorList.size()==0) {
			return null;
		}
		return administratorList.get(0);
	}
}
