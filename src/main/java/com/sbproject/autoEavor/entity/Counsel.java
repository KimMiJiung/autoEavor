package com.sbproject.autoEavor.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Counsel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//private Member member;                      // 상담 대상 멤버	  
	private String carType;                     // 상담차종
	private String content;                     // 상담내용
	private LocalDate DatecounselDate;          // 희망상담날짜
	private LocalTime counselDateTime;          // 희망상담시간
	private String additionalRequest;           // 추가전달사항
	private String answerContent;               // 답변내용 
	private AnswerStatus AnswerStatus;          // 상담대기(상담신청단계), 진행중, 진행완료(상담완료 또는 구매완료), 진행중지
}
