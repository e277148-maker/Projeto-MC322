# Slay the Spire!

Esta é uma implementação simplificada de um jogo inspirado em Slay the Spire. Simula-se uma batalha em turnos entre um herói e um inimigo utilizando cartas de dano e escudo.

## Como jogar

O herói começa com 50 de vida e 6 de energia por turno, já o inimigo começa com 30 de vida e causa 10 de dano. O jogador deve escolher quais cartar usar de acordo com a energia disponível e sua estratégia, focando em derrotar o inimigo. Ao fim de cada turno, sua energia é restaurada e seu escudo zerado, passando a vez para o inimigo, que pode causar dano, usar escudo ou ambos.

**Cartas disponíveis:**

- Espada (custo 2): causa 10 de dano ao inimigo
- Machado (custo 4): causa 15 de dano ao inimigo
- Cajado (custo 3): causa 12 de dano ao inimigo
- Adagas (custo 1): causa 8 de dano ao inimigo
- Arco e flecha (custo 3): causa 11 de dano ao inimigo

- Armadura (custo 3): adiciona 15 de escudo ao herói
- Escudo de madeira (custo 2): adiciona 10 de escudo ao herói
- Escudo (custo 1): adiciona 5 de escudo ao herói
- Feitiço proteção (custo 5): adiciona 20 de escudo ao herói
- Soro de resistência (custo 2): adiciona 10 de escudo ao herói

## Compilação e execução

### Compilar

* javac -d bin src/*.java

### Executar

* java -cp bin App

## Autores

[Leonardo Mascioli Amêndola] - RA: [204382]

[Enzo Villani Tonus] - RA: [277148]
