import string;

class gerente:
    def __init__(self):
        self.nome = ""
        self.cpf = ""
        self.salario = 0

    def setNome(self,nome):
        self.nome = nome
    def getNome(self):
        return self.nome
    def setCPF(self, cpf):
        self.cpf = cpf
    def getCPF(self):
        return self.cpf
    def setSalario(self, salario):
        self.salario = salario
    def getSalario(self):
        return self.salario
    def __str__(self) -> str:
        return f"Nome: {self.nome}, Cpf: {self.cpf}, salario: {self.salario}"
    
    