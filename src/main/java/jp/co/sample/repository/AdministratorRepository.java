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
		administorator.setMailAddress(rs.getString("mailAddress"));
		administorator.setPassword(rs.getString("password"));
		return administorator;
	};	
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String insertSql
			="INSERT INTO administrators(name,mailAddress,password)"
				+"VALUES(:name,:mailAddress,:password)";
				template.update(insertSql, param);
	}

	public Administrator findByMailAddressAndfPassword(String mailAddress,String password) {
		String sql ="SELECT mailAddress,password FROM administrators WHERE mailAddress=:mailAddress,password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress",mailAddress).addValue("password",password);
		List<Administrator> administratorList=template.query(sql,param,ADMINISTRATOR_ROW_MAPPER);
		if(administratorList.size()==0) {
			return null;
		}
		return administratorList.get(0);
	}
}
