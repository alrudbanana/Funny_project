package com.project.entity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idxItem; //프로젝트 코드
	
	@Column(nullable = false) 
	private String itemName; //프로젝트 명
	
	@Column(nullable = false) 
	private int itemTargetPrice; //목표 금액
	
	@Column(nullable = false) 
	private int itemPrice; //판매 금액
	
	@Column(nullable = false) 
	private String itemDetail; //프로젝트 상세
	
	@Column(nullable = false) 
	private LocalDateTime itemEndDate; //프로젝트 마감 날짜
	
	//상품상태 엔티티
	
	
	
}
