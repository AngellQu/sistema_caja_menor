CREATE PROCEDURE contrasenia_correcta(IN correo VARCHAR(50), IN digito INT)
BEGIN
    DECLARE resultado int;
    SET resultado = (SELECT COUNT(*)
                     FROM recepcionista r
                     JOIN contrasenia c ON r.cedula = c.id
                     WHERE r.correo = correo AND c.digito = digito);
    IF resultado = 1 
    THEN
        SELECT 'true' AS resultado_final;
    ELSE
        SELECT 'false' AS resultado_final;
    END IF;
END;

CREATE PROCEDURE establecer_base(monto int, fecha date)
BEGIN 
	DELETE FROM ingreso_hospedaje;
    DELETE FROM ingreso_producto;
    DELETE FROM retiro;
    INSERT INTO base VALUES (fecha, monto);
END;

CREATE FUNCTION  calcular_saldo()
RETURNS int
READ SQL DATA 
BEGIN
	DECLARE resultado int;

    SET resultado = (COALESCE ((SELECT sum(monto) FROM ingreso_hospedaje), 0) + 
                     COALESCE ((SELECT sum(monto) FROM ingreso_producto), 0) +
                    (SELECT saldo FROM base ORDER BY fecha DESC LIMIT 1) -
                     COALESCE ((SELECT sum(monto) FROM retiro), 0));
    RETURN resultado;
END;

CREATE PROCEDURE insertar_ingreso_hospedaje(metodo varchar(20),monto int, id_recepcionista int)
BEGIN
	DECLARE saldo int;
    DECLARE id_hospedaje int;
   
    SET id_hospedaje = (SELECT max(id) FROM hospedaje);

    INSERT INTO ingreso_hospedaje 
    VALUES (id_hospedaje, now(), metodo, monto, id_recepcionista);
   
    SET saldo = (SELECT calcular_saldo()); 
   
    SELECT saldo;
END;

CREATE PROCEDURE insertar_ingreso_producto(nombre varchar(100), cantidad int, metodo_pago varchar(50), id_recepcionista int, id_huesped int)
BEGIN
	DECLARE saldo int;
    DECLARE id_producto int;
    DECLARE monto int;
   
    SET id_producto = (SELECT id FROM producto p WHERE p.nombre = nombre);
    SET monto = (SELECT precio FROM producto p WHERE p.id = id_producto) * cantidad;
   
    INSERT INTO ingreso_producto (id_producto, id_huesped, id_recepcionista,fecha, cantidad, monto, metodo_pago)
    VALUES (id_producto, id_huesped, id_recepcionista, now(), cantidad, monto, metodo_pago);
   
    SET saldo = (SELECT calcular_saldo());
    SELECT saldo;
END;

CREATE PROCEDURE insertar_retiro(id_retirante int, id_recepcionista int, descripcion text,  monto int)
BEGIN
	DECLARE saldo int;

	INSERT INTO retiro(id_retirante, id_recepcionista, fecha, descripcion, monto)
	VALUES (id_retirante, id_recepcionista, now(), descripcion, monto);
    
    SET saldo = (SELECT calcular_saldo());
    SELECT saldo;
END;

CREATE PROCEDURE registrar_usuario(cedula int, nombre varchar(100), correo varchar(100), direccion varchar(100), telefono int, digito varchar(100))
BEGIN
	INSERT INTO recepcionista VALUES(cedula, nombre, correo, direccion, telefono);
	INSERT INTO contrasenia VALUES (cedula, digito);
END;

CREATE PROCEDURE eliminar_ingreso_producto(id_usuario int)
BEGIN
	IF id_usuario = (SELECT id_recepcionista FROM ingreso_producto ORDER BY fecha DESC LIMIT 1);
    THEN
      DELETE FROM ingreso_producto ORDER BY fecha DESC LIMIT 1;
      SELECT calcular_saldo() AS saldo;
    ELSE
      SELECT 'false' AS resultado;
    END IF;
END;

CREATE PROCEDURE eliminar_ingreso_hospedaje(id_usuario int)
BEGIN
	IF id_usuario = (SELECT id_recepcionista FROM ingreso_hospedaje ORDER BY fecha DESC LIMIT 1);
    THEN
      DELETE FROM ingreso_hospedaje ORDER BY fecha DESC LIMIT 1;
      SELECT calcular_saldo() AS saldo;
    ELSE
      SELECT 'false' AS resultado;
	END IF;
END;

CREATE PROCEDURE eliminar_retiro(id_usuario int)
BEGIN
	IF id_usuario = (SELECT id_recepcionista FROM retiro ORDER BY fecha DESC LIMIT 1);
    THEN
      DELETE FROM retiro ORDER BY fecha DESC LIMIT 1;
      SELECT calcular_saldo() AS saldo;
    ELSE
      SELECT 'false' AS resultado;
	END IF;
END;










 




