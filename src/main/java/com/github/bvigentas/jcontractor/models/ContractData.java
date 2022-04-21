package com.github.bvigentas.jcontractor.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ContractData {

    @NotNull(message = "Data do evento deve ser informada.")
    private Date eventDate;

    @NotEmpty(message = "Hora de início deve ser informada.")
    private String beginHour;

    @NotEmpty(message = "Hora de término deve ser informada.")
    private String endHour;

    @NotEmpty(message = "Hora da cerimônia deve ser informada.")
    private String ceremonyHour;

    @NotEmpty(message = "Nome do(a) contratante deve ser informado.")
    private String contractorName;

    @NotEmpty(message = "CPF do(a) contratante deve ser informado.")
    private String contractorCpf;

    @NotEmpty(message = "Endereço do evento deve ser informado.")
    private String eventAddress;

    @NotEmpty(message = "Bairro do evento deve ser informado.")
    private String eventNeighborhood;

    @NotEmpty(message = "Cidade do evento deve ser informada.")
    private String eventCityState;

    @NotEmpty(message = "Lugar do evento deve ser informado.")
    private String eventLocation;

    @NotNull(message = "Informe os itens do evento.")
    private List<Itens> itens;

    @NotEmpty(message = "Informe o valor total.")
    private String totalValue;

    private List<Clausule> clauses;

    @NotNull(message = "Informe se deseja usar as clausulas padrão.")
    private boolean useDefaultClauses;

    private String observation;

    private boolean showItemValue;

}
