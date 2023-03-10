<h1 align="center">E-commerce-Price </h1>

## Autor

馃懁 **JuanCBM**: Juan Carlos Bl谩zquez Mu帽oz

* Github: [@JuanCBM](https://github.com/JuanCBM)

----------------------

## Ejecuci贸n:

Se pueden ejecutar los test con el comando.
> `mvn test`

----------------------

## Interpretaciones:

- Se devuelve el id de la tarifa a aplicar.
- Si el desambiguador no soluciona el problema de encontrar varios resultados, se utiliza la fecha
  de creaci贸n y posteriormente el id.
- Se ha aplicado DDD y Arquitectura Hexagonal

----------------------

## Sobre la aplicaci贸n:

- Se han obtenido los datos del enunciado para generar un csv que posteriormente se carga en la
  aplicaci贸n.

- Para no interferir en la BBDD utilizada en la aplicaci贸n, en desarrollo o en cualquier entorno, se
  ha utilizado un Profile de "test" que configura una nueva BBDD.

- Se facilita un swagger para poder realizar peticiones a la aplicaci贸n en caso de ser necesario y
  su documentaci贸n.

> http://localhost:8080/swagger-ui.html

- Se utilizan proyecciones para la respuesta de la consulta realizada como query nativa.