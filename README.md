# IEEE Match UFC

Programa que ajuda pessoas com dúvida sobre **qual área do IEEE Student Branch UFC escolher**, seja para quem já faz parte do ramo ou para quem quer entrar.

A pessoa responde a um questionário curto sobre perfil, habilidades, interesses e atividades preferidas, e o programa sugere a **comissão** e o **grupo de afinidade ou capítulo técnico** com maior compatibilidade.

> Projeto desenvolvido na fase de trainee do IEEE UFC Student Branch (Desafio 5 – Projetos Técnicos e Webmaster).

---

## Estrutura do repositório

O repositório tem duas pastas:

```
.
├── codigo-fonte/     # Código-fonte do programa
└── instaladores/     # Instaladores prontos para uso
    ├── .jar          # Executável Java (multiplataforma)
    ├── .exe          # Instalador para Windows
    └── .deb          # Pacote para Debian/Ubuntu e derivados
```

| Pasta | Conteúdo |
|---|---|
| `codigo-fonte/` | Todo o código-fonte, para quem quiser estudar, modificar ou compilar o programa. |
| `instaladores/` | Versões prontas: `.jar`, `.exe` e `.deb`. |

---

## Como instalar e executar

Escolha o instalador de acordo com o seu sistema, dentro da pasta `instaladores/`.

**Windows (`.exe`)**
Baixe o arquivo `.exe`, dê dois cliques e siga o assistente de instalação.

**Linux – Debian/Ubuntu e derivados (`.deb`)**
```bash
sudo dpkg -i nome-do-pacote.deb
```

**Qualquer sistema (`.jar`)**
Requer o Java instalado.
```bash
java -jar nome-do-arquivo.jar
```

> Troque `nome-do-pacote.deb` e `nome-do-arquivo.jar` pelos nomes reais dos arquivos da pasta.

---

## Como o programa funciona

1. **Tela inicial:** a pessoa informa se **já é membro** do ramo ou se **quer entrar**. Isso só muda o texto do resultado.
2. **Questionário:** a pessoa escolhe opções em 4 tipos de características.
3. **Cálculo:** cada resposta é comparada com o perfil de cada área e gera uma pontuação.
4. **Resultado:** o programa mostra a área recomendada, a porcentagem de compatibilidade, uma segunda opção e uma explicação de quais respostas combinaram.

As respostas são processadas localmente e não são armazenadas.

### Os 4 tipos de características

| Tipo | Pergunta | Escolhas | Peso |
|---|---|---|---|
| **P – Perfil** | Como você é? | até 2 | 1 |
| **H – Habilidades** | O que você sabe fazer? | até 3 | 2 |
| **I – Interesses** | O que te atrai? | até 2 | 3 |
| **A – Atividade preferida** | O que você gosta de fazer? | até 2 | 2 |

Os **interesses** têm o maior peso porque são o que mais indica onde a pessoa vai se sentir pertencente. O **perfil** tem o menor, pois descreve a pessoa de forma mais geral.

### Opções de cada tipo

**Perfil (P)**
- P1 Comunicativo e articulador
- P2 Organizado e metódico
- P3 Acolhedor e empático
- P4 Focado e independente
- P5 Criativo e expressivo
- P6 Negociador e de networking

**Habilidades (H)**
- H1 Programação
- H2 Desenvolvimento web
- H3 Eletrônica e hardware
- H4 Robótica, automação e controle
- H5 IA, dados e processamento de sinais
- H6 Design, fotografia e edição de vídeo
- H7 Redação e escrita
- H8 Finanças, planilhas e orçamento
- H9 Gestão de projetos e de tempo
- H10 Inglês e outros idiomas
- H11 Didática
- H12 Eletrotécnica e eletrônica de potência

**Interesses (I)**
- I1 Robótica e automação
- I2 Circuitos, chips e sinais
- I3 Energia, veículos elétricos e indústria
- I4 IA e visão computacional
- I5 Acessibilidade, educação e meio ambiente
- I6 Ação humanitária em comunidades
- I7 Diversidade e inclusão na engenharia
- I8 Eventos e vida de comunidade
- I9 Bastidores e gestão do ramo
- I10 Cenário internacional

**Atividade preferida (A)**
- A1 Planejar e organizar eventos
- A2 Construir protótipos e projetos
- A3 Criar conteúdo e divulgar
- A4 Acolher pessoas e engajar membros
- A5 Registrar e documentar
- A6 Buscar parcerias e contatos
- A7 Controlar dinheiro e recursos
- A8 Cuidar de espaço, materiais e logística
- A9 Manter sites e sistemas
- A10 Acompanhar prazos e entregas

### Cálculo da compatibilidade

Cada área do IEEE UFC tem uma "assinatura": o conjunto de características que mais combinam com ela. A pontuação da pessoa em cada área é:

```
pontuação = 3 × acertos em Interesses
          + 2 × acertos em Habilidades
          + 2 × acertos em Atividades
          + 1 × acertos em Perfil

compatibilidade (%) = pontuação ÷ pontuação máxima da área × 100
```

- "Acerto" é uma opção escolhida pela pessoa que também faz parte da assinatura da área.
- A pontuação máxima varia de área para área, por isso a compatibilidade é calculada em porcentagem.
- **Desempate:** vence a área com mais acertos em Interesses e, persistindo o empate, em Habilidades.

### Dois rankings separados

O programa gera dois rankings independentes, já que a pessoa pode participar de uma comissão e de um grupo ou capítulo ao mesmo tempo:

| Ranking | Áreas |
|---|---|
| **Comissões (11)** | Gestão de Projetos, Atividades, Comunicação, Gestão de Pessoas, Relações Internacionais, Secretaria, Finanças, Infraestrutura, Webmaster, Projetos Técnicos – Sistemas Autônomos e Inteligência Computacional, Projetos Técnicos – Tecnologias Assistivas, Educacionais e Socioambientais |
| **Grupos e capítulos (5)** | **Grupos de afinidade:** WIE, SIGHT. **Capítulos técnicos:** RAS, CASS, TEC/PELS/IAS |

Para cada ranking, o resultado mostra a área mais compatível, a segunda opção e uma explicação curta de por que ela foi sugerida.

---

## Limitações

- O resultado é uma **sugestão** baseada nas respostas, não uma regra. Conversar com membros das áreas continua sendo importante.
- As assinaturas das áreas foram definidas pela equipe a partir da descrição de cada comissão, grupo e capítulo, e ainda não foram validadas com um grupo amplo de membros.

## Equipe

Desenvolvido por estudantes na fase de trainee do **IEEE UFC Student Branch**.
