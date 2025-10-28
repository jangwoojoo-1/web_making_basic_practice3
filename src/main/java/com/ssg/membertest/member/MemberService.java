package com.ssg.membertest.member;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface MemberService {

    boolean save(MemberDTO dto);

    List<MemberDTO> printAll();
}
