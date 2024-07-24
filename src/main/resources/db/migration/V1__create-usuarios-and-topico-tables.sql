CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(100) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    nombre_curso VARCHAR(100) NOT NULL,
    id_usuario BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

