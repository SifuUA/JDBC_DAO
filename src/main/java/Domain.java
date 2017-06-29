import businessLogic.Util;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

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
        address.setId(5L);
        address.setCountry("ASDASD");
        address.setCity("Yell");
        address.setStreet("Snow 5");
        address.setPostCode("1498");

        Employee employee = new Employee();
        employee.setId(5L);
        employee.setFirstName("Jhon");
        employee.setLastName("Snow");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1911, Calendar.APRIL, 3);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAdressId(address.getId());

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Very beautifull town!");

        try {
           // addressService.add(address);
            //employeeService.add(employee);
            projectService.add(project);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
