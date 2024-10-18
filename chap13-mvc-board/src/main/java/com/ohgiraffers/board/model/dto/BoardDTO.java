package com.ohgiraffers.board.model.dto;

public class BoardDTO {

    private String title;
    private String content;
    private int Id;

    public BoardDTO(String title, String content, int id) {
        this.title = title;
        this.content = content;
        Id = id;
    }

    public BoardDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", Id=" + Id +
                '}';
    }
}
