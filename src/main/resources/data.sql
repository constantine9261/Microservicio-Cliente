--UNA VEZ QUE CORRA EL PROYECTO COMENTAR PORFAVOR LOS INSERTS
INSERT INTO clientes (nombre, apellido, dni, email)
SELECT * FROM (VALUES
    ('Juan', 'Perez', '12345678', 'juan.perez@example.com'),
    ('Maria', 'Lopez', '87654321', 'maria.lopez@example.com'),
    ('Carlos', 'Gomez', '11223344', 'carlos.gomez@example.com')
) AS new_clientes(nombre, apellido, dni, email)
WHERE NOT EXISTS (
    SELECT 1 FROM clientes WHERE clientes.dni = new_clientes.dni
);
