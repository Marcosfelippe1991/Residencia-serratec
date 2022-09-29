
/* 1 - Modifique o exercício 6 da lista anterior para imprimir os números de 1 até n e 
também realizar sua soma. 
Exemplo de entrada: 6 Saída esperada: 1 2 3 4 5 6 
21
 */
programa
{
	funcao inicio()
	{
		//criando variaveis
		inteiro indice = 1
		inteiro controle = 6
		inteiro resultadoSoma = 1

		// criando um enquanto (enquanto 1 for menor ou igual a 6)		
		enquanto (indice <= controle )
		{	
			// escrevendo no console a cada vez que o enquando roda
			escreva( indice + ", ")
			// somando +1 no valor de indice "enquanto" roda
			indice++
			// criando um se dentro de um enquanto 
			// essa condicional vai ser lida todas as vezes que o enquanto rodar
			se (indice <= controle)
			{
				// recebe o valor da soma de indice + o resultadoSoma 
				resultadoSoma = resultadoSoma + indice
			}
		}   
		// esse "escreva" escreve o resultado final da soma quando o "enquando" termina 
		escreva("\n" + resultadoSoma)
	}
}
			
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 934; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {indice, 12, 10, 6}-{resultadoSoma, 14, 10, 13};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */