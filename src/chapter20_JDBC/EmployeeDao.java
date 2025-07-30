package chapter20_JDBC;

import java.util.ArrayList;
import java.util.List;

import db.DBconn;

public class EmployeeDao extends DBconn{
	
	public EmployeeDao() {
		super();
	}
	
	// Method
	public boolean insert(EmployeeVo employee) {
		boolean result = false;
		try {
			String sql = """
					insert into employee(emp_id, emp_name, gender, hire_date, dept_id, phone, email)
						values(?, ?, ?, curdate(), ?, ?, ?)

					""";

			getPreparedStatement(sql);
			pstmt.setString(1, employee.getEmpId());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setString(3, employee.getGender());
			pstmt.setString(4, employee.getDeptId());
			pstmt.setString(5, employee.getPhone());
			pstmt.setString(6, employee.getEmail());
			
			int resultRow = pstmt.executeUpdate();
			if(resultRow != 0) result = true;

//			getStatement();
//			if(stmt != null) {
//				StringBuilder sb = new StringBuilder();
//				sb.append("insert into employee(emp_id, emp_name, gender, hire_date, dept_id, phone, email)");
//				sb.append(" values('");
//				sb.append(employee.getEmpId() + "', '");
//				sb.append(employee.getEmpName() + "', '");
//				sb.append(employee.getGender() + "', ");
//				sb.append("curdate()" + ", '");
//				sb.append(employee.getDeptId() + "', '");
//				sb.append(employee.getPhone() + "', '");
//				sb.append(employee.getEmail() + "')");
//	
//				System.out.println(sb.toString());
//				int resultRow = stmt.executeUpdate(sb.toString());
//				if(resultRow != 0) result = true;
//				
//			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	// 3단계 - CRUD 기능에 따라 메소드 생성
	public List<EmployeeVo> getList() {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		
		String sql = """
					select 
						emp_id,
						emp_name,
						gender,
						dept_id,
						hire_date,
						phone,
						email,
						salary
					from employee
				""";
		
		try {
			
			getStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// rs 객체의 한 행 --> EmployeeVo 저장
				EmployeeVo employee = new EmployeeVo();
				
				employee.setEmpId(rs.getString(1));
				employee.setEmpName(rs.getString(2));
				employee.setGender(rs.getString(3));
				employee.setDeptId(rs.getString(4));
				employee.setHireDate(rs.getString(5));
				employee.setPhone(rs.getString(6));
				employee.setEmail(rs.getString(7));
				employee.setSalary(rs.getInt(8));
				
				list.add(employee);
			}
			
		} catch (Exception e) { e.printStackTrace(); }
		
		close();
		return list;
	}
	
}
