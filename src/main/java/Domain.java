import businessLogic.Util;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public class Domain {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        EmplProjService emplProjService = new EmplProjService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setId(10L);
        address.setCountry("DC");
        address.setCity("Gotham");
        address.setStreet("Light 5");
        address.setPostCode("2498");

        Employee employee = new Employee();
        employee.setId(10L);
        employee.setFirstName("Sally");
        employee.setLastName("Pet");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1971, Calendar.APRIL, 3);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAdressId(address.getId());

        Project project = new Project();
        project.setId(10L);
        project.setTitle("Very beautifull town!");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
//            addressService.add(address);
//            employeeService.add(employee);
//            projectService.add(project);
//            emplProjService.add(emplProj);

            List<Address> addressList = addressService.getAll();
            for (Address a : addressList)
                System.out.println(a);

            List<Employee> employeeList = employeeService.getAll();
            for (Employee e : employeeList)
                System.out.println(e);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
