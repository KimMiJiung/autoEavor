package com.sbproject.autoEavor.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/*
 * 회원/딜러/관리자의 멤버 변수
 */
@Entity
@Data
public class Member {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, columnDefinition="varchar(30)")
    @NotBlank(message = "회원ID는 필수 입력사항입니다.")
    private String memberId;

	@Column(columnDefinition="varchar(100)")
	@NotBlank(message = "비밀번호는 필수 입력사항입니다.")
	//@Pattern(regexp = "(?=.*[0-9])(?=.*[A-Za-z])(?=.*\\W)(?=\\S+$).{8,16}", message ="비밀형식에 맞게 입력해주세요. ex) 숫자, 영문자, 특수문자를 포함하여 8~16글자 사이") // 실전용
    private String password;

	// 테이블에서 생성 제외
	// - Mall01Application의 메서드를 실행 할 때는 password2를 주석처리해야 함.
	@Transient
	//@NotBlank(message = "비밀번호 확인은 필수 입력사항입니다.")
    private String password2;
	@Column(columnDefinition="varchar(30)")
	@NotBlank(message = "회원명은 필수 입력사항입니다.")		
    private String name;
	
	@Column(columnDefinition="char(13)")
	@NotBlank(message = "전화번호는 필수 입력사항입니다.")
	@Pattern(regexp = "01(?:0|1|[6~9])[.-]?(\\d{3}|\\d{4})[.-](\\d{4})$", message = "전화번호 형식에 맞게 입력해주세요. ex) 010-1111-1111")	
    private String phone;
	
	@Column(columnDefinition="varchar(50)")
	@NotBlank(message = "이메일은 필수 입력사항입니다.")	
	@Pattern(regexp = "^[A-Za-z0-9._%+-]{2,20}+@[A-Za-z0-9]{2,30}+.[A-Za-z]{2,6}$", message = "이메일의 형식에 맞게 입력해주세요. ex) aa@bb.com, aa:2글자 이상, bb:2글자 이상, com:2~6글자 사이")		
    private String email;
	
	@Column(columnDefinition ="char(2)")	
    private String gender;
	
	@NotNull(message = "나이는 1살이상 입력해야 합니다.")
	@Min(value=1)	
    private Integer age;

	@NotBlank(message = "생년월일은 필수 입력사항입니다.")
	@Column(columnDefinition = "char(10)")
    private String birthday;
	
	@Column(columnDefinition = "datetime default now()")
    private LocalDateTime regDate;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Valid // Address의 각 멤버에 대한 유효성 검사
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MemberDetail memberDetail;
    

}
