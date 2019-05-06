create DATABASE UPCRideDB;
use UPCRideDB;


CREATE TABLE Auto (
    placa varchar(20) not null,
    polizaSoat int not null,
    marca varchar(40) not null,
    modelo varchar(40) not null,
    limitePersonas int not null,
    codigoUsuario varchar(10) not null,
    CONSTRAINT Auto_pk PRIMARY KEY (placa)
);

CREATE TABLE Distrito (
    codigo int auto_increment not null,
    nombre varchar(50) not null,
    CONSTRAINT Distrito_pk PRIMARY KEY (codigo)
);
CREATE TABLE Viaje (
    codigo int auto_increment not null,
    codigoUsuarioConductor varchar(10) not null,
    descripcion varchar(500) not null,
    puntoPartida varchar(60) not null,
    puntoDestino varchar(60) not null,
    horaPartida time not null,
    horaLlegada time not null,
    entrada_salida bit not null,
    fechaViaje date not null,
    dia varchar(20) not null,
    estado varchar(60),
    visualizacionHabilitada bit,
    CONSTRAINT Viaje_pk PRIMARY KEY (codigo)
);




CREATE TABLE Itinerario (
    hora time not null,
    dia varchar(20) not null,
    codigoUsuario varchar(10) not null,
    entrada_salida bit not null,
    ubicacionPartida varchar(50) not null,
    ubicacionDestino varchar(50) not null,
    CONSTRAINT Itinerario_pk PRIMARY KEY (hora,dia)
);


CREATE TABLE Resena (
    codigo int auto_increment not null,
    contenido varchar(120) not null,
    valoracion decimal(6,2) not null,
    codigoCliente varchar(10) not null,
    codigoConductor varchar(10) not null,
    CONSTRAINT Resena_pk PRIMARY KEY (codigo)
);

DELETE FROM Resena where codigo>0;
CREATE TABLE Solicitud (
    codigo int auto_increment not null,
    codigoCliente varchar(10) not null,
    codigoViaje int not null,
    mensajeSolicitud varchar(120),
    confirmacionConductor bit not null,
    confirmacionCliente bit not null,
    puntoRecojo varchar(30) not null,
    CONSTRAINT Solicitud_pk PRIMARY KEY (codigo)
);


CREATE TABLE Usuario (
    codigo varchar(10) not null,
    email varchar(50) not null,
    contrasena varchar(40) not null,
    nombres varchar(60) not null,
    apellidos varchar(60) not null,
    ubicacion varchar(250) not null,
    facebookID varchar(60),
    telefono varchar(25),
    codigoDistrito int not null,
    rol int not null,
    licenciaConducir varchar(9) not null,
    
    CONSTRAINT Usuario_pk PRIMARY KEY (codigo)
);




ALTER TABLE Auto ADD CONSTRAINT Auto_Usuario FOREIGN KEY Auto_Usuario (codigoUsuario)
    REFERENCES Usuario (codigo);


ALTER TABLE Resena ADD CONSTRAINT Cliente_Resena FOREIGN KEY Cliente_Resena (codigoConductor)
    REFERENCES Usuario (codigo);


ALTER TABLE Resena ADD CONSTRAINT Conductor_Resena FOREIGN KEY Conductor_Resena (codigoCliente)
    REFERENCES Usuario (codigo);

ALTER TABLE Viaje ADD CONSTRAINT Copy_of_Publicacion_Publicitario FOREIGN KEY Copy_of_Publicacion_Publicitario (codigoUsuarioConductor)
    REFERENCES Usuario (codigo);


ALTER TABLE Itinerario ADD CONSTRAINT Itinerario FOREIGN KEY Itinerario (codigoUsuario)
    REFERENCES Usuario (codigo);


ALTER TABLE Usuario ADD CONSTRAINT Publicista_Distrito FOREIGN KEY Publicista_Distrito (codigoDistrito)
    REFERENCES Distrito (codigo);


ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_Usuario FOREIGN KEY Solicitud_Usuario (codigoCliente)
    REFERENCES Usuario (codigo);


ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_Viaje FOREIGN KEY Solicitud_Viaje (codigoViaje)
    REFERENCES Viaje (codigo);

insert into Distrito values(1,"San Miguel") ;
INSERT INTO Distrito VALUES(2, "Carabayllo");
insert into Distrito values(3,"Magdalena");
select * from Distrito;
INSERT INTO Usuario(codigo, email,contrasena,nombres,apellidos,ubicacion,facebookID,telefono,codigoDistrito,rol,licenciaConducir)
VALUES("U201710947","cesarpll@gmail.com","ABCabc123", "César Alejandro", "Pizarro Llanos","https://urlzs.com/MJhX", "https://www.facebook.com/", "999999999" , 3, 1, "1746293DC" );

select * from Viaje;
select * from Usuario;
SELECT u.codigo, u.nombres, d.nombre FROM Usuario u, Distrito d 
where u.codigoDistrito = d.codigoDistrito and u.rol = 1;

select * from Auto;
INSERT INTO Viaje(codigoUsuarioConductor,
    descripcion,
    puntoPartida,
    puntoDestino,
    horaPartida,
    horaLlegada,
    entrada_salida ,
    fechaViaje ,
    dia ,
    estado ,
    visualizacionHabilitada)
    Values("U201729445","Me ofrezco a llevar a 4 personas hasta la UPC de Monterrico",
    "Carabayllo", "UPC San Isidro", "9:00:00", "11:00:00", 0, "20190430", "martes", "Pendiente", 1);
    

SELECT * FROM Resena;

insert into Distrito values(1,"San Miguel") ;
INSERT INTO Distrito VALUES(2, "Carabayllo");
insert into Distrito values(3,"Magdalena");
insert into Distrito values(4,"Callao");

select * from Usuario;
select * from Distrito;
select * from usuario where codigo = 'u201710070' and contrasena = 'alessandrognr99';
INSERT INTO Usuario(codigo, email,contrasena,nombres,apellidos,ubicacion,facebookID,telefono,codigoDistrito,rol,licenciaConducir)
VALUES("U201710942","cesarpll@gmail.com","ABCabc123", "César Alejandro", "Pizarro Llanos","https://urlzs.com/MJhX", "https://www.facebook.com/", "999999999" , 3, 1, "1746293DC" );


