import com.dao.DeptDao;
import com.dao.NoticeDao;
import com.entity.Dept;
import com.entity.Employee;
import com.entity.Notice;
import com.service.DeptService;
import com.service.EmployeeService;
import com.service.NoticeService;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by gc on 2020/5/17
 * 铁甲依然在
 */
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-bean.xml","classpath:applicationContext-datasource.xml"})
public class ServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DeptService deptService;

    @Test
    public void test(){
        employeeService.queryAll(1,5,new Employee()).forEach(employee -> {
            System.out.println(employee.getName()+employee.getDept().getName()+employee.getJob().getName());
        });
    }

    @Test
    public void test1(){
        deptService.queryAll(new Dept());
    }

    @Autowired
    DeptDao deptDao;

    @Autowired
    private NoticeDao noticeDao;

    @Test
    public void testDao(){
         /*deptDao.selectAll().forEach(dept -> {
             System.out.println(dept);
         });*/
        /* noticeDao.selectAll().forEach(notice -> {
             System.out.println(notice);
         });*/

        //System.out.println(noticeDao.selectByPrimaryKey(1));
        //System.out.println(deptDao.getIds());
        System.out.println(deptDao.getNames());
    }

    @Autowired
    NoticeService noticeService;
    @Test
    public void testBaseService(){
        /*employeeService.queryAll(1,2,new Employee()).forEach(employee -> {
            System.out.println(employee);
        });*/
        noticeService.queryAll(new Notice()).forEach(notice -> {
            System.out.println(notice);
        });
    }
}
