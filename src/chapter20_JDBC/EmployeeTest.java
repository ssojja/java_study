package chapter20_JDBC;

import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		
		EmployeeVo insertVo = new EmployeeVo();
		insertVo.setEmpId("S0024");
		insertVo.setEmpName("박아무개");
		insertVo.setGender("M");
		insertVo.setDeptId("MKT");
		insertVo.setPhone("010-1234-8888");
		insertVo.setEmail("PARK@test.com");
		
		if(dao.insert(insertVo)) {
			List<EmployeeVo> list = dao.getList();
			list.forEach((employee) -> {
				System.out.print(employee.getEmpId() + "\t");
				System.out.print(employee.getEmpName() + "\t");
				System.out.print(employee.getGender() + "\t");
				System.out.print(employee.getDeptId() + "\t");
				System.out.print(employee.getHireDate() + "\t");
				System.out.print(employee.getPhone() + "\t");
				System.out.print(employee.getEmail() + "\t");
				System.out.print(employee.getSalary() + "\n");
			});
			
		}

		dao.close();
	}

}
