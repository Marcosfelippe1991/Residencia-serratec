/* - Escreva um programa que receba a temperatura em Celsius e retorne o valor em Fahrenheit 
Exemplo : Entrada: Digite o valor da 
temperatura em Celsius : 10 
Saída: 10 graus Celsius é o mesmo que 50 graus 
Fahrenheit
1 = 33,8
2 = 50
3 = 
 
*/

programa
{
	
	funcao inicio()
	{	
		inteiro celcius, fahrenheit
		const inteiro MCDIVISO = 9 
		const inteiro MCDIVID = 5
		const inteiro SC = 32
		
		escreva("graus Celcius:")
		leia(celcius)
		fahrenheit = celcius * MCDIVISO/MCDIVID + SC

		escreva(celcius, " graus celcius é o mesmo que: ", fahrenheit, " graus Fahrenheit"  )
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 492; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */