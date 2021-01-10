package com.rosepurple.hellospring;

import com.rosepurple.hellospring.repository.MemberRepository;
import com.rosepurple.hellospring.repository.MemoryMemberRepository;
import com.rosepurple.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
