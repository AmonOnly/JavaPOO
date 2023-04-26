class Pessoa:
    def __init__(self, nome:str):
        self.nome = nome
    
    def setNome(self, nome: str):
        self.nome = nome

    def getNome(self):
        return self.nome
