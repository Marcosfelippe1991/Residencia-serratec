programa
{
	
	funcao inicio()
	{
		inteiro angulo1, angulo2, angulo3, soma
		
		escreva("Digite o primeiro Angulo:\n")
		leia(angulo1)
		
		escreva("Digite o segundo Angulo:\n")
		leia(angulo2)
		
		escreva("Digite o terceiro Angulo: \n")
		leia(angulo3)

		soma = angulo1 + angulo2 + angulo3

		se (soma == 180 e angulo1==angulo2 e angulo2==angulo3)
		{
			escreva("É equilatero")
		} senao se (soma == 180 e angulo1==angulo2 e angulo1!=angulo3)
			{
				escreva("é esosceles")
			} senao se (soma == 180 e angulo1!=angulo2 e angulo1!=angulo3 e angulo2!=angulo3)
				{
					escreva("é escalino")
				} senao 
					{
						escreva("não é um triangulo!")
					}
				
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 391; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */