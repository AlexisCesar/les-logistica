/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author ADM
 */
public class ProdutoNotaFiscal {
    
    private NotaFiscal notaFiscal;
    private Produto produto;
    private Integer quantidade;

    public ProdutoNotaFiscal(NotaFiscal notaFiscal, Produto produto, Integer quantidade) {
        this.notaFiscal = notaFiscal;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Double calcularTotal() {
        return produto.getValor() * quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.notaFiscal);
        hash = 23 * hash + Objects.hashCode(this.produto);
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
        final ProdutoNotaFiscal other = (ProdutoNotaFiscal) obj;
        if (!Objects.equals(this.notaFiscal, other.notaFiscal)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoPedido{" + "notaFiscal=" + notaFiscal + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }
    
}
