package com.ssg.membertest.tMember.dao;

import com.ssg.membertest.tMember.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class MemberDaoJdbc implements MemberDAO{
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<MemberDTO> MEMBER_ROW_MAPPER = new RowMapper<MemberDTO>() {
        @Override
        public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MemberDTO member = new MemberDTO();
            member.setMid(rs.getString("mid"));
            member.setMpw(rs.getString("mpw"));
            member.setMname(rs.getString("mname"));
            return member;
        }
    };


    @Override
    public boolean insertMember(MemberDTO dto) throws Exception {
        String sql = "insert into t_member(mid, mpw, mname) values(?,?,?)";
        return jdbcTemplate.update(sql,
                dto.getMid(),
                dto.getMpw(),
                dto.getMname()) > 0;
    }

    @Override
    public List<MemberDTO> selectAll() throws Exception {
        String sql = "select * from t_member";
        return jdbcTemplate.query(sql, MEMBER_ROW_MAPPER);
    }
}
