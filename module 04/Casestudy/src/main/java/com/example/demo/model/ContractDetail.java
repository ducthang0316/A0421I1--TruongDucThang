package com.example.demo.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Contract.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AttachService attachService;

    private int quantity;

    public ContractDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
