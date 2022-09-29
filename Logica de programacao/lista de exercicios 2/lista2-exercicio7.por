/* 
7 - Modifique o programa anterior para imprimir todos os números ímpares de 1 até n. 
Exemplo de entrada: 
6Saída esperada: 1 
3 5
 */programa
{
	funcao inicio()
	{
		inteiro i = 1
		inteiro fimDoEnquanto  

		escreva ("digite seu numero: ")
		leia(fimDoEnquanto)
				
		enquanto (i < fimDoEnquanto )
		{ 
			inteiro restoDaDivisao = 1			
			inteiro verificarImpar = i % 2
			
			se ( verificarImpar == restoDaDivisao)
			{
				escreva( i + ", ")
			}
			i++
		}   
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 4; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */