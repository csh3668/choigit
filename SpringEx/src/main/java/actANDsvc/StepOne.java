package actANDsvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Data;

import model.field_rent;
import model.Login_info;



@Repository
public class StepOne {
	@Autowired
	DataSource dataSrc;
	
	@Autowired
	SqlSession sql; 
	
	Connection con = null;
	Statement stm = null;
	
	public void diconn() {//연결 해제 메소드
		try{
			stm.close();
			con.close();
		}catch(Exception ignored){
			
		}
	}
	
	public List<field_rent>rent_select() throws Exception {
		List<field_rent>db_rent= sql.selectList("select_list");

		return db_rent;
	}
	public Login_info log_select(Login_info uid){
		Login_info db_log= sql.selectOne("log_select",uid);
		return db_log ;
	}
	
	public void db_insert(@ModelAttribute field_rent list) throws Exception {
		sql.insert("db_insert",list);
	}
	public void db_delete(@RequestParam Integer num) throws Exception  {	
		sql.delete("db_delete", num);
	}
	public field_rent detail_select(Integer num) throws Exception {
		field_rent detail=sql.selectOne("white_select",num);
		System.out.println(detail+"db셀렉트 가져옴");
		return detail;
	}
}