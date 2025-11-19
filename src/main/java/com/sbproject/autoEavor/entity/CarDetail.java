package com.sbproject.autoEavor.entity;

import java.math.BigDecimal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CarDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;
	
	// 엔진
	@NotNull
	@Column(columnDefinition = "varchar(50)")
	private String model;
	
	// 자동변속기
	@Column(columnDefinition="varchar(30) default '2025'")
	private String trimYear;

	// 전기 구동 방식
	@Column(columnDefinition = "varchar(100)")
	private String engine;
	
	// 변속기 종류
	@Column(columnDefinition = "varchar(50)")
	private String transmission;
	
	// 최대 출력
	@Column(columnDefinition = "varchar(30)")
	private String maxPower;
	
	// 최대 회전력
	@Column(columnDefinition = "varchar(30)")
	private String maxTorque;
	
	// 엔진 배기량
	@Column(columnDefinition = "varchar(30)")
	private String displacement;
	
	// 구동 방식
	@Column(columnDefinition = "varchar(30)")
	private DriveType driveType;
	
	// 연료탱크 용량
	@Column(precision = 5, scale = 1)
	private BigDecimal fuelTank;
	
	// 배터리 유형
	@Column(columnDefinition = "varchar(50)")
	private String batteryType;
	
	//배터리의 저장 용량
	@Column(precision = 6, scale = 2)
	private BigDecimal batteryCapacity; 
	
	// km 1회 충전으로 차량이 이동 가능한 거리
	@Min(value=1)
	private Integer evRange;  
	
	// 급속 충전 시간
	@Column(columnDefinition = "varchar(30)")
	private String fastCharge;
	
	// 완속 충전을 통해 배터리를 충전하는 데 걸리는 시간
	@Column(columnDefinition = "varchar(30)")
	private String slowCharge;   
	
	// 차량 공차중량
	@Min(value=1)
	private Integer curb_weight;  
	
	// 차량 관련 추가 정보나 특이 사항정보란
	@Column(columnDefinition = "varchar(200)")
	private String note;  
	
}
