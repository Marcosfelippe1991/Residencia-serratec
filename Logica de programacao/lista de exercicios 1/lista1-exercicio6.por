/*6 - Escreva um programa que diga se o número é par ou ímpar Dica : o operador % 
calcula a divisão de um número X por um número Y e retorna o resto da divisão 
Exemplo : 
Entrada: Digite um 
número : 2 
Saída: O número 2 
é par
*/

programa
{
	
	funcao inicio()
	{	
		inteiro numero1
		escreva("Digite um número:")
		leia(numero1)

		

		se(numero1 % 2 == 0){

			escreva(" o número ",numero1, " é par ")
		} senao {
			escreva("o numero" ,numero1 ," é impar ")
		}

		escreva("")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 271; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */