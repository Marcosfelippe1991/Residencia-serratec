/*5 - Escreva um programa que calcule o número de dígitos de um dado número usando 
recursão: 
Exemplo de entrada: 
100 
Saída esperada: O número de dígitos 
do número é : 2 
 
	e = entender - seja passado um ano pelo console e dizer se o ano passodo é bisexto
	p = planeja
	e = executar
	r = revisar
	*/
	//   passo 1 - criar uma função para calcular o numero de digitos
	//	passo 2 - pegar numero no console
	//	passo 3 - calcular a quantidade de digitos que ele tem
	//	passo 4 - entrar com a resposta no console

programa
{
	
	funcao inicio()
	{
		inteiro numeroDigitadoUsuario
		escreva ("Quantos digitos tem: ")
		leia (numeroDigitadoUsuario)

		escreva(contadorDeDigitos(numeroDigitadoUsuario))
	}
	funcao inteiro contadorDeDigitos(inteiro numero)
	{
		se ( numero <0)
		{
			numero = numero * -1
		}
		se (numero <=9)
		{
			retorne 1
		}
		retorne 1 + (contadorDeDigitos(numero/10))	
	}
}










/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */