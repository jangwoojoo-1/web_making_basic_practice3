package com.ssg.membertest.member.mapper;

import com.ssg.membertest.member.MemberDTO;

import java.util.List;


public interface MemberMapper {
    int insertMember(MemberDTO memberDTO);

    List<MemberDTO> selectMembers();
}
