package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//목록
	public List<BoardVO> getList();
	//등록
	public void insert(BoardVO board);
	//등록 with select key
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
}
