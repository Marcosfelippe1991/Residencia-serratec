/*
2 - Escreva uma função que receba um ano e diga se ele é bissexto ou não e utilize 
esta função para verificar 5 : 
Exemplo de entrada: 
2017 
Saída esperada: O ano 2017 
não é bissexto 
*/

programa
{	
	/*
	e = entender - seja passado um ano pelo console e dizer se o ano passodo é bisexto
	p = planeja
	e = executar
	r = revisar
	*/
	// passo 1 - criar uma função para executar o programa ok
	//	passo 1.1 - receber o calculo da função que calcula o ano 
	//	passo 1.2 - receber o ano que foi digitado pela função que recebe o ano
	//	passo 1.3 - definir se o ano é bisexto com base nas informações recebidas ok
	// passo 2 - criar função para receber o ano pelo console ok
	//	passo 2.1 - precisa perguntar o ano no console e armazenar em uma variavel ok 
	//	passo 2.2 - retornar o  ano recebido no console ok
	// passo 3 - criar outra função para fazer o calculo de ano bisexto
	//	passo 3.1 - descobrir o calculo de ano bisexto
	//		passo 3.1.1 - um ano é bisexto quando o "ano % 4 == 0" 
	//	passo 3.2 - retornar o resultado do calculo
	
	funcao inicio()
	{
		se (calculoAnoBisexto() == 0)
		{	
			escreva ("o ano é bisexto")
		} senao
			{
				escreva("não é bisexto")				
			}
	}
	funcao inteiro obterAnoConsole() 
	{
		inteiro ano
		
		escreva("digite o ano para saber se é bisexto: ")
		leia(ano)
		
		retorne ano
	}
	funcao inteiro calculoAnoBisexto()
	{
		inteiro restoDivisao = obterAnoConsole() % 4 
		
		retorne restoDivisao	
	}
}














/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1113; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */