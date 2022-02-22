package com.tictactoy


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var whoIsPlayer = 1
    private val viewSelectedPlayOne = ArrayList<Int>()
    private val viewSelectedPlayTwo = ArrayList<Int>()
    private val machinePlay = ArrayList<Int>()
    private var winner = 0
    private var quantityPlayerOneWin = 0
    private var quantityPlayerTwoWin = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
        buttonFour.setOnClickListener(this)
        buttonFive.setOnClickListener(this)
        buttonSix.setOnClickListener(this)
        buttonSeven.setOnClickListener(this)
        buttonEight.setOnClickListener(this)
        buttonNine.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        //estou faznedo cast para button para possuir acesso as props desse componente
        val buttonSelected: Button = view as Button
        //idia aqui e formatar as colunas e linhas da tela por numeros que compreendemos
        //por padrao cada view tem id gigante e ficaria dificil validar
        val numberClicked = when (buttonSelected.id) {
            R.id.buttonOne -> 1
            R.id.buttonTwo -> 2
            R.id.buttonThree -> 3
            R.id.buttonFour -> 4
            R.id.buttonFive -> 5
            R.id.buttonSix -> 6
            R.id.buttonSeven -> 7
            R.id.buttonEight -> 8
            else -> 9
        }
        playGame(buttonSelected, numberClicked)
    }


    private fun playGame(buttonSelected: Button, numberClicked: Int) {
        //em koltin toda vez que entra no if ele refaz o ciclo
        if (whoIsPlayer == 1) {
            buttonSelected.background = ContextCompat.getDrawable(this, R.color.greenDark)
            viewSelectedPlayOne.add(numberClicked)
            buttonSelected.text = "x"
            whoIsPlayer = 2
            autoplay()
        } else {
            buttonSelected.background = ContextCompat.getDrawable(this, R.color.blueDark)
            viewSelectedPlayTwo.add(numberClicked)
            buttonSelected.text = "0"
            whoIsPlayer = 1
        }
        //permitir que nao selecione campos ja selecionados
        buttonSelected.isEnabled = false
        if (whoIsWin() == 0) {
            resetGame()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun whoIsWin(): Int {
        // isso foi facilitado porque formatei no onCLick
        if (viewSelectedPlayOne.contains(1) && viewSelectedPlayOne.contains(2) && viewSelectedPlayOne.contains(
                3
            )
        ) {
            winner = 1
        }
        if (viewSelectedPlayTwo.contains(1) && viewSelectedPlayTwo.contains(2) && viewSelectedPlayTwo.contains(
                3
            )
        ) {
            winner = 2
        }
        if (viewSelectedPlayOne.contains(4) && viewSelectedPlayOne.contains(5) && viewSelectedPlayOne.contains(
                6
            )
        ) {
            winner = 1
        }
        if (viewSelectedPlayTwo.contains(4) && viewSelectedPlayTwo.contains(5) && viewSelectedPlayTwo.contains(
                6
            )
        ) {
            winner = 2
        }
        if (viewSelectedPlayOne.contains(7) && viewSelectedPlayOne.contains(8) && viewSelectedPlayOne.contains(
                9
            )
        ) {
            winner = 1
        }
        if (viewSelectedPlayTwo.contains(7) && viewSelectedPlayTwo.contains(8) && viewSelectedPlayTwo.contains(
                9
            )
        ) {
            winner = 2
        }

        if (viewSelectedPlayOne.contains(1) && viewSelectedPlayOne.contains(4) && viewSelectedPlayOne.contains(
                7
            )
        ) {
            winner = 1
        }
        if (viewSelectedPlayTwo.contains(1) && viewSelectedPlayTwo.contains(4) && viewSelectedPlayTwo.contains(
                7
            )
        ) {
            winner = 2
        }
        if (viewSelectedPlayOne.contains(2) && viewSelectedPlayOne.contains(5) && viewSelectedPlayOne.contains(
                8
            )
        ) {
            winner = 1
        }
        if (viewSelectedPlayTwo.contains(2) && viewSelectedPlayTwo.contains(5) && viewSelectedPlayTwo.contains(
                8
            )
        ) {
            winner = 2
        }
        if (viewSelectedPlayOne.contains(3) && viewSelectedPlayOne.contains(6) && viewSelectedPlayOne.contains(
                9
            )
        ) {
            winner = 1
        }
        if (viewSelectedPlayTwo.contains(3) && viewSelectedPlayTwo.contains(6) && viewSelectedPlayTwo.contains(
                9
            )
        ) {
            winner = 2
        }
        if (winner == 1) {
            quantityPlayerOneWin += 1
            Toast.makeText(this, "Winner is player 1", Toast.LENGTH_LONG).show()
            text_playerOne.text = "Player one $quantityPlayerOneWin"
            return 0
        }
        if (winner == 2) {
            quantityPlayerTwoWin += 1
            Toast.makeText(this, "Winner is player 2", Toast.LENGTH_LONG).show()
            text_playerTwo.text = "Player two $quantityPlayerTwoWin"
            return 0
        }
        return 1
    }

    private fun autoplay() {
        for (i in 1..9) {
            if (!(viewSelectedPlayOne.contains(i) || viewSelectedPlayTwo.contains(i))) {
                machinePlay.add(i)
            }
        }

        var numberRandom = Random()
        var numberSelected = numberRandom.nextInt(machinePlay.size)
        var idViewSelected = machinePlay[numberSelected]
        if(viewSelectedPlayOne.contains(idViewSelected)){
             numberRandom = Random()
             numberSelected = numberRandom.nextInt(machinePlay.size)
             idViewSelected = machinePlay[numberSelected]
        }
        val buttonSelected = when (idViewSelected) {
            1 -> buttonOne
            2 -> buttonTwo
            3 -> buttonThree
            4 -> buttonFour
            5 -> buttonFive
            6 -> buttonSix
            7 -> buttonSeven
            8 -> buttonEight
            else -> buttonNine
        }
        playGame(buttonSelected, idViewSelected)

    }

    private fun resetGame() {
        whoIsPlayer = 1
        winner = 0
        viewSelectedPlayOne.clear()
        viewSelectedPlayTwo.clear()
        machinePlay.clear()
        buttonOne.background = ContextCompat.getDrawable(this, R.color.white)
        buttonOne.text = ""
        buttonOne.isEnabled = true
        buttonTwo.background = ContextCompat.getDrawable(this, R.color.white)
        buttonTwo.text = ""
        buttonTwo.isEnabled = true
        buttonThree.background = ContextCompat.getDrawable(this, R.color.white)
        buttonThree.text = ""
        buttonThree.isEnabled = true
        buttonFour.background = ContextCompat.getDrawable(this, R.color.white)
        buttonFour.text = ""
        buttonFour.isEnabled = true
        buttonFive.background = ContextCompat.getDrawable(this, R.color.white)
        buttonFive.text = ""
        buttonFive.isEnabled = true
        buttonSix.background = ContextCompat.getDrawable(this, R.color.white)
        buttonSix.text = ""
        buttonSix.isEnabled = true
        buttonSeven.background = ContextCompat.getDrawable(this, R.color.white)
        buttonSeven.text = ""
        buttonSeven.isEnabled = true
        buttonEight.background = ContextCompat.getDrawable(this, R.color.white)
        buttonEight.text = ""
        buttonEight.isEnabled = true
        buttonNine.background = ContextCompat.getDrawable(this, R.color.white)
        buttonNine.text = ""
        buttonNine.isEnabled = true

    }
}