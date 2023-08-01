Algoritmo "Agencia de Viagens Do Tour"

var
   clientes: vetor[1..5] de caractere
   destinos: vetor[1..4] de caractere
   totalClientes, totalDestinos: inteiro
   opcao: inteiro

procedimento CadastrarCliente()
var
   nome, cpf: caractere
inicio
   se totalClientes < 5 entao
      escreval("Digite o nome do cliente: ")
      leia(nome)
      escreval("Digite o CPF do cliente: ")
      leia(cpf)
      totalClientes <- totalClientes + 1
      clientes[totalClientes] <- "Nome: " + nome + " | CPF: " + cpf
   senao
      escreval("Limite de clientes atingido. Impossivel cadastrar.")
   fimse
fimprocedimento


procedimento CadastrarDestino()
var
   destino: caractere
inicio
   se totalDestinos < 4 entao
      escreval("Digite o nome do destino: ")
      leia(destino)
      totalDestinos <- totalDestinos + 1
      destinos[totalDestinos] <- "Destino: " + destino
   senao
      escreval("Limite de destinos atingido. Impossivel cadastrar.")
   fimse
fimprocedimento


procedimento ConsultarClientes()
var
   i: inteiro
inicio
   se totalClientes > 0 entao
      para i <- 1 ate totalClientes faca
         escreval(clientes[i])
      fimpara
   senao
      escreval("Nenhum cliente cadastrado.")
   fimSe
fimprocedimento


procedimento ConsultarDestinos()
var
   i: inteiro
inicio
   se totalDestinos > 0 entao
      para i <- 1 ate totalDestinos faca
         escreval(destinos[i])
      fimpara
   senao
      escreval("Nenhum destino cadastrado.")
   fimSe
fimprocedimento

Inicio
   totalClientes <- 0
   totalDestinos <- 0

   repita
      escreval("========Do Tour======")
      escreval("======== MENU =======")
      escreval("1. Cadastrar cliente")
      escreval("2. Cadastrar destino")
      escreval("3. Consultar clientes")
      escreval("4. Consultar destinos")
      escreval("5. Sair")
      escreval("======================")
      escreval("Digite a opcao desejada:")
      leia(opcao)

      escolha opcao
      caso 1
         CadastrarCliente()
      caso 2
         CadastrarDestino()
      caso 3
         ConsultarClientes()
      caso 4
         ConsultarDestinos()
      caso 5
         escreval("Finalizando o programa.")
      fimescolha
   ate opcao = 5
Fimalgoritmo
