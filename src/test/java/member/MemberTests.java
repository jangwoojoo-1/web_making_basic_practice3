package member;

import com.ssg.membertest.member.MemberDTO;
import com.ssg.membertest.member.MemberDaoJdbc;
import com.ssg.membertest.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RequiredArgsConstructor
public class MemberTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberDaoJdbc memberDaoJdbc;

    @Test
    public void testMemberService(){
        log.info(memberService);
        Assertions.assertNotNull(memberService);
    }

    @Test
    public void testDataSource() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveTest() {
        MemberDTO dto = new MemberDTO();
        dto.setMid("id07");
        dto.setMpw("pwd07");
        dto.setMname("name07");

        memberService.save(dto);
    }
    @Test
    public void printTest() {
        memberService.printAll();
    }

    @Test
    public void insertTest() throws Exception {
        MemberDTO dto = new MemberDTO();
        dto.setMid("id05");
        dto.setMpw("pwd05");
        dto.setMname("name05");

        log.info(memberDaoJdbc.insertMember(dto));
    }

    @Test
    public void selectAllTest() throws Exception {
        memberDaoJdbc.selectAll().forEach(memberDTO -> {
            log.info(memberDTO);
        });
    }
}
