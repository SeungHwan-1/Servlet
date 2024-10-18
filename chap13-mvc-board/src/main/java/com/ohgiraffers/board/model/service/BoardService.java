package com.ohgiraffers.board.model.service;

import com.ohgiraffers.board.model.dao.BoardDAO;
import com.ohgiraffers.board.model.dto.BoardDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;


public class BoardService {

    private final BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }

    public int insertbrd(BoardDTO bDTO) {
        Connection con = getConnection();

        int result = boardDAO.insertbrd(con,bDTO);

        if (result > 0) {
            commit(con); //인서트가 정상적으로 커밋했을때 반영되게끔
        }else{
            rollback(con); //아님 롤백
        }
        close(con);
        return result;
    }


    public List<BoardDTO> selectAllbrd() {
        Connection con = getConnection();

        List<BoardDTO> EmpList = boardDAO.selectAll(con);
        close(con);
        return EmpList;
    }
}
