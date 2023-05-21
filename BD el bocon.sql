USE MASTER
CREATE DATABASE DB_ELBOCON
GO
USE DB_ELBOCON


CREATE TABLE [Producto] (
  [id_producto] int PRIMARY KEY,
  [nombre] nvarchar(255),
  [cantidad] int,
  [precio] decimal(10,2),
  [descripcion] nvarchar(255),
  [id_proveedor] int,
  [id_marca] int,
  [id_categoria] int,
  [porcentaje_alcohol] decimal(5,2)
)
GO

-- Procedimiento para INSERTAR un registro en la tabla Producto
CREATE PROCEDURE InsertarProducto
  @id_producto int,
  @nombre nvarchar(255),
  @cantidad int,
  @precio decimal(10,2),
  @descripcion nvarchar(255),
  @id_proveedor int,
  @id_marca int,
  @id_categoria int,
  @porcentaje_alcohol decimal(5,2)
AS
BEGIN
  INSERT INTO Producto (id_producto, nombre, cantidad, precio, descripcion, id_proveedor, id_marca, id_categoria, porcentaje_alcohol)
  VALUES (@id_producto, @nombre, @cantidad, @precio, @descripcion, @id_proveedor, @id_marca, @id_categoria, @porcentaje_alcohol)
END
GO

-- Ejemplo de ejecución del procedimiento InsertarProducto
EXEC InsertarProducto 1, 'Producto 1', 10, 9.99, 'Descripción del Producto 1', 1, 1, 1, 0.05
EXEC InsertarProducto 2, 'Producto 2', 5, 19.99, 'Descripción del Producto 2', 2, 2, 2, 0.10
EXEC InsertarProducto 3, 'Producto 3', 3, 14.99, 'Descripción del Producto 3', 3, 1, 2, 0.08
GO
-- Procedimiento para ACTUALIZAR un registro en la tabla Producto

CREATE PROCEDURE ActualizarProducto
  @id_producto int,
  @nombre nvarchar(255),
  @cantidad int,
  @precio decimal(10,2),
  @descripcion nvarchar(255),
  @id_proveedor int,
  @id_marca int,
  @id_categoria int,
  @porcentaje_alcohol decimal(5,2)
AS
BEGIN
  UPDATE Producto
  SET nombre = @nombre, cantidad = @cantidad, precio = @precio, descripcion = @descripcion, id_proveedor = @id_proveedor, id_marca = @id_marca, id_categoria = @id_categoria, porcentaje_alcohol = @porcentaje_alcohol
  WHERE id_producto = @id_producto
END
GO

-- Ejemplo de ejecución del procedimiento sp_ActualizarProducto
EXEC ActualizarProducto 1, 'Producto 1 Actualizado', 20, 14.99, 'Nueva descripción del Producto 1', 1, 2, 1, 0.07
EXEC ActualizarProducto 2, 'Producto 2', 8, 24.99, 'Descripción del Producto 2', 2, 1, 2, 0.12
EXEC ActualizarProducto 3, 'Producto 3 Actualizado', 5, 19.99, 'Nueva descripción del Producto 3', 3, 2, 2, 0.10
GO
-- Procedimiento para ELIMINAR un registro en la tabla Producto
CREATE PROCEDURE EliminarProducto
  @id_producto int
AS
BEGIN
  DELETE FROM Producto
  WHERE id_producto = @id_producto
END
GO

-- Ejemplo de ejecución del procedimiento EliminarProducto
EXEC EliminarProducto 1
EXEC EliminarProducto 2
EXEC EliminarProducto 3

CREATE TABLE [Proveedor] (
  [id_proveedor] int PRIMARY KEY,
  [nombre] nvarchar(80),
  [telefono] nvarchar(8),
  [direccion] nvarchar(255)
)
GO
-- Procedimiento para INSERTAR un registro en la tabla Proveedor
CREATE PROCEDURE InsertarProveedor
  @id_proveedor int,
  @nombre nvarchar(80),
  @telefono nvarchar(8),
  @direccion nvarchar(255)
AS
BEGIN
  INSERT INTO Proveedor (id_proveedor, nombre, telefono, direccion)
  VALUES (@id_proveedor, @nombre, @telefono, @direccion)
END
GO

-- Ejemplo de ejecución del procedimiento InsertarProveedor
EXEC InsertarProveedor 1, 'Proveedor 1', '11111111', 'Calle 123'
EXEC InsertarProveedor 2, 'Proveedor 2', '22222222', 'Avenida 456'
EXEC InsertarProveedor 3, 'Proveedor 3', '33333333', 'Boulevard 789'

GO
-- Procedimiento para ACTUALIZAR un registro en la tabla Proveedor
CREATE PROCEDURE ActualizarProveedor
  @id_proveedor int,
  @nombre nvarchar(80),
  @telefono nvarchar(8),
  @direccion nvarchar(255)
AS
BEGIN
  UPDATE Proveedor
  SET nombre = @nombre, telefono = @telefono, direccion = @direccion
  WHERE id_proveedor = @id_proveedor
END
GO

-- Ejemplo de ejecución del procedimiento ActualizarProveedor
EXEC ActualizarProveedor 1, 'Proveedor 1 Actualizado', '11111111', 'Calle 456'
EXEC ActualizarProveedor 2, 'Proveedor 2', '22222222', 'Avenida 789'
EXEC ActualizarProveedor 3, 'Proveedor 3 Actualizado', '33333333', 'Boulevard 123'

GO

-- Procedimiento para ELIMINAR un registro en la tabla Proveedor
CREATE PROCEDURE EliminarProveedor
  @id_proveedor int
AS
BEGIN
  DELETE FROM Proveedor
  WHERE id_proveedor = @id_proveedor
END
GO

-- Ejemplo de ejecución del procedimiento EliminarProveedor
EXEC EliminarProveedor 1
EXEC EliminarProveedor 2
EXEC EliminarProveedor 3


CREATE TABLE [Cliente] (
  [DNI] int PRIMARY KEY,
  [nombre] nvarchar(80),
  [apellido] nvarchar(80),
  [direccion] nvarchar(255),
  [correo] nvarchar(255),
  [telefono] nvarchar(8)
)
GO
-- Procedimiento para INSERTAR un registro en la tabla Cliente
CREATE PROCEDURE InsertarCliente
  @DNI int,
  @nombre nvarchar(80),
  @apellido nvarchar(80),
  @direccion nvarchar(255),
  @correo nvarchar(255),
  @telefono nvarchar(8)
AS
BEGIN
  INSERT INTO Cliente (DNI, nombre, apellido, direccion, correo, telefono)
  VALUES (@DNI, @nombre, @apellido, @direccion, @correo, @telefono)
END
GO

-- Ejemplo de ejecución del procedimiento InsertarCliente
EXEC InsertarCliente 12345678, 'Cliente 1', 'Apellido 1', 'Calle 123', 'cliente1@example.com', '11111111'
EXEC InsertarCliente 87654321, 'Cliente 2', 'Apellido 2', 'Avenida 456', 'cliente2@example.com', '22222222'
EXEC InsertarCliente 98765432, 'Cliente 3', 'Apellido 3', 'Boulevard 789', 'cliente3@example.com', '33333333'

GO
-- Procedimiento para ACTUALIZAR un registro en la tabla Cliente
CREATE PROCEDURE ActualizarCliente
  @DNI int,
  @nombre nvarchar(80),
  @apellido nvarchar(80),
  @direccion nvarchar(255),
  @correo nvarchar(255),
  @telefono nvarchar(8)
AS
BEGIN
  UPDATE Cliente
  SET nombre = @nombre, apellido = @apellido, direccion = @direccion, correo = @correo, telefono = @telefono
  WHERE DNI = @DNI
END
GO

-- Ejemplo de ejecución del procedimiento ActualizarCliente
EXEC ActualizarCliente 12345678, 'Cliente 1 Actualizado', 'Apellido 1', 'Calle 456', 'cliente1@example.com', '11111111'
EXEC ActualizarCliente 87654321, 'Cliente 2', 'Apellido 2 Actualizado', 'Avenida 789', 'cliente2@example.com', '22222222'
EXEC ActualizarCliente 98765432, 'Cliente 3 Actualizado', 'Apellido 3', 'Boulevard 123', 'cliente3@example.com', '33333333'

GO
-- Procedimiento para ELIMINAR un registro en la tabla Cliente
CREATE PROCEDURE EliminarCliente
  @DNI int
AS
BEGIN
  DELETE FROM Cliente
  WHERE DNI = @DNI
END
GO

-- Ejemplo de ejecución del procedimiento EliminarCliente
EXEC EliminarCliente 12345678
EXEC EliminarCliente 87654321
EXEC EliminarCliente 98765432

CREATE TABLE [Empleado] (
  [id_empleado] int PRIMARY KEY,
  [nombre] nvarchar(80),
  [apellido] nvarchar(80),
  [telefono] nvarchar(255),
  [direccion] nvarchar(255)
)
GO

CREATE TABLE [Marca] (
  [id_marca] int PRIMARY KEY,
  [nombre] nvarchar(255)
)
GO

CREATE TABLE [Categoria] (
  [id_categoria] int PRIMARY KEY,
  [nombre] nvarchar(80),
  [tipo_de_alcohol] nvarchar(255),
  [tipo_de_producto] nvarchar(255)
)
GO

CREATE TABLE [Facturacion] (
  [id_facturacion] int PRIMARY KEY,
  [fecha] date,
  [DNI] int,
  [id_empleado] int
)
GO
CREATE PROCEDURE InsertarFacturacion
  @id_facturacion int,
  @fecha date,
  @DNI int,
  @id_empleado int
AS
BEGIN
  INSERT INTO Facturacion (id_facturacion, fecha, DNI, id_empleado)
  VALUES (@id_facturacion, @fecha, @DNI, @id_empleado)
END
GO

-- Ejemplo de ejecución del procedimiento InsertarFacturacion
EXEC InsertarFacturacion 1, '2023-01-01', 12345678, 1
EXEC InsertarFacturacion 2, '2023-02-01', 87654321, 2
EXEC InsertarFacturacion 3, '2023-03-01', 98765432, 3

GO

-- Procedimiento para ACTUALIZAR un registro en la tabla Facturacion
CREATE PROCEDURE ActualizarFacturacion
  @id_facturacion int,
  @fecha date,
  @DNI int,
  @id_empleado int
AS
BEGIN
  UPDATE Facturacion
  SET fecha = @fecha, DNI = @DNI, id_empleado = @id_empleado
  WHERE id_facturacion = @id_facturacion
END
GO

-- Ejemplo de ejecución del procedimiento ActualizarFacturacion
EXEC ActualizarFacturacion 1, '2023-01-05', 12345678, 1
EXEC ActualizarFacturacion 2, '2023-02-10', 87654321, 2
EXEC ActualizarFacturacion 3, '2023-03-15', 98765432, 3

GO

-- Procedimiento para ELIMINAR un registro en la tabla Facturacion
CREATE PROCEDURE EliminarFacturacion
  @id_facturacion int
AS
BEGIN
  DELETE FROM Facturacion
  WHERE id_facturacion = @id_facturacion
END
GO

-- Ejemplo de ejecución del procedimiento EliminarFacturacion
EXEC EliminarFacturacion 1
EXEC EliminarFacturacion 2
EXEC EliminarFacturacion 3
CREATE TABLE [DetalleFacturacion] (
  [id_producto] int,
  [id_facturacion] int,
  [cantidad] int
)
GO

ALTER TABLE [Producto] ADD FOREIGN KEY ([id_proveedor]) REFERENCES [Proveedor] ([id_proveedor])
GO

ALTER TABLE [Producto] ADD FOREIGN KEY ([id_marca]) REFERENCES [Marca] ([id_marca])
GO

ALTER TABLE [Producto] ADD FOREIGN KEY ([id_categoria]) REFERENCES [Categoria] ([id_categoria])
GO

ALTER TABLE [Facturacion] ADD FOREIGN KEY ([DNI]) REFERENCES [Cliente] ([DNI])
GO

ALTER TABLE [Facturacion] ADD FOREIGN KEY ([id_empleado]) REFERENCES [Empleado] ([id_empleado])
GO

ALTER TABLE [DetalleFacturacion] ADD FOREIGN KEY ([id_producto]) REFERENCES [Producto] ([id_producto])
GO

ALTER TABLE [DetalleFacturacion] ADD FOREIGN KEY ([id_facturacion]) REFERENCES [Facturacion] ([id_facturacion])
GO
