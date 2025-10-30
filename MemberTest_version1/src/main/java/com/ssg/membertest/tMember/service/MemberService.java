package com.ssg.membertest.tMember.service;

import com.ssg.membertest.tMember.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    boolean save(MemberDTO dto);

    List<MemberDTO> printAll();
}
