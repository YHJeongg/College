package com.jang.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jang.bbs.mapper.BoardMapper;
import com.jang.bbs.model.BoardVO;
import com.jang.bbs.model.SearchVO;
import com.jang.bbs.utils.PageHelper;

@Service(value = "boardService") // �����̳ʿ� ��ü�� ���� �ִ´�.
public class BoardService {
	
	@Resource(name = "boardMapper") // �����̳ʿ��� ��ü�� �����´�. / @Resource = �������� ��
	private BoardMapper boardMapper; // �ν��Ͻ����� �����ϰ� �׸��� ��´�. 
	
	PageHelper pageHelper = new PageHelper(); // pageHelper�� �׸��� ���� ��´�. / PageHelper�̶�� Ŭ������ ��ü�� ������
	
	public StringBuffer getPageUrl (SearchVO searchVO) {
		
		int totalRow = boardMapper.getTotalRow(searchVO);
		
		return pageHelper.getPageUrl(searchVO.getPage(), totalRow);
	}
	
	public List<BoardVO> getBoardList(SearchVO searchVO) {
		
		int currentPage = searchVO.getPage();
		
		int startRow = (currentPage - 1) * this.pageHelper.getPageSize()+1;
		int endRow = currentPage * this.pageHelper.getPageSize();
		
		searchVO.setStartRow(startRow);
		searchVO.setEndRow(endRow);
		
		return this.boardMapper.getBoardList(searchVO);
	}
	

}
