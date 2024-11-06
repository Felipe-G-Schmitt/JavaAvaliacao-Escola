CREATE database school;
USE school;

CREATE TABLE Professor (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    Departamento VARCHAR(100)
);

CREATE TABLE Curso (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
	CargaHoraria INT,
    IdProfessor INT,
    FOREIGN KEY (IdProfessor) REFERENCES Professor(Id)
);

CREATE TABLE Aluno (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    DataNascimento date,
    CPF VARCHAR(14),
    IdCurso INT,
    FOREIGN KEY (IdCurso) REFERENCES Curso(Id)
);