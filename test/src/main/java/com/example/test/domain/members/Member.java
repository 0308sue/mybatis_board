package com.example.test.domain.members;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.test.dto.MemberDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Getter
@Table(name = "member")
@Entity
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String name;
    
    @Column(unique = true) 
    private String email;

    private String password;
    
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String name, String email, String password, String address, MemberRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public static Member creatMember(MemberDTO memberDTO,PasswordEncoder passwordEncoder){
        Member member = Member.builder()
            .name(memberDTO.getName())
            .email(memberDTO.getEmail())
            .address(memberDTO.getAddress())
            .password(passwordEncoder.encode(memberDTO.getPassword()))
            .role(MemberRole.USER)
            .build();
        return member;
    }
    
}
