programa
{    
	/*
	e = entender - escrever uma funcão, ela vai receber dois numero 
	e depois vai calcular a media entre eles
	p = planeja
	e = executar
	r = revisar
	*/
	// passo 1 - criar uma função
	// passo 2 - a função precisa receber tres numeros 
	// passo 3 - ela deve calcular a media entre os tres numeros
	// passo 4 - criar uma funçao que pergunte os numero para realizar a media
	// passo 5 - ela tem que mostrar na tela 
	funcao inicio()
	{	
		inteiro num1
		inteiro num2
		escreva("escreva a primeira nota:")
		leia(num1)
		escreva("escreva a segunda nota:")
		leia(num2)
		
		//media (num1 + num2 )/2
		calculaMediaTresNumeros(num1, num2)
	} 	
		//faz o calculo e volta o valor para a função inicio aonde escreve na tela	
	funcao calculaMediaTresNumeros(inteiro num1, inteiro num2)
	{
		inteiro media = (num1 + num2 )/2
		escreva("sua média é: ", media, "\n")
	} 
}

/*
 1 - Escreva uma função que recebe 2 números e calcule a média entre eles : 
Exemplo de entrada: Digite o 
primeiro número: 2 Digite o 
segundo número : 6 
Saída esperada: 
A média é : 4  
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 893; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */