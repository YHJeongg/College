package com.jang.car.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jang.car.model.AttFileVO;
import com.jang.car.model.BoardLikeVO;
import com.jang.car.model.BoardVO;
import com.jang.car.model.BoardViewVO;
import com.jang.car.model.ReplyLikeVO;
import com.jang.car.model.ReplyVO;
import com.jang.car.model.SearchVO;

@Repository(value = "boardMapper") //@Mapper
public interface BoardMapper {
	
	List<BoardVO> getBoardList(SearchVO searchVO); //�� ��??? ��ȸ
	
	BoardVO getArticle(int bno); //�� ��ȸ
	int writeArticle(BoardVO board); //�� �ۼ�
	int updateArticle(BoardVO board); //�� ����
	int deleteArticle(int bno); //�� ����
	
	int getTotalRow(SearchVO searchVO); //��ü �ۼ� ��ȸ
	
	int incrementViewCnt(int bno); //��ȸ�� ����
	int incrementGoodCnt(int bno); //���ƿ� ����
	int incrementReplyCnt(int bno); //��ۼ??? ����
	
	List<ReplyVO> getReplyList(int bno); //��??? ��??? ��ȸ
	ReplyVO getReply(int rno); //��??? ��ȸ
	
	int writeReply(ReplyVO reply); //��??? ����
	int updateReply(ReplyVO reply); //��??? ����
	void deleteReply(int rno); //��??? ����
	void deleteReplyBybno(int bno); //���ۿ� �Ҽӵ� ��??? ��ü ����
	
	int incReplyGoodCnt(int rno); //��??? ���ƿ� ����
	
	List<AttFileVO> getFileList(int bno); //÷������ ��??? �б�
	String getFileName(int fno); //���� �̸� ��ȸ
	int insertFile(AttFileVO file); //���� ����
	
	void deleteFile(int fno); //÷�� ���� ����
	void deleteFileBybno(int bno); //���� �Ҽӵ� ÷������ ��ü ����
	
	int addBoardLike(BoardLikeVO boardLike); //������ ��õ ��??? ����
	int getBoardLike(BoardLikeVO boardLike); //������ ��õ ��??? Ȯ��
	
	int addReplyLike(ReplyLikeVO replyLike); //��??? ��õ��??? ����
	int getReplyLike(ReplyLikeVO replyLike); //��??? ��õ��??? Ȯ��
	
	int addBoardView(BoardViewVO boardView);
	int getBoardView(BoardViewVO boardView);
}