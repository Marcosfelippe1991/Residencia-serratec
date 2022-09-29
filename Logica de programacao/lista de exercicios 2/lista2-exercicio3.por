/*
 * 3 - Escreva um programa para verificar se um caractere é uma vogal ou consoante. 
Exemplo de entrada: 
k
Saída esperada: k 
é uma consoante 
 */
programa
{
	
	funcao inicio()
	{
		cadeia letra

		escreva("digite uma letra:")
		leia (letra)

	

		se (letra == "a" ou letra == "e" ou letra =="i" ou letra== "o" ou letra == "u")
		{
			escreva("é uma vogal!")
		} senao
			{
				escreva ("é uma consoante")
			}
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 150; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */