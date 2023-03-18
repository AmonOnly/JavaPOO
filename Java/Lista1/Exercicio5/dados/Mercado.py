import string;
from Gerente import gerente

class Mercado:
    def __init__(self):
        self.__ruaMercado = ""
        self.__cidadeMercado = ""
        self.__bairroMercado = ""
        self.__nomeMercado = ""
        self.__funcionaiosMercado = ""
        self.__gerente = gerente
    def setRua(self, ruaMercado):
        self.__ruaMercado = ruaMercado
    def getRua(self):
        return self.__ruaMercado
    def setCidade(self,cidadeMercado):
        self.__cidadeMercado = cidadeMercado
    def getCidade(self):
        return self.__cidadeMercado
    def setBairro(self,bairroMercado):
        self.__bairroMercado = bairroMercado
    def getBairro(self):
        return self.__bairroMercado
    def setNome(self,nomeMercado):
        self.__nomeMercado = nomeMercado
    def getNome(self):
        return self.__nomeMercado
    def setFuncionarios(self,funcionariosMercado):
        self.__funcionaiosMercado = funcionariosMercado
    def getFuncionarios(self):
        return self.__funcionaiosMercado
    def setGerente(self, gerente):
        self.__gerente = gerente
    def getGerente(self):
        return self.__gerente
    
    def __str__(self):
        return f"Nome do Mercado: {self.__nomeMercado}, Endereço do mercado: rua {self.__ruaMercado} do bairro {self.__bairroMercado} de {self.__cidadeMercado}, Quantidade de funcionario: {self.__funcionaiosMercado} sobe a gerencia de {self.__gerente.nome}"
