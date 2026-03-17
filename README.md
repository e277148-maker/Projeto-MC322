## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


Nessa tarefa nós implementamos um hojo no qual tem um inimigo chamado Rato e um herói, os dois personagens travam uma batalha que será executada via terminal. A batalha funciona da seguinte forma: o herói possui uma quantidade de energia entre 0 e 3 e ele pode usar essa energia para utilizar uma carta de dano (espada) ou de escudo (armadura), já o Rato pode atacar ou aumentar o próprio escudo e essa escolha será feita aleatoriamente. Tanto a espada quanto o ataque do vilão causam 15 de dano e tanto a armadura quanto a defesa do inimigo aumentam em 10 o escudo.
A batalha funciona em turnos, o herói inicia e pode usar quantas cartas ele quiser, desde que tenha a energia necessária (espada tem custo 2 e armadura tem custo 1). Depois é o turno do vilão, que realizará apenas uma ação entre atacar e aumentar o escudo. Vale ressaltar que depois que o herói finaliza o turno ele ganha uma energia se possuir menos de 3. Esse processo se repete até um dos dois personagens morrer.

Compilar: javac -d bin $(find src -name "*.java")
Executar: java -cp bin App

