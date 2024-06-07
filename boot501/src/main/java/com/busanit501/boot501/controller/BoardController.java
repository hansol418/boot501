package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.BoardDTO;
import com.busanit501.boot501.dto.PageRequestDTO;
import com.busanit501.boot501.dto.PageResponseDTO;
import com.busanit501.boot501.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 화면, 데이터 같이 전달.
@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // ex) /board/list
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<BoardDTO> responseDTO
                = boardService.list(pageRequestDTO);
        // 서버로부터 응답확인.
        log.info("BoardController 확인 중, responseDTO : " + responseDTO);
        // 서버 -> 화면 데이터 전달.
        model.addAttribute("responseDTO",responseDTO);

    } //list 닫는 부분

} // BoardController 닫는 부분
