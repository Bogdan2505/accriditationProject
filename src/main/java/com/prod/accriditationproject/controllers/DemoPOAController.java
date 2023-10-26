package com.prod.accriditationproject.controllers;

import com.prod.accriditationproject.dto.DemoPOADto;
import com.prod.accriditationproject.dto.SignInRequest;
import com.prod.accriditationproject.dto.SignInResponse;
import com.prod.accriditationproject.exception.SignInException;
import com.prod.accriditationproject.services.DemoPOADtoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demoPOA")
@RequiredArgsConstructor
public class DemoPOAController {

    private DemoPOADtoService demoPOADtoService;

    @Autowired
    public void setDemoPOADtoService(DemoPOADtoService demoPOADtoService) {
        this.demoPOADtoService = demoPOADtoService;
    }

    @PostMapping("/countResult")
    public int signIn(@RequestBody DemoPOADto demoPOA) {
        System.out.println(demoPOA.getStr1());
         return demoPOADtoService.countResult(demoPOA);
    }

    @GetMapping("/get")
    public String get() {
        return "hi";
    }
}
