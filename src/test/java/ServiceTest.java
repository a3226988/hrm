import com.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by gc on 2020/5/17
 * 铁甲依然在
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-bean.xml","classpath:applicationContext-datasource.xml"})
public class ServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void test(){
        employeeService.queryAll().forEach(employee -> {
            System.out.println(employee.getName()+employee.getDept().getName()+employee.getJob().getName());
        });
    }
}
