programa
{
	
	funcao inicio()
	{

	inteiro soma, sub, mult, div
	inteiro n1, n2
	inteiro op

	escreva("1 para somar: \n")
	escreva("2 para subtrair: \n")
	escreva("3 para multiplicar: \n")
	escreva("4 para dividir: \n")
	leia(op)
	limpa()
	escreva("Digite o primeiro número:")
	leia(n1)
	escreva("\nDigite o segundo número:")
	leia(n2)

	se (op == 1)
		{ soma = n1+n2
			escreva("Sua soma é é igual a: ",soma)
		} senao se (op == 2)
			{
				sub = n1-n2
				escreva("sua subtração é é igual a: ",sub)
			} senao se (op == 3)
				{	mult = n1 * n2
					escreva("sua multiplcação é igual a: ", mult)
				} senao se (op == 4)
					{
						div = n1/ n2
						escreva("sua divisão é igual a: ", div)
					} senao
						escreva("operação Invalida!")		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 749; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */