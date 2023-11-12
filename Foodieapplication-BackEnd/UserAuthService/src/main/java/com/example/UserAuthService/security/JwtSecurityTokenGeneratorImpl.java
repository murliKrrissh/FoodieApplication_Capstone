package com.example.UserAuthService.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import com.example.UserAuthService.domain.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    @Override
    public Map<String, String> storeToken(User user) {
        Map<String,Object> userData = new HashMap<>();
        userData.put("email",user.getEmail());
        userData.put("role",user.getRole());

        String myToken = Jwts.builder()
                .setClaims(userData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecret")
                .compact();

        Map<String,String> generatedToken = new HashMap<>();
        generatedToken.put("token",myToken);
        generatedToken.put("email", user.getEmail());
        generatedToken.put("role", user.getRole());
        return generatedToken;
    }
}
