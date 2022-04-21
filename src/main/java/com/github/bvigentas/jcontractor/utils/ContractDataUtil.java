package com.github.bvigentas.jcontractor.utils;

import com.github.bvigentas.jcontractor.models.ContractData;

public class ContractDataUtil {

    public static String calculateTotalValue(ContractData contractData) {
        if (contractData.getTotalValue().isEmpty()) {
            return String.valueOf(contractData.getItens().stream().mapToDouble(i -> Double.parseDouble(i.getItemValue())).sum());
        } else {
            return contractData.getTotalValue();
        }
    }

}
