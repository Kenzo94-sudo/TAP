package Playground.controller.model.dto.Dashboard;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DashboardResponse {


    private Integer clientes;

    private Integer ninos;

    private Integer reservas;

    private Double caja;


}