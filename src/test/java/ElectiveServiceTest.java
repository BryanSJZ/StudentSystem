import com.nenu.software.common.entity.Class;
import com.nenu.software.common.entity.Elective;
import com.nenu.software.service.ClassService;
import com.nenu.software.service.ElectiveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shanjz
 * @since 2018/6/20 10:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mybatis.xml"})
public class ElectiveServiceTest {

    @Autowired
    ElectiveService electiveService;

    @Test
    public void testNewElective() throws Exception {
        Elective elective = new Elective();
        elective.setStuId(1);
        elective.setCourseId(1);
        elective.setScore(100);
        electiveService.newElective(elective);
        System.out.println("new over");
    }

    @Test
    public void testDeleteElectiveByConditiond() throws Exception {
        electiveService.deleteElectiveByConditions(null, null, 1);
    }

    @Test
    public void testUpdateElective() throws Exception {
        Elective elective = new Elective();
        elective.setId(1);
        elective.setStuId(1);
        elective.setCourseId(2);
        elective.setScore(95);
        electiveService.updateElective(elective);
        System.out.println("update over");
    }

    @Test
    public void testSelectElective() throws Exception {
        System.out.println(electiveService.selectElectiveById(1));
        System.out.println(electiveService.listElectiveByConditions(null, null));
    }


}
