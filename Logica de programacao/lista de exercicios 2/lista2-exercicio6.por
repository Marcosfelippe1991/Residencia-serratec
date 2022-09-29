
/* 6 - Escreva um programa que imprima todos os número de 1 até n. 
Exemplo de entrada: 
6Saída esperada: 1 
2 3 4 5 6 
 */
programa
{
	funcao inicio()
	{
		inteiro indice = 1
		inteiro controle
		escreva ("digite o numero: ")
		leia (controle)
				
		enquanto (indice <= controle )
		{	
			escreva( indice + ", ")
			indice++
		}   
	}
}
			
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 343; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */