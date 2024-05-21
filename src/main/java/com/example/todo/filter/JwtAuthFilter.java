package com.example.todo.filter;

import com.example.todo.auth.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//클라이언트가 전송한 토큰을 검사하는 필터
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

//필터가 해야 할 작업을 기술
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = parseBearerToken(request);
        log.info("tiken: {}",token);
        //토큰 위조 검사 및 인증 완료
        if (token != null) {
            //토큰 서명 위조 검사와 토큰을 파싱해서 클레임을 얻어내는 작업
            tokenProvider.validateAndGetTokenUserInfo(token);
        }


    }

    private String parseBearerToken(HttpServletRequest request) {
        //요청헤더에서 토큰 꺼내기
        //content-type: applicattion/jsin
        //Authoriztion: Bea
        String bearerToken = request.getHeader("Authorization");

        //요청 헤더에서 가져온 토큰은 순수 토큰 값이 아닌
        //잎에 bear가 붙어
        if (StringUtils.hasText(bearerToken) &&
        bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7)
        }
        return null;
    }
}
















