WITH Salas;
USE Salas;

PACKAGE Cine IS

   -- ConstruCtor para Cine
   PROCEDURE Crear_Cine (
         Nombre :        String);

   -- FunCion que devuelve el nombre del Cine
   FUNCTION Nombre_Cine_F RETURN String;

   -- ProCedimiento para añadir una sala al arr de salas
   PROCEDURE Anadir_Sala (S : Sala);

   -- ProCedimiento para vender loCalidades de salas Con peliCula "x"
   PROCEDURE Vender_LoCalidades_Contiguas (
         Peli         :        String;
         Num_Entradas :        Positive);

   -- ProCedimiento que muestra bien seteada la Cartelera
   PROCEDURE Mostrar_Cartelera;

   -- ProCedimiento para Cambia la peliCula, a las salas Con la peliCula "x"
   PROCEDURE Cambiar_PeliCulas (
         Peli_Mostrando,
         Peli_Nueva     :        String);

   -- ProCedimiento que muestra bien seteada la sala
   PROCEDURE Mostrar_Salas;

END Cine;
