CREATE database db_yupi;
use db_yupi;

CREATE TABLE usuario (
	id_usuario int auto_increment primary key,
    id_rol int not null,
    username varchar(100) not null,
    password varchar(100) not null,
    foreign key (id_rol)
    references rol(id_rol));
    
CREATE TABLE rol (
	id_rol int auto_increment primary key,
    nombre varchar(100) not null,
    categoria enum('Administrador','Recepcionista') not null );

CREATE TABLE cliente (
	id_cliente int auto_increment PRIMARY KEY,
    nombre VARCHAR(100) not null,
    apellido VARCHAR(100) not null,
    email VARCHAR(100) UNIQUE not null,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    telefono int not null,
    direccion VARCHAR(100) not null,
    dni VARCHAR(8) not null);

CREATE TABLE nino (
	id_nino int auto_increment PRIMARY KEY,
    id_cliente int not null,
    nombres varchar(100) not null,
    fecha_nacimiento DATE,
    alergias VARCHAR(255),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente));
    
CREATE TABLE visita (
	id_visita int auto_increment PRIMARY KEY,
    id_nino int not null,
    fecha DATE not null,
    hora_ingreso DATETIME not null,
    hora_salida DATETIME,
    tiempo_contratado int not null,
    estado enum('Activa', 'Finalizada') not null,
    foreign key (id_nino) references nino(id_nino));
    
CREATE TABLE reserva (
	id_reserva int auto_increment primary key,
    id_cliente int not null,
    fecha_evento date not null,
    cantidad_ninos int not null,
    estado enum('Pendiente', 
    'Confirmada', 
    'Cancelada', 
    ' Finalizada') not null default 'Pendiente',
    hora_inicio time,
    hora_fin time,
    monto_total decimal(10,2),
    foreign key (id_cliente) 
    references cliente(id_cliente));
        
CREATE TABLE evento (
	id_evento int auto_increment primary key,
    id_reserva int not null,
    nombre_evento varchar(100) not null,
    fecha date,
    hora_inicio time not null,
    hora_fin time not null,
    foreign key(id_reserva)
    references reserva(id_reserva) );
    
CREATE TABLE cotizacion (
	id_cotizacion int auto_increment primary key,
    id_cliente int not null,
    id_evento int not null,
    fecha date not null,
    monto_total decimal(10,2) not null,
    estado enum('Cotizado','No cotizado'),
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_evento) references evento(id_evento));
    
CREATE TABLE pagoVisita (
	id_pago_visita int auto_increment primary key,
    id_visita int not null,
    monto decimal(10,2) not null,
    fecha_pago datetime not null,
    metodo_pago enum('Efectivo', 'Yape','Plin','Tarjeta') NOT NULL,
    foreign key(id_visita) references visita(id_visita)
    );

CREATE TABLE pagoEvento (
	id_pago_evento int auto_increment primary key,
    id_evento int not null,
    monto decimal(10,2) not null,
    fecha_pago datetime not null,
    metodo_pago enum('Efectivo', 'Yape','Plin','Tarjeta') NOT NULL,
	foreign key (id_evento) references evento(id_evento)
    );
    
    


    

    
