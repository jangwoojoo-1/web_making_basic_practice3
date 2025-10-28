//package com.ssg.membertest.member;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class MemberServiceImpl implements MemberService {
//
//    private final MemberDAO memberDAO;
//
//    @Override
//    @Transactional
//    public void save(MemberDTO dto){
//        try {
//            boolean result = memberDAO.insertMember(dto);
//            if(result){
//                log.info("입력 성공");
//            } else{
//                log.info("입력 실패");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    @Transactional
//    public void printAll() {
//        try {
//            List<MemberDTO> list = memberDAO.selectAll();
//            list.forEach(memberDTO -> {
//                log.info(memberDTO);
//            });
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
