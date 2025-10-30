package com.ssg.membertest.tMember.dao;

import com.ssg.membertest.tMember.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {

    boolean insertMember(MemberDTO dto) throws Exception;
    List<MemberDTO> selectAll() throws Exception;
}
