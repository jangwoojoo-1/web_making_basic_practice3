package com.ssg.membertest.member;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
}
