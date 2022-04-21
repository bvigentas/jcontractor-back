package com.github.bvigentas.jcontractor.services;

import com.github.bvigentas.jcontractor.models.ContractData;

import java.io.FileNotFoundException;

public interface ReportGeneratorService {

    byte[] generate(ContractData contractData) throws FileNotFoundException;

}
