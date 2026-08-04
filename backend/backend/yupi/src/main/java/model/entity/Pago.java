package model.entity;

import jakarta.persistence.*;
import lombok.*;
import model.entity.Enum.EstadoPago;
import model.entity.Enum.MedioPago;
import model.entity.Enum.TipoPago;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pago {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_pago;
        private Double monto;
        private LocalDateTime fechaPago;
        @Enumerated(EnumType.STRING)
        private MedioPago medioPago;
        @Enumerated(EnumType.STRING)
        private EstadoPago estadoPago;
        @Enumerated(EnumType.STRING)
        private TipoPago tipoPago;

    }
