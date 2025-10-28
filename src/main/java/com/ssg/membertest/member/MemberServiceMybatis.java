package com.ssg.membertest.member;

import com.ssg.membertest.member.mapper.MemberMapper;
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
