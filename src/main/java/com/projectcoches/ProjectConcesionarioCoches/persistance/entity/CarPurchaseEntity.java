package com.projectcoches.ProjectConcesionarioCoches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantityCars;

    @Column(name = "total")
    private Integer totalPriceCars; // total de todos los carros que compraron

    @ManyToOne
    @MapsId(value ="purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)  //No mando compra desde cliente
    private PurchaseEntity purchaseEntity;  // Le envia compra para que tome Id y con Id se guarda en CarPuchasePK

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;


}
