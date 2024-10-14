CREATE FUNCTION usuario_existencia(cedula varchar(20))
RETURNS boolean
READS SQL DATA
BEGIN
    IF 1 = (SELECT COUNT(*)
	    FROM recepcionista r
	    WHERE r.cedula = cedula)
    THEN
      RETURN TRUE;
    ELSE
      RETURN FALSE;
    END IF;
END;

CREATE PROCEDURE obtener_usuario_hash(IN cedula varchar(20))
BEGIN
    principal:
    BEGIN
        IF NOT (SELECT usuario_existencia(cedula))
        THEN
            SELECT 'false' AS resultado;
            LEAVE principal;
        ELSE
            SELECT contrasenia 
            FROM recepcionista r
            WHERE r.cedula = cedula;
        END IF;
    END principal;
END;

CREATE PROCEDURE establecer_base(monto int)
BEGIN
    DELETE FROM ingreso_hospedaje;
    DELETE FROM ingreso_producto;
    DELETE FROM retiro;
    INSERT INTO base VALUES (NOW(), monto);
    SELECT calcular_saldo AS saldo;
END;

CREATE FUNCTION  calcular_saldo()
RETURNS int
READS SQL DATA
BEGIN
    DECLARE resultado int;
    SET resultado = (COALESCE ((SELECT sum(monto) FROM ingreso_hospedaje WHERE metodo_pago = 'efectivo'), 0) +
                     COALESCE ((SELECT sum(monto) FROM ingreso_producto WHERE metodo_pago = 'efectivo'), 0) +
                    (SELECT saldo FROM base ORDER BY fecha DESC LIMIT 1) -
                     COALESCE ((SELECT sum(monto) FROM retiro), 0));
    RETURN resultado;
END;

CREATE PROCEDURE insertar_ingreso_hospedaje(id_hospedaje int,metodo_pago varchar(20),monto int, id_recepcionista varchar(20))
BEGIN
    INSERT INTO ingreso_hospedaje (id_hospedaje, fecha, metodo_pago, monto, id_recepcionista)
    VALUES (id_hospedaje, NOW(), metodo_pago, monto, id_recepcionista);

    SELECT calcular_saldo() AS saldo;
END;

CREATE PROCEDURE insertar_ingreso_producto(nombre varchar(100), cantidad int, metodo_pago varchar(50), id_recepcionista varchar(20), id_huesped int)
BEGIN
    DECLARE id_producto int;
    DECLARE monto int;

    SET id_producto = (SELECT id FROM producto p WHERE p.nombre = nombre);
    SET monto = (SELECT precio FROM producto p WHERE p.id = id_producto) * cantidad;

    INSERT INTO ingreso_producto (id_producto, id_huesped, id_recepcionista,fecha, cantidad, monto, metodo_pago)
    VALUES (id_producto, id_huesped, id_recepcionista, now(), cantidad, monto, metodo_pago);

    SELECT calcular_saldo() AS saldo;
END;

CREATE PROCEDURE insertar_retiro(id_retirante int, id_recepcionista varchar(20), descripcion text,  monto int)
BEGIN
    INSERT INTO retiro(id_retirante, id_recepcionista, fecha, descripcion, monto)
    VALUES (id_retirante, id_recepcionista, now(), descripcion, monto);

    SELECT calcular_saldo() AS saldo;
END;

CREATE PROCEDURE eliminar_ingreso_producto(id_usuario varchar(20))
BEGIN
    IF id_usuario = (SELECT id_recepcionista FROM ingreso_producto ORDER BY fecha DESC LIMIT 1)
    THEN
      DELETE FROM ingreso_producto ORDER BY fecha DESC LIMIT 1;
      SELECT calcular_saldo() AS saldo;
    ELSE
      SELECT 'false' AS resultado;
    END IF;
END;

CREATE PROCEDURE eliminar_ingreso_hospedaje(id_recepcionista varchar(20))
BEGIN
    IF id_recepcionista = (SELECT id_recepcionista FROM ingreso_hospedaje ORDER BY fecha DESC LIMIT 1)
    THEN
      DELETE FROM ingreso_hospedaje ORDER BY fecha DESC LIMIT 1;
      SELECT calcular_saldo() AS saldo;
    ELSE
      SELECT 'false' AS resultado;
    END IF;
END;

CREATE PROCEDURE eliminar_retiro(id_recepcionista varchar(20))
BEGIN
    IF id_recepcionista = (SELECT id_recepcionista FROM retiro ORDER BY fecha DESC LIMIT 1)
    THEN
      DELETE FROM retiro ORDER BY fecha DESC LIMIT 1;
      SELECT calcular_saldo() AS saldo;
    ELSE
      SELECT 'false' AS resultado;
    END IF;
END;

CREATE PROCEDURE actualizar_retirante(up_id varchar(30), up_nombre varchar(50), up_telefono varchar(10), up_direccion varchar(100))
BEGIN
	UPDATE retirante 
	SET 
	  nombre = COALESCE(up_nombre, nombre),
	  telefono = COALESCE(up_telefono, telefono),
	  direccion = COALESCE(up_direccion, direccion)
    WHERE id = up_id;
END;

CREATE PROCEDURE actualizar_recepcionista(up_cedula varchar(20), up_nombre varchar(100), up_correo varchar(100), up_telefono varchar(10), up_direccion varchar(100))
BEGIN
	UPDATE recepcionista
	SET
	  nombre = COALESCE(up_nombre, nombre),
	  correo = COALESCE(up_correo, correo),
	  telefono =  COALESCE(up_telefono, telefono),
	  direccion = COALESCE(up_direccion, direccion)
	WHERE cedula = up_cedula; 
END;

CREATE PROCEDURE actualizar_producto(up_id int, up_nombre varchar(50), up_precio int)
BEGIN
	UPDATE producto
	SET
	  nombre = COALESCE(up_nombre, nombre),
	  precio = COALESCE(up_precio, precio)
	WHERE id = up_id;
END;

CREATE PROCEDURE actualizar_huesped(up_cedula varchar(20), up_nombre varchar(100), up_telefono varchar(10))
BEGIN
	UPDATE huesped
	SET
	  nombre = COALESCE(up_nombre, nombre),
	  telefono = COALESCE(up_telefono, telefono)
	WHERE cedula  = up_cedula;
END;

CREATE PROCEDURE actualizar_hospedaje(up_id int, up_id_huesped varchar(20), up_habitacion int, up_fecha_ingreso timestamp, up_fecha_salida timestamp) 
BEGIN
	UPDATE hospedaje
	SET
	  id_huesped = COALESCE(up_id_huesped, id_huesped),
	  habitacion = COALESCE(up_habitacion, habitacion),
	  fecha_ingreso = COALESCE(up_fecha_ingreso, fecha_ingreso),
	  fecha_salida = COALESCE(up_fecha_salida, fecha_salida)
    WHERE id = up_id;
END;








 




