package com.fishing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fishing.dto.MemberVO;

import util.DBMangement;

 
public class MemberDao {

 

    private static MemberDao instance;

    public static MemberDao getInstance(){
        if(instance == null)
            instance = new MemberDao();
        return instance;
    }

    private MemberDao(){
       
    }
   
//    모델 패키지에 있는 Member꺼 가져와서 쓰기
//    회원정보셋 데이터 추가하기
    public boolean joinMember(MemberVO member)
    
    {
    	//INSERT INTO fishing.member (USERID, PASSWORD, nickname, NAME,EMAIL) VALUES('test1','1234','hkd','홍길동','hkd@naver.com');
    	//INSERT INTO fishing.member (USERID, PASSWORD, BIRTHDAY,ADDRESS,NAME,EMAIL,PHONE, NICKNAME) VALUES('test1','1234',780124,'서울시','홍길동','hkd@naver.com','010-1234-5678','hkd');
    	String query ="INSERT INTO fishing.member (USERID, PASSWORD, BIRTHDAY,ADDRESS,NAME,EMAIL,PHONE, NICKNAME) VALUES(?,?,?,?,?,?,?,?)";
    	int result = 0;
    	Connection con = null;
		PreparedStatement pstmt = null;
    	try {
			con = DBMangement.getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getBirthday());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getName());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getNickName());
			

			pstmt.executeUpdate();
			if(result!=0){
				return true;
			}
		} catch (Exception e) {
			System.out.println("joinMember 에러" + e);
		} finally {
			DBMangement.close(pstmt, con);
		}
		return false;
    	
    	
    }
    
    public boolean login(MemberVO mvo){
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        String query ="select PASSWORD from member where USERID = ? and PASSWORD = ?";
        try {
           con = DBMangement.getConnection();
           pstmt = con.prepareStatement(query);
           pstmt.setString(1, mvo.getId());
           pstmt.setString(2, mvo.getPw());
           rs = pstmt.executeQuery();
           while(rs.next()){
                 result = true;
           }
           
        } catch (SQLException e) {
           System.out.println("에러" + e.getMessage());
        } finally {
           DBMangement.close(rs, pstmt, con);
        }
        System.out.println(result);
        return result;
        
         
         
      }


        
    
}