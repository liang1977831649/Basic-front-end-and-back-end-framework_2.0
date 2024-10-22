package com.studentGrade;

import com.studentGrade.utils.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JWTTest {
    @Test
    public void jwt(){
        String str="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiaWQiOjEyMzQ1Nn0sImV4cCI6MTcyODg1MTQ4NH0.pt44IudYBMmgdDpN5yKfxZuapqPKfJDIynOrIrKKpGc";
        Map<String, Object> stringObjectMap = JwtUtil.parseToken(str);
        System.out.println(stringObjectMap);
    }
}
