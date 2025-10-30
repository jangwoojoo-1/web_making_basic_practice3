package com.ssg.membertest.tMember.service;

import com.ssg.membertest.tMember.dto.MemberDTO;
import com.ssg.membertest.tMember.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class MemberServiceMybatis implements MemberService {
    private final MemberMapper memberMapper;

    @Override
    public boolean save(MemberDTO dto) {
        return memberMapper.insertMember(dto) > 0;
    }

    @Override
    public List<MemberDTO> printAll() {
        return memberMapper.selectMembers();
    }
}
