package com.example.kurmap.Board.model.vos;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity(name = "board")
@Getter
@Setter
public class BoardVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "content", nullable = false, length = 150)
    private String content;

}
