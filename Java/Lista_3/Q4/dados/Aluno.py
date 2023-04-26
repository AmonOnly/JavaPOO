from Pessoa import Pessoa

class Aluno(Pessoa):
    def __init__(self):
        super().__init__(self)
        self.notas = []
    def setNota(self, notas: list):
        self.notas = notas
    def getNota(self):
        return self.notas
    
    def calcularMedia(self):
        soma = 0
        for i in self.notas:
            soma += i
        return soma/len(self.notas)

    def __repr__(self):
        String = "Nome: {} ".format(self.nome) + "Media: {} ".format(self.calcularMedia())+ " Notas: "
        size = len(self.notas)
        for i in self.notas:
            size -= 1
            if(size == 0):
                String += "{} ".format(i)
            else:
                String += "{}, ".format(i)
        if(self.calcularMedia() >= 7):
            String += " Status: Aprovado"
        else:
            String += " Status: Reprovado"
        return String