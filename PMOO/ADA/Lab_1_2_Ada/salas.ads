PACKAGE Salas IS

   TYPE Sala IS PRIVATE;

   --Constructor para crear la sala e inicializarla
   FUNCTION Crear_Sala (
         Nombre_Sala             : String;
         Numero_Filas            : Positive;
         Numero_Localidades_Fila : Positive)
     RETURN Sala;

   --Devuelve el nombre de la sala
   FUNCTION Nombre_Sala (
         S : Sala)
     RETURN String;

   --Devuelve el aforo maximo de la sala
   FUNCTION Aforo_Sala (
         S : Sala)
     RETURN Positive;

   --Devuelve el numero de plazas libres en la sala
   FUNCTION Plazas_Libres (
         S : Sala)
     RETURN Natural;

   --Imprime por pantalla el identificador de la pelicula
   FUNCTION La_Pelicula (
         S : IN     Sala)
     RETURN String;

   --Modificar el identificador de la sala pasada por parametro
   PROCEDURE Modificar_Pelicula (
         S      : IN OUT Sala;
         Nombre :        String);

   --Procedimiento que vende localidades contiguas
   PROCEDURE Vender_Localidades_Contiguas (
         S               : IN OUT Sala;
         Numero_Entradas :        Positive);

   --Funcion auxiliar para normalizar strings
   FUNCTION Normalizar_String (
         S            : Sala;
         Rango_Maximo : Positive)
     RETURN String;

   --Procedimiento para mostrar el mapa de la sala
   PROCEDURE Mostrar_Sala (
         S : Sala);

   --Sobrecarga del operador ":=" para copiar objetos
   PROCEDURE Copiar_Sala (
         S          : IN OUT Sala;
         S_A_Copiar : IN     Sala);

PRIVATE
   RANGO_MATRIZ      : CONSTANT := 25;
   RANGO_LOCALIDADES : CONSTANT := 25;

   TYPE Matriz IS ARRAY (1 .. RANGO_MATRIZ, 1 .. RANGO_MATRIZ) OF Boolean;

   TYPE Sala IS
      RECORD
         Nombre_Sala             : String (1 .. 7);
         Identificador_Peli      : String (1 .. 10);
         Localidades_Libres      : Natural;
         Numero_Filas,
         Numero_Localidades_Fila : Positive RANGE 1 .. RANGO_LOCALIDADES;
         Array_Localidades       : Matriz;
      END RECORD;

END Salas;
