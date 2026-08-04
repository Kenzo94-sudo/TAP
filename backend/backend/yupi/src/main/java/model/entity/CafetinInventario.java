package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import model.entity.Enum.CategoriaProducto;

import java.math.BigDecimal;

@Entity
@Table(name = "cafetin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CafetinInventario {

    private Integer id_producto;
    private Integer nombreProducto;
    private int cantidadProducto;
    private String tipoProducto;
    private BigDecimal precio;
    private CategoriaProducto categoria;
}
