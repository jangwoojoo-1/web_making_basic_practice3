package com.ssg.membertest.tMember.mapper;

import com.ssg.membertest.tMember.dto.MemberDTO;

import java.util.List;


public interface MemberMapper {
    int insertMember(MemberDTO memberDTO);

    List<MemberDTO> selectMembers();
}
