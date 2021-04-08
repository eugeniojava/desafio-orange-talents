# desafio-orange-talents

Escrever um texto sobre uma das tecnologias do programa. Espera-se um artigo, estilo blog post, sobre um projeto em Spring.

## Contexto

Você está fazendo uma API REST que precisará controlar a aplicação de vacinas entre a população brasileira.

### Cadastro de usuários

- Nome;
- E-mail (único);
- CPF (único);
- Data de nascimento.

### Cadastro de aplicação de vacinas

- Nome da vacina;
- E-mail do usuário;
- Data da realização da vacina.

### Endpoints

- Cadastro do usuário;
- Cadastro da aplicação da vacina.

#### Retornos

- HTTP Status 201 Created: dados corretos, cadastro realizado;
- HTTP Status 400 Bad Request: erro(s) de preenchimento de dado(s), cadastro não realizado.

## Desafio

Dado que você fosse implementar esse sistema utilizando Java como linguagem e Spring + Hibernate como stacks de tecnologia fundamentais da aplicação, escreva um post de blog explicando de maneira detalhada tudo que você faria para implementar esse código.

No texto, queremos que você:

- Explique quais as tecnologias do mundo Spring você usaria;
- Conte qual o papel das tecnologias escolhidas e quais benefícios elas trazem para a implementação do código;
- Diga quais classes seriam criadas nesse processo e traga trechos autorais explicando a construção de cada classe do código;
- Explique as etapas do processo de construção do seu código e como faria a implementação do sistema na Web;
- Traga trechos de códigos autorais que justifiquem a implementação de cada tecnologia (não precisamos do código inteiro);
- Os itens acima são obrigatórios, mas não se limite. Se quiser escrever mais, fique à vontade (não existe quantidade máxima de páginas ou caracteres).

### Dicas

- Não precisamos saber como instalar cada ferramenta, queremos saber como você implementaria o seu código.
- Ao justificar as tecnologias, mostre a sua visão e entendimento de cada uma e não conceitos prontos já conhecidos.
- Cite as tecnologias que você utilizaria em seu projeto e porquê elas fazem parte do escopo/construção do seu código, pois ficaremos de olho nesse ponto.
- Suas classes e atributos podem ser em português ou em inglês, não se apegue a isso, queremos um bom resultado final.
- Não queremos um manual de programação e sim um post explicando como você faria a implementação da API passo a passo.

Mais do que respostas certas, queremos ver o quão nerd você consegue ser e o que considera relevante. O importante é mostrar que consegue aprender, se fazer entender e ainda transmitir conhecimento.

### Se ficou fácil, te desafiamos a

- Construir a aplicação sem utilizar Lombok;
- Substituir o e-mail do usuário na tabela de vacinação para uma chave estrangeira associada ao id do usuário.

Seu texto poderá conter imagens e deverá ser enviado em formato PDF.
