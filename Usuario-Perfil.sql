CREATE TABLE public.usuario (
	id_usuario serial NOT NULL,
	rut varchar(50) NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido_paterno varchar(50) NOT NULL,
	apellido_materno varchar(50) NOT NULL,
	usuario varchar(200) NOT NULL,
	pass varchar(200) null,
	primary key (id_usuario)
);



CREATE TABLE public.perfil (
	id_perfil serial NOT NULL,
	nombre varchar(100) NOT NULL,
	descripcion varchar(200) NULL,
	primary key (id_perfil)
);

CREATE TABLE public.usuario_perfil (
	id_usuario_perfil serial NOT NULL,
	id_usuario smallint NOT NULL,
	id_perfil smallint NULL,
	primary key (id_usuario_perfil)
);


alter table usuario_perfil
   add constraint fk_usuario
   foreign key (id_usuario)
   references usuario(id_usuario);
  
alter table usuario_perfil
   add constraint fk_perfil
   foreign key (id_perfil)
   references perfil(id_perfil);

CREATE TABLE public.aplicacion (
	id_aplicacion serial NOT NULL,
	url varchar(200) NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(50) NOT NULL,
	icono varchar(50) NOT NULL,
	color varchar(50) NOT NULL,
	primary key (id_aplicacion)
);
