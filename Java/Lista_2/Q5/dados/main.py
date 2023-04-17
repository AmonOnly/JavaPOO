from Filme import Filme
import json

filmes = []

try:
    with open('Q5\\dados\\filmes.json', 'r') as f:
        data = json.load(f)
        for i in data:
            filme = Filme()
            filme.jsonInit(i)
            filmes.append(filme)
except FileNotFoundError:
    print("Arquivo 'filmes.json' nao encontrado.")

if filmes:
    filmes.sort(key=lambda filme: filme.getNota(), reverse=True)
    print(f"Foram carregados {len(filmes)} filmes.")
    for i in filmes:
        print(i)
else:
    print("Nenhum filme encontrado.")