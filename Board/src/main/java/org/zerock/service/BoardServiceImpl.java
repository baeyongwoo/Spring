package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;  // 주입
	
	@Override
	public List<BoardVO> getList() {		
		return mapper.getList(); // mapper의 getList()호출
	}

	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);		
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

}
