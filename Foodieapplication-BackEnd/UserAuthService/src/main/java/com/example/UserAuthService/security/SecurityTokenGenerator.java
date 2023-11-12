package com.example.UserAuthService.security;
import com.example.UserAuthService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> storeToken(User user);
}
