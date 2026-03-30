/* Para o sistema funcionar, utilize estes comandos. (postgreSQL)

CREATE TABLE aluno (
                       id SERIAL PRIMARY KEY,
                       nome VARCHAR(100) NOT NULL
);

CREATE TABLE matricula (
                           id SERIAL PRIMARY KEY,
                           aluno_id INT NOT NULL,
                           disciplina VARCHAR(50) NOT NULL,

                           CONSTRAINT fk_matricula_aluno
                               FOREIGN KEY (aluno_id)
                                   REFERENCES aluno(id)
                                   ON DELETE CASCADE
);

CREATE TABLE nota (
                      id SERIAL PRIMARY KEY,
                      matricula_id INT NOT NULL,
                      tipo VARCHAR(50) NOT NULL,
                      valor DOUBLE PRECISION NOT NULL,
                      peso DOUBLE PRECISION NOT NULL,

                      CONSTRAINT fk_nota_matricula
                          FOREIGN KEY (matricula_id)
                              REFERENCES matricula(id)
                              ON DELETE CASCADE
);
*/