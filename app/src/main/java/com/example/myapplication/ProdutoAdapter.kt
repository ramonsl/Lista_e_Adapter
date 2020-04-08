package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ProdutoAdapter (private val produtos: List<Produto>): RecyclerView.Adapter<ProdutoAdapter.VH>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    val v= LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
    val vh = VH(v)
    return vh
  }

  override fun getItemCount(): Int {
        return produtos.size
  }

  override fun onBindViewHolder(holder: VH, position: Int) {

    var produto=produtos[position]
    holder.txtProduto.text =produto.nome
    holder.txtQtd.text=produto.qtd.toString()
    holder.txtValor.text=produto.preco.toString()
  }


  ///INNERCLASS
  class VH(itenView: View):RecyclerView.ViewHolder(itenView){
    var txtProduto:TextView = itenView.txtProduto
    var txtValor:TextView = itenView.txtValor
    var txtQtd:TextView = itenView.txtQtd
  }
}
