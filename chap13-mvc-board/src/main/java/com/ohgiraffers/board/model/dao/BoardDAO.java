package com.ohgiraffers.board.model.dao;

import com.ohgiraffers.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class BoardDAO {

    private final Properties prop;

    public BoardDAO() {
        prop = new Properties(); // 생성될때 파일로드

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION +
                    "/employee-mapper.xml")); //아까 경로 까지만 넣어서 파일명도 같이 넣어줌
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertbrd(Connection con, BoardDTO bDTO) {
        PreparedStatement pstmt = null;

        ResultSet rset = null;
        int generatedId = -1;
        String query = prop.getProperty("insertbrd");

        try {
            pstmt = con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            //이것도 줘야함/.
            pstmt.setString(1, bDTO.getTitle());
            pstmt.setString(2, bDTO.getContent());

            pstmt.executeUpdate();

            // 생성된 키 가져오기
            rset = pstmt.getGeneratedKeys();
            if (rset.next()) {
                generatedId = rset.getInt(1); // 새로 생성된 BOARD_ID 가져오는거
                System.out.println("New Board ID: " + generatedId);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(rset);
        }
        return generatedId;
    }

    public List<BoardDTO> selectAll(Connection con) {
        PreparedStatement pstmt = null;

        ResultSet rset = null;

        List<BoardDTO> selectEmpList = new ArrayList<>();

        String query = prop.getProperty("selectAll2");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            int generatedId = -1;
            while (rset.next()) {

                BoardDTO bDTO = new BoardDTO();
                bDTO.setTitle(rset.getString("BOARD_TITLE"));
                bDTO.setContent(rset.getString("BOARD_CONTENT"));
                //rset = pstmt.getGeneratedKeys();
               // generatedId = rset.getInt(1);

                selectEmpList.add(bDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return selectEmpList;
    }
}
