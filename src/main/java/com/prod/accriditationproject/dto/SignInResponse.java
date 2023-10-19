package com.prod.accriditationproject.dto;

public record SignInResponse(String accessJwtToken, String refreshJwtToken) {
}
