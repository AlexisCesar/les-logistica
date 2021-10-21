/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ADM
 */
public class Romaneio {
    
    private Integer id;
    private Veiculo veiculo;
    private Motorista motorista;
    private List<Entrega> entregas = new ArrayList<>();

    public Romaneio() {
    }

    public Romaneio(Integer id, Veiculo veiculo, Motorista motorista) {
        this.id = id;
        this.veiculo = veiculo;
        this.motorista = motorista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void adicionarEntrega(Entrega entrega) {
        this.entregas.add(entrega);
    }
    
    public void removerEntrega(Entrega entrega) {
        this.entregas.remove(entrega);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Romaneio other = (Romaneio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Romaneio{" + "id=" + id + ", veiculo=" + veiculo + ", motorista=" + motorista + ", entregas=" + entregas + '}';
    }
    
}
