programa
{
	funcao inicio()
	{	
		real primeiroNumero
		real	segundoNumero
		real resultadoDivisao
		inteiro escolhaUsuario
		 
		escreva("Para realizar divisão digite 1.\nPara finalizar digite 2. \n")
		leia (escolhaUsuario)
		
		se (escolhaUsuario == 1)
		{
			enquanto (escolhaUsuario == 1)
			{	
				escreva("Digite o primeiro numero: ")
				leia (primeiroNumero)
				escreva("Digite o segundo numero: ")
				leia(segundoNumero)
		
				resultadoDivisao = divisaoDeDoisNumeros(primeiroNumero, segundoNumero)
		
				se (resultadoDivisao <= 0)
				{
					escreva("O valor tem que ser maior que zero, realize a operação novamente. ")
				}senao 
				{
					escreva("\nSeu resultado é:  " , resultadoDivisao)
				} 
				escreva("\n\nPara realizar divisão digite 1.\npara finalizar digite 2. \n ")
				leia (escolhaUsuario)			
			} 	
		}
		escreva("\nvoce saiu do sistema!")
	}
	funcao real divisaoDeDoisNumeros(real primeiroNumero, real segundoNumero)
	{
		retorne primeiroNumero / segundoNumero 
	}
}


// e - entender
// p - planejar
// e - executar
// r - revisar

// passo 1 = ler dois valores OK
// 	passo 1.1 = dividir o primeiro pelo segundo OK
// passo 2 = o segundo valor não pode ser 0 ou negativo OK
// passo 3 = informar que o valor tem que se maior do que 0 caso ele coloque 0 ou numero negativo OK
// 	passo 3.1 = solicitar um novo valor caso ocorra o passo três ok
//		passo 3.2 = após a verificação deverá imprimir o resultado  ok
// passo 4 = ao final precisa perguntar se deseja calcular outra divisão ok
//	passo 4.1 = caso seja positivo perguntar os valores. ok
// fim do programa ! ok

/*
trabalho final - exercicio 1
Leia dois valores e efetue a divisão do primeiro pelo segundo. O segundo valor não pode ser ZERO 
ou negativo, caso isso ocorra você deve informar ao usuário que o segundo número deve ser maior 
do que ZERO e solicitar um novo valor. Deverá imprimir o resultado. Ao final deve perguntar se 
deseja calcular outra divisão e caso sua resposta seja positiva limpe a tela e solicite novos valores.
*/


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 11; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */