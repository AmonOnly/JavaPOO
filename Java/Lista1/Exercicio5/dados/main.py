from Gerente import gerente
from Mercado import Mercado

ger = gerente()
ger.setCPF("12863359908")
ger.setNome("Leonardo de Souza Dunzer")
ger.setSalario(2500)

mercado = Mercado()
mercado.setBairro("Floresta")
mercado.setCidade("joinville")
mercado.setFuncionarios(30)
mercado.setNome("Joinvilense")
mercado.setRua("São Paulo")
mercado.setGerente(ger)

print("\n")
print(mercado)
print("\n\n")
print(ger)