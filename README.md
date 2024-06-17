
# El Caserio (HackaJava)

## Decripción del proyecto ##

Proyecto realizado para el HackaJava organizado por Nico Salgado para los estudiantes de su Bootcamp. 

El proyecto fue realizado en aproxidamadamente 1 mes y medio, aplicando los conocimientos base obtenidos en el curso, mas las herramientas extra que creyeramos necesarias.

Para nuestro proyecto, tomamos a El Caserio, que es un restaurante localizado en España, y nos centramos en realizar una aplicacion para que los clientes del restaurante pudieran realizar los pedidios desde la aplicacion y que el restaurante pudiera administras sus pedidios. 

Decidimos que era mejor enfocar el proyecto a un negocion real para resolver problemas y necesidades reales.

## Versiones de las tecnologias utilizadas ##

Version de Node utilizada: v18.20.2 LTS  
  https://nodejs.org/en/download/prebuilt-installer

Version de Angular utilizada CLI: 16.2.12
  Para revisar la version actual (en PowerShell):
    
    ng version 

  (Si es que no cuentas con Angular, uliliza el siguiente comando de instalacion en la lista)

  Para desinstalar la version actual si no es la 16.2.12 (en PowerShell):

    npm uninstall -g @angular/cli 

  Para instalar una version especifica (en PowerShell):
    
    npm install -g @angular/cli@16.2.12

Instalar la biblioteca para la paginación del menú dentro de la aplicacion.

  ```bash
  npm install ngx-pagination
  ```

Version del JDK Java 22
  https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html


## Iniciar el FrontEnd ##

Despues de clonar el repositorio, ejecutar el comando:

```bash
  \HackaJava\FrontEnd\el-caserio>
  npm install
```
 Esto en la carpeta de "el-caserio" de la carpeta "FrotEnd".

Para ejecutar el FrontEnd usamos el comando:

```bash
  ng serve -o
```
  
## Iniciar el BackEnd ##

Abrir la carpeta de 'elCaserio' en tu IDE con la direccion

```bash
  \HackaJava\BackEnd\elCaserio
```

**Seleccionar el JDK 22

Despues de que se instalen las dependencias, modificar el archivo de "application.properties" que esta en la carpeta "\HackaJava\BackEnd\elCaserio\src\main\resources" y colocar el usuario y contraseña de tu base de datos local.

(Es necesario contar con un gestor de base de datos, ya sea de MySQL o PostgreSQL)
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/el_caserio?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
```
  
Ejecutar la clase de "ElCaserioApplication", esto devería de iniciar el servidor de Tomcat en local.

### Agregar elementos a la Base de Datos

(Mientras la aplicacion del BackEnd este corriendo)

Utilizando Postmat, podemos agregar los alergenos y los productos con los siguientes JSON, con las siguientes direcciones:

- Para los alergenos:

Metodo (POST)

http://localhost:8080/el-caserio/alergeno 

```bash
{
  "nombre": "Nueces"
}

```

- Para los productos

Metodo (POST)

http://localhost:8080/el-caserio/producto

```bash
{
  "nombre": "La Yankee Burger",
  "categoria": "Hamburguesa",
  "subcategoria": "Especial",
  "descripcion": "Doble carne smash con queso cheddar y un toque de la salsa especial de la casa.",
  "listaAlergenos": [
                      {
                          "id": 1
                      },
                      {
                          "id": 2
                      }
                  ],
  "precio": 12.99
}

```

- Las categorias disponibles son las siguientes:

Hamburguesa, Entrantes, Combinados Especiales, Ensaladas, Sandwiches, Bocadillos, Perritos, Postres

(Agregar los alergenos antes de los productos, y ultilizar los id que estos generen)
