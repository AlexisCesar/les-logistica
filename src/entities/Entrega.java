/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.EstadoEntrega;
import entities.utils.Geolocalizacao;
import java.util.Objects;

/**
 *
 * @author ADM
 */
public class Entrega {
    
    private NotaFiscal notaFiscal;
    private Geolocalizacao localizacaoDestino;
    private EstadoEntrega estadoEntrega;
    private String observacao;

    public Entrega() {
        
    }
    
    public Entrega(NotaFiscal notaFiscal, Geolocalizacao localizacaoDestino, EstadoEntrega estadoEntrega, String observacao) {
        this.notaFiscal = notaFiscal;
        this.localizacaoDestino = localizacaoDestino;
        this.estadoEntrega = estadoEntrega;
        this.observacao = observacao;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Geolocalizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Geolocalizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    public EstadoEntrega getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(EstadoEntrega estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.notaFiscal);
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
        final Entrega other = (Entrega) obj;
        if (!Objects.equals(this.notaFiscal, other.notaFiscal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrega{" + "notaFiscal=" + notaFiscal + ", localizacaoDestino=" + localizacaoDestino + ", estadoEntrega=" + estadoEntrega + '}';
    }
    
}
