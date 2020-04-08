package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  var lista = arrayListOf<Produto>()
  var adapter= ProdutoAdapter(lista)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    Log.e("Ciclo de vida", "onCreate(): É a primeira função a ser executada em uma Activity. Geralmente é a responsável por carregar os layouts XML e outras operações de inicialização. É executada apenas uma vez.")
    btnAdd.setOnClickListener(View.OnClickListener {
    add()
    })

  }

  fun add(){
    if(edtProduto.text.toString().length>3){
      val produto= Produto(edtProduto.text.toString(),edtPreco.text.toString().toDouble(),edtQtd.text.toString().toInt())
      lista.add(produto)
      edtProduto.text.clear()
      edtPreco.text.clear()
      edtQtd.text.clear()
      initRecyclerView()
    }else{
      Toast.makeText(applicationContext,"Texto Curto",Toast.LENGTH_SHORT).show()
    }

  }
  private fun initRecyclerView(){
    rvDados.adapter = adapter
    val layoutManager= LinearLayoutManager(this)
    rvDados.layoutManager=layoutManager
  }
  override fun onStart() {
    super.onStart()
    Log.e("Ciclo de vida", "onStart(): É chamada imediatamente após a onCreate() – e também quando uma Activity que estava em background volta a ter foco.")
  }
  override fun onResume() {
    super.onResume()
    Log.e("Ciclo de vida","onResume(): Assim como a onStart(), é chamada na inicialização da Activity e também quando uma Activity volta a ter foco. Qual a diferença entre as duas? A onStart() só é chamada quando a Activity não estava mais visível e volta a ter o foco, a onResume() é chamada nas “retomadas de foco”.")
  }

  override fun onPause() {
    super.onPause()
    Log.e("Ciclo de vida","onPause(): É a primeira função a ser invocada quando a Activity perde o foco (isso ocorre quando uma nova Activity é iniciada).")
  }

  override fun onStop() {
    super.onStop()
    Log.e("Ciclo de vida","onStop(): Só é chamada quando a Activity fica completamente encoberta por outra Activity.")
  }

  override fun onRestart() {
    super.onRestart()
    Log.e("Ciclo de vida","onDestroy(): A última função a ser executada. Depois dela, a Activity é considerada “morta” – ou seja, não pode mais ser relançada. Se o usuário voltar a requisitar essa Activity, um novo objeto será construído.")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.e("Ciclo de vida","onDestroy(): A última função a ser executada. Depois dela, a Activity é considerada “morta” – ou seja, não pode mais ser relançada. Se o usuário voltar a requisitar essa Activity, um novo objeto será construído.")
  }


}
