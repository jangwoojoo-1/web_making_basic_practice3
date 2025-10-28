package com.ssg.membertest.member;

import java.util.List;

public interface MemberDAO {

    boolean insertMember(MemberDTO dto) throws Exception;
    List<MemberDTO> selectAll() throws Exception;
}
