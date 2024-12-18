CREATE TABLE huesped (
    cedula INT(100) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono INT NOT NULL);

CREATE TABLE hospedaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_huesped INT NOT NULL,
    habitacion INT NOT NULL,
    fecha_ingreso DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    CONSTRAINT verificacion_fecha_salida CHECK (fecha_salida > fecha_ingreso),
    FOREIGN KEY (id_huesped) REFERENCES huesped(cedula));

CREATE TABLE retirante (
    id INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono INT NOT NULL,
    direccion VARCHAR(100) NOT NULL);

CREATE TABLE recepcionista (
    cedula INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono INT NOT NULL);

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL);

CREATE TABLE contrasenia (
    id INT NOT NULL,
    digito VARCHAR(50) NOT NULL,
    UNIQUE(id),
    FOREIGN KEY (id) REFERENCES recepcionista(cedula));

CREATE TABLE retiro (
    id_retirante INT NOT NULL,
    fecha TIMESTAMP NOT NULL,
    descripcion TEXT NOT NULL,
    monto INT NOT NULL,
    id_recepcionista INT NOT NULL,
    FOREIGN KEY (id_retirante) REFERENCES retirante(id),
    FOREIGN KEY (id_recepcionista) REFERENCES recepcionista(cedula));

CREATE TABLE ingreso_producto (
    id_producto INT NOT NULL,
    id_huesped INT NOT NULL,
    id_recepcionista INT NOT NULL,
    fecha TIMESTAMP NOT NULL,
    cantidad INT NOT NULL,
    monto INT NOT NULL,
    metodo_pago ENUM('efectivo','transaccion','tarjeta','qr') NOT NULL DEFAULT 'efectivo',
    FOREIGN KEY (id_producto) REFERENCES producto(id),
    FOREIGN KEY (id_huesped) REFERENCES huesped(cedula),
    FOREIGN KEY (id_recepcionista) REFERENCES recepcionista(cedula));

CREATE TABLE ingreso_hospedaje (
    id_hospedaje INT NOT NULL,
    fecha TIMESTAMP NOT NULL,
    metodo_pago ENUM('efectivo','transaccion','tarjeta','qr') NOT NULL DEFAULT 'efectivo',
    monto INT NOT NULL,
    id_recepcionista INT NOT NULL,
    FOREIGN KEY (id_hospedaje) REFERENCES hospedaje(id),
    FOREIGN KEY (id_recepcionista) REFERENCES recepcionista(cedula));

CREATE TABLE base (
    fecha TIMESTAMP NOT NULL,
    saldo INT NOT NULL);
