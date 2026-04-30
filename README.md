# Slay the Spire!

Esta é uma implementação simplificada de um jogo inspirado em Slay the Spire. Simula-se uma batalha em turnos entre um herói e um inimigo utilizando cartas de dano e escudo.

## Como jogar

O herói começa com 100 de vida e 6 de energia por turno. O jogador deve escolher quais cartar usar de acordo com a energia disponível e sua estratégia, focando em derrotar os inimigos. Ao fim de cada turno, sua energia é restaurada e seu escudo zerado, passando a vez para os inimigos, que podem causar dano, usar escudo e aplicar um efeito.

**Cartas disponíveis:**

- Espada (custo 2): causa 10 de dano ao inimigo
- Machado (custo 4): causa 15 de dano ao inimigo
- Cajado (custo 3): causa 12 de dano ao inimigo
- Adagas (custo 1): causa 8 de dano ao inimigo
- Arco e flecha (custo 3): causa 11 de dano ao inimigo
- Adagas de lançamento (custo 2): causa 10 de dano ao inimigo
- Besta(custo 4): causa 13 de dano ao inimigo

- Armadura (custo 3): adiciona 15 de escudo ao herói
- Escudo de madeira (custo 2): adiciona 10 de escudo ao herói
- Escudo (custo 1): adiciona 5 de escudo ao herói
- Feitiço proteção (custo 5): adiciona 20 de escudo ao herói
- Soro de resistência (custo 2): adiciona 10 de escudo ao herói
- Cota de malha (custo 2): adiciona 7 de escudo ao herói
- Capacete (custo 3): adiciona 7 de escudo ao herói

- Frasco envenenado (custo 3): causa 5 de dano ao inimigo
- Feitiço de cura (custo 2) Cura 4 de vida do herói
- Poção de cura (custo 3) Cura 5 de vida do herói

**Cartas que podem ser compradas:**
- Adaga envenenada (custo 2): causa 5 de dano ao inimigo
- Curativo (custo 2) Cura 5 de vida do herói
- Soro de resistencia (custo 1) Cura 4 de vida do herói

**Loja:**
A loja ocorre depois de toda batalha e permite o jogador compre itens que i ajudem na proxima batalha.

**Escolha:**
Depois de toda batalha o jogador escolhe entre ganhar mais ouro, energia ou escudo

## Escolha do padr ̃ao de design para loja e escolha

Para implementar a loja e a escolha foi utilizado o padr ̃ao de design Strategy. Nesse padrão cada item da loja é uma classe que implementa a interface ItemLoja e ItemEscolha, ou seja, cada item da loja possui um metodo interno que excuta a compra/execução do item de modo que para a loja e a escolha o tipo do item seja indiferente.

## Compilação e execução

### Compilar

* ./gradlew build

### Executar

* ./gradlew run

## Autores

[Leonardo Mascioli Amêndola] - RA: [204382]

[Enzo Villani Tonus] - RA: [277148]
