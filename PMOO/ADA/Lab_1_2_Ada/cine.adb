WITH Ada.Text_Io;
USE Ada.Text_Io;
WITH Salas;

PACKAGE BODY Cine IS

   MAX_SALAS : CONSTANT := 30;
   TYPE Arr_Salas IS ARRAY (1 .. MAX_SALAS) OF Sala;

   Nombre_Cine : String (1 .. 7);
   Cont        : Integer;
   Salas_Arr       : Arr_Salas;


   PROCEDURE Crear_Cine (
         Nombre :        String) IS
      Nombre_Cine_Aux : String (1 .. Integer'Min (7, Nombre'Length)) := (OTHERS => ' ');
   BEGIN
      Nombre_Cine_Aux := Nombre;
      Nombre_Cine := Nombre_Cine_Aux;
      Cont := 0;
   END Crear_Cine;

   FUNCTION Nombre_Cine_F
     RETURN String IS
   BEGIN
      RETURN Nombre_Cine;
   END Nombre_Cine_F;

   PROCEDURE Anadir_Sala (
         S :        Sala) IS
   BEGIN
      IF Cont /= Salas_Arr'Last THEN
         Cont := Cont + 1;
         Salas.Copiar_Sala(Salas_Arr(Cont), S);
      END IF;
   END Anadir_Sala;

   PROCEDURE Vender_LoCalidades_Contiguas (
         Peli         :        String;
         Num_Entradas :        Positive) IS
   BEGIN
      FOR I IN 1 .. Cont LOOP
         IF Salas.La_PeliCula(Salas_Arr(I)) = Peli THEN
            Salas.Vender_LoCalidades_Contiguas(Salas_Arr(I), Num_Entradas);
            RETURN;
         END IF;
      END LOOP;
   END Vender_LoCalidades_Contiguas;

PROCEDURE Mostrar_Cartelera IS
   BEGIN
      Put_Line("----Cartelera del Cine: "&Nombre_Cine&"----");
      FOR I IN 1 .. Cont LOOP
         Put_Line(Integer'Image(I)&". Sala"&
            Salas.Nombre_Sala(Salas_Arr(I))&
            ": -> "&Salas.La_Pelicula(Salas_Arr(I)));
            New_Line;
      END LOOP;
   END Mostrar_Cartelera;

   PROCEDURE Cambiar_Peliculas (
         Peli_Mostrando,
         Peli_Nueva     :        String) IS
   BEGIN
      FOR I IN 1 .. Cont LOOP
         IF Salas.La_Pelicula(Salas_Arr(I)) = Peli_Mostrando THEN

            Salas.Modificar_Pelicula(Salas_Arr(I), Peli_Nueva);
         END IF;
      END LOOP;
   END Cambiar_Peliculas;

   PROCEDURE Mostrar_Salas IS
   BEGIN
      FOR I IN 1 .. Cont LOOP
         Put_Line(Integer'Image(I)&". Sala: "&Salas.Nombre_Sala(Salas_Arr(I)));
         Salas.Mostrar_Sala(Salas_Arr(I));
         New_Line;
      END LOOP;
   END Mostrar_Salas;
END Cine;
