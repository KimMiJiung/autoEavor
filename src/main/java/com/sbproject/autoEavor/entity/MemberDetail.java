package com.sbproject.autoEavor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

/*
 * 추천AI 멤버 추가데이터
 */
@Entity
@Data
public class MemberDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1:1 관계
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String budgetRange;                // 구매예산
    private String primaryUsage;               // 주 이용 목적
    private Integer familySize;                // 가족 구성원 수
    private Integer commuteDistance;           // 하루 평균 운행 거리
    private String preferredVehicleType;       // 선호 차종
    private String preferredEngineType;        // 선호 연료
    private String importanceFactors;          // 중시 기준 리스트 (JSON 가능)
    private String avoidFactors;               // 피하고 싶은 요소
}
