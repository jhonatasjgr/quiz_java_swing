CREATE DATABASE quiz;
USE quiz;

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade_acertos INT DEFAULT 0
);
CREATE TABLE questao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    enunciado TEXT NOT NULL,
    alternativa1 VARCHAR(300) NOT NULL,
    alternativa2 VARCHAR(300) NOT NULL,
    alternativa3 VARCHAR(300) NOT NULL,
    alternativa4 VARCHAR(300) NOT NULL,
    alternativa_certa VARCHAR(300) NOT NULL
);


-- inserções 

INSERT INTO questao (enunciado, alternativa1, alternativa2, alternativa3, alternativa4, alternativa_certa)  
VALUES  
-- Questões de POO
('Qual é o pilar da POO que permite que uma classe herde características de outra?',  
 'Encapsulamento', 'Herança', 'Polimorfismo', 'Abstração', 'Herança'),  
('O que é um objeto na Programação Orientada a Objetos?',  
 'Uma função que executa uma ação',  
 'Uma variável que armazena múltiplos valores',  
 'Uma instância de uma classe',  
 'Uma estrutura de dados estática',  
 'Uma instância de uma classe'),  
('Qual modificador de acesso permite que um atributo seja acessado apenas dentro da própria classe?',  
 'public', 'private', 'protected', 'static', 'private'),  
('Qual linguagem de programação é amplamente conhecida por seu suporte à Programação Orientada a Objetos?',  
 'Java', 'Python', 'C', 'Assembly', 'Java'),  
('O que significa o conceito de polimorfismo na POO?',  
 'Capacidade de uma classe ter múltiplos métodos com o mesmo nome, mas com diferentes implementações',  
 'Capacidade de um objeto armazenar múltiplos valores',  
 'Atribuição de valores a variáveis privadas',  
 'A execução de um método automaticamente',  
 'Capacidade de uma classe ter múltiplos métodos com o mesmo nome, mas com diferentes implementações'),  
('Qual pilar da POO garante que os detalhes internos de um objeto fiquem ocultos e sejam acessados apenas por meio de métodos públicos?',  
 'Herança', 'Encapsulamento', 'Polimorfismo', 'Abstração', 'Encapsulamento'),  
('O que é uma classe na POO?',  
 'Uma variável que armazena dados',  
 'Um conjunto de funções independentes',  
 'Um modelo para criar objetos',  
 'Um método para executar operações',  
 'Um modelo para criar objetos'),  
('O que acontece quando uma classe herda de outra classe na POO?',  
 'Ela perde seus próprios métodos',  
 'Ela copia os atributos, mas não os métodos',  
 'Ela passa a ter acesso aos atributos e métodos da classe pai',  
 'Ela se torna abstrata automaticamente',  
 'Ela passa a ter acesso aos atributos e métodos da classe pai'),  
('Na POO, qual é o papel de um construtor em uma classe?',  
 'Definir os atributos da classe como privados',  
 'Inicializar um objeto quando ele é instanciado',  
 'Deletar um objeto da memória automaticamente',  
 'Criar novos métodos para a classe',  
 'Inicializar um objeto quando ele é instanciado'),  
('O que acontece quando um método de uma classe filha sobrescreve um método da classe pai?',  
 'O método original da classe pai deixa de existir',  
 'O método da classe filha substitui a implementação do método na classe pai',  
 'A classe filha herda o método sem modificações',  
 'Ambos os métodos são executados simultaneamente',  
 'O método da classe filha substitui a implementação do método na classe pai'),  
-- Questões de SQL
('Qual comando SQL é usado para selecionar todos os registros de uma tabela?',  
 'SELECT ALL', 'GET * FROM', 'SELECT * FROM', 'FETCH * FROM', 'SELECT * FROM'),  
('Qual cláusula SQL é usada para filtrar registros com base em uma condição?',  
 'ORDER BY', 'WHERE', 'FILTER', 'HAVING', 'WHERE'),  
('Qual comando SQL é usado para inserir novos registros em uma tabela?',  
 'INSERT INTO', 'ADD RECORD', 'NEW ENTRY', 'APPEND TO', 'INSERT INTO'),  
('Qual comando SQL é usado para remover todos os registros de uma tabela sem excluir a estrutura da tabela?',  
 'DELETE', 'REMOVE', 'DROP', 'TRUNCATE', 'TRUNCATE'),  
('Qual operador SQL é usado para buscar registros dentro de um intervalo de valores?',  
 'IN', 'BETWEEN', 'RANGE', 'LIMIT', 'BETWEEN'),  
('O que o comando SQL "ORDER BY" faz?',  
 'Filtra registros', 'Ordena os resultados', 'Agrupa registros', 'Exclui dados duplicados', 'Ordena os resultados'),  
('Qual palavra-chave SQL é usada para garantir que os resultados da consulta não contenham valores duplicados?',  
 'NO DUPLICATES', 'DISTINCT', 'UNIQUE', 'FILTER', 'DISTINCT'),  
('Qual comando SQL é usado para modificar registros existentes em uma tabela?',  
 'CHANGE', 'UPDATE', 'MODIFY', 'SET', 'UPDATE'),  
('O que a cláusula "GROUP BY" faz em uma consulta SQL?',  
 'Agrupa registros com base em valores comuns', 'Ordena os resultados', 'Remove registros duplicados', 'Cria uma nova tabela', 'Agrupa registros com base em valores comuns'),  
('Qual comando SQL é usado para remover uma tabela completamente do banco de dados?',  
 'DELETE TABLE', 'REMOVE TABLE', 'DROP TABLE', 'CLEAR TABLE', 'DROP TABLE');  
