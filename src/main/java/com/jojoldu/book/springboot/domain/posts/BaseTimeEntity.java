package com.jojoldu.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  //JPA Entity클래스들이 BaseTimeEntity을 상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 Auditing기능을 포함시킴
public abstract class BaseTimeEntity {
//auditing기능이란? spring data jpa에서 시간에 대해서 자동으로 값을 넣어주는 기능
    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장됨.
    private LocalDateTime modifiedDate;
}
