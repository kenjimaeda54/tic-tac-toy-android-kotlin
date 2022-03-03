# Tic Tack
Aplicativo jogo da velha.

## Motivação 
Criar  aplicativo idêntico ao jogo da velha, para praticar conceito desenvolvimento Android. Campeão precisa preencher as colunas das verticais e horizontais

## Feature
- Usei a classe Window para trocar as cores do status bar
- Manipulei as cores e os comportamentos dos botoes pelo Kotlin de forma dinâmica



``` kotlin
  window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
    
 buttonOne.background = ContextCompat.getDrawable(this, R.color.white)
 buttonOne.text = ""
 buttonOne.isEnabled = true

```
