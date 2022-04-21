package com.github.bvigentas.jcontractor.services;

import com.github.bvigentas.jcontractor.models.ContractData;
import com.github.bvigentas.jcontractor.utils.ContractDataUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

@Service
public class ReportGeneratorServiceImpl implements ReportGeneratorService {

    public byte[] generate(ContractData contractData) throws FileNotFoundException {
        var reportStream = new FileInputStream(ResourceUtils.getFile("classpath:Contract.jrxml"));

        final var simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        var parameters = new HashMap<String, Object>();
        parameters.put("EVENT_DATE", simpleDateFormat.format(contractData.getEventDate()));
        parameters.put("BEGIN_HOUR", contractData.getBeginHour());
        parameters.put("END_HOUR", contractData.getEndHour());
        parameters.put("CEREMONY_HOUR", contractData.getCeremonyHour());
        parameters.put("CONTRACTOR_NAME", contractData.getContractorName());
        parameters.put("CONTRACTOR_CPF", contractData.getContractorCpf());
        parameters.put("EVENT_ADDRESS", contractData.getEventAddress());
        parameters.put("EVENT_NEIGHBORHOOD", contractData.getEventNeighborhood());
        parameters.put("EVENT_CITY_STATE", contractData.getEventCityState());
        parameters.put("EVENT_LOCATION", contractData.getEventLocation());
        parameters.put("OBS", contractData.getObservation());
        parameters.put("VALOR_TOTAL", ContractDataUtil.calculateTotalValue(contractData));
        parameters.put("SHOW_ITEM_VALUES", contractData.isShowItemValue());


        try {

            final var data1 = new JRBeanCollectionDataSource(contractData.getClauses());
            final var data2 = new JRBeanCollectionDataSource(contractData.getItens());

            parameters.put("datasource_itens", data2);

            var jasperReport = JasperCompileManager.compileReport(reportStream);
            JRSaver.saveObject(jasperReport, "contract.jasper");

            final var jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, data1);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (JRException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

}
