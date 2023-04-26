from Pessoa import Pessoa

class Professor(Pessoa):
    def __init__(self):
        super().__init__(self)
        self.Salario = 0.0
    
    def setSalario(self,Salario):
        self.Salario = Salario
    def getSalario(self):
        return self.Salario
    
    def __repr__(self):
        String = "Nome: {} ".format(self.nome) + " Salario: {} ".format(self.Salario)
        return String