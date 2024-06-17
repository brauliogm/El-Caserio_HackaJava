
# El Caserio (HackaJava)

## Descripción del proyecto ##

Proyecto realizado para el HackaJava organizado por Nico Salgado para los estudiantes de su Bootcamp.

El proyecto se desarrolló en aproximadamente un mes y medio, aplicando los conocimientos básicos obtenidos en el curso, además de las herramientas adicionales que consideráramos necesarias.

Para nuestro proyecto, tomamos a El Caserío, un restaurante ubicado en España, y nos enfocamos en crear una aplicación para que los clientes del restaurante pudieran realizar sus pedidos desde la aplicación, y para que el restaurante pudiera administrar estos pedidos.

Decidimos enfocar el proyecto en un negocio real para resolver problemas y necesidades reales.

## Versiones de las tecnologías utilizadas ##

Node.js
  Versión utilizada: v18.20.2 LTS
  https://nodejs.org/en/download/prebuilt-installer

Angular
  Versión utilizada CLI: 16.2.12
  Para revisar la versión actual (en PowerShell):
    
    ng version 

  (Si no cuentas con Angular, utiliza el siguiente comando de instalación en la lista)

  Para desinstalar la versión actual si no es la 16.2.12 (en PowerShell):

    npm uninstall -g @angular/cli 

  Para instalar una versión específica (en PowerShell):
    
    npm install -g @angular/cli@16.2.12

  Biblioteca para la paginación del menú dentro de la aplicación
  Instalar la biblioteca:

  ```bash
  npm install ngx-pagination
  ```

JDK Java 22
  https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html


## Iniciar el FrontEnd ##

Después de clonar el repositorio, ejecutar el comando:

```bash
  \HackaJava\FrontEnd\el-caserio>
  npm install
```
Esto debe hacerse en la carpeta "el-caserio" dentro de la carpeta "FrontEnd".

Para ejecutar el FrontEnd usamos el comando:

```bash
  ng serve -o
```
  
## Iniciar el BackEnd ##

Abrir la carpeta de 'elCaserio' en tu IDE con la dirección:

```bash
  \HackaJava\BackEnd\elCaserio
```

Seleccionar el JDK 22.

Después de que se instalen las dependencias, modificar el archivo "application.properties" que está en la carpeta "\HackaJava\BackEnd\elCaserio\src\main\resources" y colocar el usuario y contraseña de tu base de datos local.

(Es necesario contar con un gestor de base de datos, ya sea MySQL o PostgreSQL)

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/el_caserio?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
```
  
Ejecutar la clase "ElCaserioApplication", esto debería iniciar el servidor de Tomcat en local.

### Agregar elementos a la Base de Datos

(Mientras la aplicación del BackEnd esté corriendo)

Utilizando Postman, podemos agregar los alérgenos y los productos con los siguientes JSON, usando las siguientes direcciones:

- Para los alérgenos:

Método (POST)

```bash
http://localhost:8080/el-caserio/alergeno 
```

```bash
{
  "nombre": "Nueces"
}

```

- Para los productos

Método (POST)

```bash
http://localhost:8080/el-caserio/producto
```

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

- Las categorías disponibles son las siguientes:
- 
Hamburguesa, Entrantes, Combinados Especiales, Ensaladas, Sándwiches, Bocadillos, Perritos, Postres.

(Agregar los alérgenos antes de los productos, y utilizar los id que estos generen).
