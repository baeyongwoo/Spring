package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	//목록
	public List<BoardVO> getList();
	//등록
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);

}
