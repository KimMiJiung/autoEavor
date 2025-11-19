package com.sbproject.autoEavor.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "차량 ID는 필수 입력 사항입니다.")
	@Column(unique= true, columnDefinition = "varchar(30)")
	private String carId;
	
	@NotBlank(message = "챠량명은 필수 입력 사항입니다.")
	@Column(columnDefinition = "varchar(100)")
	private String name;
	
	// 최소값 0, 음수는 사용불가, 전체 11자리, 소수점 2자리
	@NotNull @Min(value = 0) @Digits(integer = 11, fraction = 2)
	private Integer price;
	
	@NotBlank(message = "제조회사는 필수 입력 사항입니다.")		
	@Column(columnDefinition = "varchar(100)")	
	private String company;
	
	@NotBlank(message = "해외공장은 필수 입력 사항입니다.")		
	@Column(columnDefinition = "varchar(100)")	
	private String plant;	
	
	@NotBlank(message = "차량구분은 필수 입력 사항입니다.")	
	@Column(columnDefinition = "varchar(100)")
	private String category;
	
	@NotBlank(message = "연료타입은 필수 입력 사항입니다.")
	@Column(columnDefinition = "varchar(30)")
	private String fuelType;

	// 전체
	@Column(columnDefinition="varchar(30) default 'no_image.jpg'")
	private String fileName;  // 차량이미지의 파일명
	
	// 생성할 테이블에서는 필드는 제외함
	@Transient
	private MultipartFile carImage; //업로드된 차량이미지
	
}
