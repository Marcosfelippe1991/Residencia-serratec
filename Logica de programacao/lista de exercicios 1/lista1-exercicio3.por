/*3 - Uma empresa paga R$10.00 por hora normal trabalhada e R$ 15.00 por hora extra. 
Escreva um algoritmo que leia o total de horas normais e o total de horas extras 
trabalhadas por um empregado em um ano e calcule o salário anual deste trabalhador. 
Exemplo : Entrada : Digite o número de horas trabalhadas no 
ano : 1760 Digite o número de horas extras trabalhadas no 
ano : 400 
Saída : Seu salário anual é de : R$ 
23600 
*/

programa
{
	
	funcao inicio()
	{

		inteiro horaNormal, horaExtra
		const real HORAEXTRA = 15.00, HORANORMAL = 10.00

		escreva("digite o numero de horas trabalhadas no ano:")
		leia(horaNormal)
		escreva("digite o numero de horas extras trabalhas no ano:")
		leia(horaExtra)

		escreva("Seu salario anual é de:", (horaNormal * HORANORMAL)+(horaExtra * HORAEXTRA))
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 427; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */