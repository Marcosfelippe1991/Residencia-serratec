/*
3 - Escreva um programa que imprima o seguinte padrão de número em formato de 
triângulo dado um número n. 
Exemplo de entrada: 
4 Saída esperada: 
1 12 123 1234 
*/
programa
{
	
	funcao inicio()
	{	
		inteiro n 
		escreva("escreva seu nunero")
		leia(n)
		//numeroDeEntrada
		inteiro aux = 1 //auxiliar
		
		enquanto (aux <= n)
		{ 
			para (inteiro i = 1; i<= aux; i++)
			{         // variavel i = contador
				escreva(i)
			}
				escreva("\n")
				aux += 1
		}
	} 
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 337; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */