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

CREATE TABLE [Proveedor] (
  [id_proveedor] int PRIMARY KEY,
  [nombre] nvarchar(80),
  [telefono] nvarchar(8),
  [direccion] nvarchar(255)
)
GO

CREATE TABLE [Cliente] (
  [DNI] int PRIMARY KEY,
  [nombre] nvarchar(80),
  [apellido] nvarchar(80),
  [direccion] nvarchar(255),
  [correo] nvarchar(255),
  [telefono] nvarchar(8)
)
GO

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
