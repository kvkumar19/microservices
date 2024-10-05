package com.card.card.configuer;

import com.card.card.dto.ResponseAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// Define the Feign Client to call external service
@FeignClient(url = "http://localhost:8081", value = "accounts") // Replace with actual service URL and name
public interface AccountFeignClient {

    @GetMapping("/account") // Map this to the actual endpoint of the external service
    List<ResponseAccountDto> getAccountData(); // No implementation, Feign handles this
}
