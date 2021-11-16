/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ADM
 */
public class NotaFiscal {
    
    private Integer id;
    private Romaneio romaneio;
    private Cliente cliente;
    private Instant dataEmissao;
    private Set<ProdutoNotaFiscal> produtos = new HashSet<>();

    public NotaFiscal() {
    }

    public NotaFiscal(Integer id, Romaneio romaneio, Cliente cliente, Instant dataEmissao) {
        this.id = id;
        this.romaneio = romaneio;
        this.cliente = cliente;
        this.dataEmissao = dataEmissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Romaneio getRomaneio() {
        return romaneio;
    }

    public void setRomaneio(Romaneio romaneio) {
        this.romaneio = romaneio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instant getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Instant dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Set<ProdutoNotaFiscal> getProdutos() {
        return produtos;
    }
    
    public void adicionarItem(ProdutoNotaFiscal item) {
        if(produtos.contains(item)) {
            produtos.remove(item);
        }
        produtos.add(item);
    }
    
    public void removerItem(ProdutoNotaFiscal item) {
        produtos.remove(item);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final NotaFiscal other = (NotaFiscal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" + "id=" + id + ", romaneio=" + romaneio + ", cliente=" + cliente + ", dataEmissao=" + dataEmissao + '}';
    }
    
}
