# Proyecto creado por Brandon Retana y Kevin Cubillo

## Pasos para correr el proyecto:

### Prerequsitos:
* docker
* git 
* java 17
* mvn

## Paso 1:
Compilar la imagen de docker:
```docker
docker compose bulid
```

## Paso 2:
Ejecutar los contenedores de docker: 
```docker
docker compose up
```

## Paso 3:
Ejecutar dentro del contenedor de la app el comando:
```bash
./mvnw spring-boot:run
```

## Paso 4:
Colocar la siguinete URL en el navegador
```URL
http://localhost:8080/
```




