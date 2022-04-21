package com.github.bvigentas.jcontractor.controllers;

import com.github.bvigentas.jcontractor.models.ContractData;
import com.github.bvigentas.jcontractor.services.ReportGeneratorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/generate")
@Validated
public class ReportGeneratorController {

    private final ReportGeneratorService service;

    public ReportGeneratorController(ReportGeneratorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<byte []> generate(@Valid @RequestBody ContractData contractData) throws FileNotFoundException {

        final byte[] contract = service.generate(contractData);

        final var headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=contrato_"+ contractData.getContractorName() +".pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(contract);

    }

}
