package com.ssg.membertest.member;

import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private DataSource dataSource;

    public boolean insertMember(MemberDTO dto) throws Exception{
        String sql = "insert into t_member(mid, mpw, mname) values(?,?,?)";
        @Cleanup Connection conn = dataSource.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getMid());
        ps.setString(2, dto.getMpw());
        ps.setString(3, dto.getMname());
        return ps.executeUpdate() > 0;
    }

    @Override
    public List<MemberDTO> selectAll() throws Exception {
        String sql = "select * from t_member";
        @Cleanup Connection conn = dataSource.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = ps.executeQuery();
        List<MemberDTO> list = new ArrayList<>();
        while (rs.next()) {
            MemberDTO dto = new MemberDTO();
            dto.setMid(rs.getString("mid"));
            dto.setMpw(rs.getString("mpw"));
            dto.setMname(rs.getString("mname"));
            list.add(dto);
        }
        return list;
    }
}
