package com.example.CustomerService.proxy;
import com.example.CustomerService.domain.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="AUTHENTICATION-SERVICE",url ="http://localhost:8081")
public interface CustomerProxy  {
    @PostMapping("/api/v1/auth/register")
    public ResponseEntity<?> saveUser(@RequestBody CustomerDto customerDto);
}
