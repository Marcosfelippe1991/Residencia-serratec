/*1 - Escreva um programa para verificar se um triângulo pode ser formado pelo valor 
fornecido para os ângulos. 

1- Soma dos angulos internos tem que ser igual a 180
2- todos os angulos tem que ser inteiros
3- Nenhum angulo pode ser menor ou igual a 0
4- Nenhum angulo pode ser maior ou igual a 179


Exemplo de entrada: 
40 55 65 


Saída esperada: O triângulo não é válido
*/

programa
{
	
	funcao inicio()
	{
		inteiro angulo1, angulo2, angulo3
		
		
		escreva("Digite o primeiro angulo:\n")
		leia(angulo1)

		escreva("Digite o segundo angulo:\n")
		leia(angulo2)

		escreva("Digite o terceiro angulo:\n")
		leia(angulo3)

		se ((angulo1<=0 ou angulo2<=0 ou angulo3<=0) ou (angulo1>=178 ou angulo2>=178 ou angulo3>= 178) ou 
		(angulo1 + angulo2 + angulo3) != 180){
			escreva("trigulo não é valido!")
		     } senao {
		     	escreva("triangulo é valido") 
		             } 
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 634; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */