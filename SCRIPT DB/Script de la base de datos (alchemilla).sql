CREATE SCHEMA IF NOT EXISTS gestionhospital;	

USE gestionhospital;	

CREATE TABLE IF NOT EXISTS administrador(
id_admin VARCHAR(25) NOT NULL UNIQUE,
dpi INT NOT NULL UNIQUE CHECK(dpi>0),
nombre VARCHAR(45) NOT NULL UNIQUE,
passw VARCHAR(16),
PRIMARY KEY(dpi,nombre)
);

CREATE TABLE IF NOT EXISTS usuario(
nombre VARCHAR(45) NOT NULL,
passw VARCHAR(16) NOT NULL,
email VARCHAR(30) NOT NULL,
PRIMARY KEY(email)
);

CREATE TABLE IF NOT EXISTS paciente(
id_paciente INT NOT NULL CHECK(id_paciente>0) ,
nombre VARCHAR(45) NOT NULL,
sexo VARCHAR(8) NOT NULL,
fecha_nacimiento DATE NOT NULL,
dpi INT(13) NOT NULL UNIQUE CHECK (dpi>0) ,
telefono VARCHAR(12) NOT NULL,
peso FLOAT NOT NULL CHECK(peso>0),
tipo_de_sangre VARCHAR(7) NOT NULL,
email VARCHAR(25) NOT NULL UNIQUE,
passw VARCHAR(15),
PRIMARY KEY (id_paciente, nombre)
);

CREATE TABLE IF NOT EXISTS medico(
id_medico VARCHAR(45) NOT NULL ,
nombre VARCHAR(25) NOT NULL,
numero_colegiado INT NOT NULL UNIQUE CHECK(numero_colegiado > 0),
dpi INT(13) NOT NULL UNIQUE CHECK(dpi>0),
telefono VARCHAR(12) NOT NULL,
especialidad VARCHAR (40) NOT NULL,
email VARCHAR(25) NOT NULL,
horario_atencion_inicio TIME NOT NULL,
horario_atencion_final TIME NOT NULL,
fecha_inicio DATE NOT NULL,
pass VARCHAR(16),
PRIMARY KEY (id_medico, nombre)
);

CREATE TABLE IF NOT EXISTS examen(
codigo_examen INT UNIQUE NOT NULL,
nombre_examen VARCHAR(35) UNIQUE NOT NULL,
orden VARCHAR(5) NOT NULL,
descricion VARCHAR(250) NOT NULL,
costo FLOAT NOT NULL,
informe VARCHAR(3) NOT NULL,
PRIMARY KEY (codigo_examen)
);

CREATE TABLE IF NOT EXISTS informe(
codigo_informe INT NOT NULL,
paciente INT NOT NULL,
medico VARCHAR(45) NOT NULL,
informe VARCHAR(450) NOT NULL,
fecha DATE NOT NULL,
hora TIME,
PRIMARY KEY (codigo_informe),
KEY FK_PACIENTE_INFORME (paciente),
KEY FK_MEDICO_INFORME(medico),
CONSTRAINT FK_PACIENTE_INFORME FOREIGN KEY (paciente) REFERENCES paciente (id_paciente),
CONSTRAINT FK_MEDICO_INFORME FOREIGN KEY (medico) REFERENCES medico(id_medico)
);


CREATE TABLE IF NOT EXISTS laboratorista(
id_laboratorista VARCHAR(15) NOT NULL ,
nombre VARCHAR(25) NOT NULL,
registro_ministerio VARCHAR(25) NOT NULL UNIQUE,
dpi VARCHAR(25) NOT NULL UNIQUE CHECK (dpi>0),
telefono VARCHAR(12) NOT NULL,
examen VARCHAR(30),
email VARCHAR(25) NOT NULL UNIQUE,
dias_labura VARCHAR(30) NOT NULL,
passw VARCHAR(16),
fecha_inicio VARCHAR(25) NOT NULL,
PRIMARY KEY (id_laboratorista, nombre)
);

CREATE TABLE IF NOT EXISTS resultado(
codigo_resultado INT NOT NULL,
paciente INT NOT NULL,
medico VARCHAR(45) NOT NULL,
codigo_examen INT NOT NULL,
id_laboratorista VARCHAR(15) NOT NULL,
orden VARCHAR(45),
informe VARCHAR(45),
fecha DATE NOT NULL,
hora TIME NOT NULL,
PRIMARY KEY (codigo_resultado),
KEY FK_PACIENTE_RESULTADO (paciente),
KEY FK_MEDICO_RESULTADO (medico),
KEY FK_CODIGO_EXAMEN_RESULTADO (codigo_examen),
KEY FK_LABORATORISTA_RESULTADO(id_laboratorista),
CONSTRAINT FK_PACIENTE_RESULTADO FOREIGN KEY (paciente) REFERENCES paciente (id_paciente),
CONSTRAINT FK_MEDICO_RESULTADO FOREIGN KEY (medico) REFERENCES medico (id_medico),
CONSTRAINT FK_CODIGO_EXAMEN_RESULTADO FOREIGN KEY (codigo_examen) REFERENCES examen (codigo_examen),
CONSTRAINT FK_LABORATORISTA_RESULTADO FOREIGN KEY (id_laboratorista) REFERENCES laboratorista (id_laboratorista)
);

CREATE TABLE IF NOT EXISTS consulta(
tipo_de_consulta VARCHAR(50) NOT NULL ,
costo FLOAT NOT NULL,
PRIMARY KEY (tipo_de_consulta)
);

CREATE TABLE IF NOT EXISTS cita(
indice INT UNSIGNED AUTO_INCREMENT,
codigo_cita INT UNIQUE,
id_paciente INT NOT NULL,
id_medico VARCHAR(45) NOT NULL,
tipo_de_consulta VARCHAR (50) NOT NULL,
fecha DATE NOT NULL,
hora TIME NOT NULL,
PRIMARY KEY (indice),
KEY FK_ID_PACIENTE_CITA (id_paciente),
KEY FK_ID_MEDICO_CITA (id_medico),
KEY FK_TIPO_DE_CONSULTA (tipo_de_consulta),
CONSTRAINT FK_ID_PACIENTE_CITA FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
CONSTRAINT FK_ID_MEDICO_CITA FOREIGN KEY (id_medico) REFERENCES medico (id_medico),
CONSTRAINT FK_TIPO_DE_CONSULTA FOREIGN KEY (tipo_de_consulta) REFERENCES consulta (tipo_de_consulta)
);

CREATE TABLE IF NOT EXISTS cita_laboratorio(
id_citalab INT NOT NULL,
id_paciente INT NOT NULL,
id_laboratorista VARCHAR(45) UNIQUE,
codigo_examen INT NOT NULL,
nombre_examen VARCHAR(35) NOT NULL,
orden VARCHAR(45),
fecha_examen DATE NOT NULL,
hora_examen TIME NOT NULL,
costo_examen FLOAT NOT NULL,
informe VARCHAR (45),
PRIMARY KEY (id_citalab),
KEY FK_PACIENTE_LAB (id_paciente),
KEY FK_LABORATORISTA(id_laboratorista),
KEY FK_CODIGOX (codigo_examen),
KEY FK_NOMBREX_LAB(nombre_examen),
CONSTRAINT FK_PACIENTE_LAB FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
CONSTRAINT FK_LABORATORISTA FOREIGN KEY (id_laboratorista) REFERENCES laboratorista (id_laboratorista),
CONSTRAINT FK_CODIGOX FOREIGN KEY (codigo_examen) REFERENCES examen (codigo_examen),
CONSTRAINT FK_NOMBREX FOREIGN KEY (nombre_examen) REFERENCES examen (nombre_examen)
);


/*CREATE TABLE IF NOT EXISTS historial_medico(
id_paciente INT NOT NULL,
nombre_paciente VARCHAR(25),
cita_asistida VARCHAR(25),
medico_que_atendio VARCHAR(25),
examen_realizado VARCHAR(25),
PRIMARY KEY (id_paciente),
KEY FK_PACIENTE_HISTORIAL (id_paciente),
CONSTRAINT FK_PACIENTE_HISTORIAL FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente)
);*/




/*CREATE TABLE IF NOT EXISTS cita_laboratorio(
id_cita INT NOT NULL,
fecha_examen VARCHAR(25) NOT NULL,
hora_examen VARCHAR(25) NOT NULL,
estado VARCHAR(25) NOT NULL,
id_examen INT NOT NULL,
id_laboratorista INT NOT NULL,
id_paciente INT NOT NULL,
PRIMARY KEY (id_cita),
KEY FK_EXAMEN_LAB (id_examen),
KEY FK_LABORATORISTA (id_laboratorista),
KEY FK_PACIENTE_LAB (id_paciente),
CONSTRAINT FK_EXAMEN_LAB FOREIGN KEY (id_examen) REFERENCES examen (id_examen),
CONSTRAINT FK_LABORATORISTA FOREIGN KEY (id_laboratorista) REFERENCES laboratorista (id_laboratorista),
CONSTRAINT FK_PACIENTE_LAB FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente)
);*/
						
