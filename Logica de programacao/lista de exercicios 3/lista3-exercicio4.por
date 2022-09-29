/*
4 - Escreva um programa que imprima o padrão de uma pirâmide de asteriscos dado 
um número n. 
Exemplo de entrada: 
4 Saída esperada: 
* * * * 
* * * * 
  * * 
*/ programa
{
	
	funcao inicio()
	{
		inteiro n 
		inteiro espacos = 0
		escreva("digite seu numero: ")
		leia(n)
		limpa()
		
		enquanto ( n >= 1)
		{
			se( espacos > 0)
			{ 
				inteiro espacoVazio = (espacos /2)
				
				enquanto(espacoVazio > 0)
				{
					escreva(" ")
					espacoVazio = espacoVazio -1
				}
			} 
			
			para (inteiro quantAst = 1 ; quantAst <= n ; quantAst++)
			{
				escreva ("*")
			}	

			se( espacos > 0)
			{ 
				inteiro espacoVazio = (espacos /2)
				
				enquanto(espacoVazio > 0)
				{
					escreva(" ")
					espacoVazio = espacoVazio -1
				}
			} 	
			escreva("\n")
			n = n - 2
			espacos = espacos +2
		} 	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */