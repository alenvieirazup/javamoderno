# Java Morderno

Projeto para assimilar o conteúdo do curso [Java moderno: tire proveito dos novos recursos do Java 8](https://cursos.alura.com.br/course/java8-lambdas) . O princípio foi utilizar testes automatizados para guiar a utilização dos principais conceitos do curso.

## Tecnologias utilizadas:

- Java 17
- Maven
- Junit 5

## Rodando os testes com o maven:

```bash
$ mvn test
```

## Rodando os testes através de um container:
```bash
# Contruindo uma imagem
$ docker build -t alenvieirazup/javamoderno .
# Executando os testes no container
$ docker run alenvieirazup/javamoderno
```
