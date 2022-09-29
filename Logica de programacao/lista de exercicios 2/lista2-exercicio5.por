/*O usuário usa a fila preferencial caso 
: 
● Possui mais de 60 anos : Usa fila preferencial 
● É deficiente físico : Usa fila preferencial 
● É mulher gestante : Usa fila preferencial 
O programa recebe como entrada a Idade, Sexo e a condição especial do usuário, se 
houver. 
Exemplo de entrada: 
22homem deficiente 
Saída esperada: 
Fila preferencial 
 */
programa
{
	
	funcao inicio()
	{
		inteiro idade
		cadeia sexo, deficiencia, gestante

		escreva("homem ou mulher? ")
		leia(sexo)
		escreva("sua idade? ")
		leia(idade)
		escreva("se mulher, é gestante? ")
		leia(gestante)
		escreva("possui deficiencia? ")
		leia(deficiencia)

		se (idade > 60 ou gestante == "sim" ou deficiencia== "sim")
			{
				escreva("fila preferencial")
			} senao 
				{
					escreva("fila normal")
				}
					
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 800; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */