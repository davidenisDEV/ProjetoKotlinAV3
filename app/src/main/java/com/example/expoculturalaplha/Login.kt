package com.example.expoculturalaplha

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import android.os.Handler

class Login : AppCompatActivity() {
    private lateinit var textTelaCadastro: TextView
    private lateinit var edit_email: EditText
    private lateinit var edit_senha: EditText
    private lateinit var botao_entrar: Button
    private lateinit var loading: ProgressBar
    private val msg = arrayOf("Preencha os campos", "Acesso realizado com sucesso")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startComponentes()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textTelaCadastro.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        botao_entrar.setOnClickListener { v ->
            val email = edit_email.text.toString()
            val senha = edit_senha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(v, msg[0], Snackbar.LENGTH_SHORT)
                snackbar.view.setBackgroundColor(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            } else {
                autenticar()
            }
        }
    }

    private fun autenticar() {
        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        try {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    loading.visibility = ProgressBar.VISIBLE

                    Handler().postDelayed({
                        abrirHomeFragment()
                    }, 4000)

                } else {
                    val exceptionMessage = task.exception?.message ?: "Erro desconhecido"
                    val snackbar = Snackbar.make(findViewById(R.id.main), "Erro ao fazer login: $exceptionMessage", Snackbar.LENGTH_SHORT)
                    snackbar.view.setBackgroundColor(Color.RED)
                    snackbar.setTextColor(Color.WHITE)
                    snackbar.show()
                }
            }
        } catch (e: Exception) {
            // Tratamento de exceções para capturar erros não esperados
            val snackbar = Snackbar.make(findViewById(R.id.main), "Erro: ${e.message}", Snackbar.LENGTH_SHORT)
            snackbar.view.setBackgroundColor(Color.RED)
            snackbar.setTextColor(Color.WHITE)
            snackbar.show()
        }
    }

    private fun abrirHomeFragment() {
        try {
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            navController.navigate(R.id.nav_home) // Navegar para o HomeFragment
        } catch (e: Exception) {
            val snackbar = Snackbar.make(findViewById(R.id.main), "Erro na navegação: ${e.message}", Snackbar.LENGTH_SHORT)
            snackbar.view.setBackgroundColor(Color.RED)
            snackbar.setTextColor(Color.WHITE)
            snackbar.show()
        }
    }

    private fun startComponentes() {
        textTelaCadastro = findViewById(R.id.text_cadastro)
        edit_email = findViewById(R.id.edit_email)
        edit_senha = findViewById(R.id.edit_senha)
        botao_entrar = findViewById(R.id.botao_entrar)
        loading = findViewById(R.id.loading)
    }
}
