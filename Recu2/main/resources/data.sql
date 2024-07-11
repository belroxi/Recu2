CREATE TABLE IF NOT EXISTS Categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DOUBLE NOT NULL,
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
    );

CREATE TABLE IF NOT EXISTS Orden (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    producto_id BIGINT,
    cantidad INT NOT NULL,
    estado VARCHAR(255) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (producto_id) REFERENCES Producto(id)
    );

INSERT INTO Categoria (nombre) VALUES ('Electrónica'), ('Libros'), ('Ropa');

INSERT INTO Usuario (nombre_usuario, contrasena, rol) VALUES
    ('juan_perez', 'contrasena123', 'USUARIO'),
    ('ana_garcia', 'contrasena456', 'ADMINISTRADOR');

INSERT INTO Producto (nombre, descripcion, precio, categoria_id) VALUES
     ('Portátil', 'Un portátil de alta gama', 1500.00, 1),
     ('Smartphone', 'Un smartphone de último modelo', 800.00, 1),
     ('Libro de Ficción', 'Un libro de ficción popular', 20.00, 2),
     ('Camiseta', 'Una camiseta cómoda', 15.00, 3);

INSERT INTO Orden (usuario_id, producto_id, cantidad, estado) VALUES
      (1, 1, 2, 'ENVIADO'),
      (2, 3, 1, 'PENDIENTE');
