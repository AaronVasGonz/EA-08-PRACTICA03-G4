
create SCHEMA practica ;

 use practica;
/*Se crea un usuario para la base de datos llamado "usuario_practica" y tiene la contraseña "la_Clave."*/
create user 'usuario_practica'@'%' identified by 'la_Clave';

/*Se asignan los prvilegios sobr ela base de datos Practica al usuario creado */
grant all privileges on practica.* to 'usuario_practica'@'%';
flush privileges;


Create TABLE arbol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_comun varchar(50),
    tipo_flor varchar(100),
    dureza_madera varchar(50),
    color_flor varchar(50),
    activo bool,
    ruta_Imagen varchar(1024)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


Select *from arbol
