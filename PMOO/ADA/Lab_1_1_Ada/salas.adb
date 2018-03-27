WITH Ada.Text_IO;
USE Ada.Text_IO;
PACKAGE BODY Salas IS

   FUNCTION Crear_Sala (
         Nombre_Sala             : String;
         Numero_Filas            : Positive;
         Numero_Localidades_Fila : Positive)
     RETURN Sala IS
      Una_Sala        : Sala;
      Nombre_Sala_Aux : String (1 .. Integer'Min (7, Nombre_Sala'Length)) := (OTHERS => ' ');
   BEGIN
      Nombre_Sala_Aux                  := Nombre_Sala;
      Una_Sala.Nombre_Sala             := Nombre_Sala_Aux;
      Una_Sala.Numero_Filas            := Numero_Filas;
      Una_Sala.Numero_Localidades_Fila := Numero_Localidades_Fila;
      Una_Sala.Array_Localidades       := (OTHERS => (OTHERS => False));
      Una_Sala.Localidades_Libres := Numero_Filas * Numero_Localidades_Fila;
      Una_Sala.Identificador_Peli      := (OTHERS => '-');
      RETURN Una_Sala;
   END Crear_Sala;

   FUNCTION Nombre_Sala (
         S : Sala)
     RETURN String IS
   BEGIN
      RETURN S.Nombre_Sala;
   END Nombre_Sala;

   FUNCTION Aforo_Sala (
         S : Sala)
     RETURN Positive IS
   BEGIN
      RETURN S.Numero_Filas * S.Numero_Localidades_Fila;
   END Aforo_Sala;

   FUNCTION Plazas_Libres (
         S : Sala)
     RETURN Natural IS
   BEGIN
      RETURN S.Localidades_Libres;
   END Plazas_Libres;

   FUNCTION La_Pelicula (
         S : IN     Sala)
     RETURN String IS
   BEGIN
      RETURN S.Identificador_Peli;
   END La_Pelicula;

   PROCEDURE Modificar_Pelicula (
         S      : IN OUT Sala;
         Nombre :        String) IS
   BEGIN
      S.Identificador_Peli := Nombre;
   END Modificar_Pelicula;

   PROCEDURE Vender_Localidades_Contiguas (
         S               : IN OUT Sala;
         Numero_Entradas :        Positive) IS
   BEGIN
      IF S.Localidades_Libres = 0 THEN
         Put_Line ("El aforo está completo.");
         RETURN;
      ELSIF S.Localidades_Libres < Numero_Entradas THEN
         Put_Line ("No hay suficientes localizaciones libres.");
         RETURN;
      END IF;

      FOR I IN 1 .. S.Numero_Filas LOOP
         FOR J IN 1 .. S.Numero_Localidades_Fila - Numero_Entradas + 1 LOOP
            FOR K IN J .. J + Numero_Entradas - 1 LOOP
               EXIT WHEN S.Array_Localidades (I, J);
               IF K = J + Numero_Entradas - 1 THEN
                  FOR T IN K - Numero_Entradas + 1 .. K LOOP
                     S.Array_Localidades (I, T) := True;

                     Put_Line
                        ("Sala: " &
                        S.Nombre_Sala &
                        " Fila " &
                        Integer'Image (I) &
                        ", Asiento: " &
                        Integer'Image (T));

                     S.Localidades_Libres := S.Localidades_Libres - 1;
                  END LOOP;
                  New_Line;
                  New_Line;
                  RETURN;
               END IF;
            END LOOP;
         END LOOP;
      END LOOP;
   END Vender_Localidades_Contiguas;

   PROCEDURE Mostrar_Sala (
         S : Sala) IS
      Filas            : Positive;
      Localidades_Fila : Positive;
      Butacas_Libres   : Positive;
   BEGIN
      Filas            := S.Numero_Filas;
      Localidades_Fila := S.Numero_Localidades_Fila;
      Butacas_Libres   := Filas * Localidades_Fila;

      IF Salas.Plazas_Libres (S) = Butacas_Libres THEN
         Put ("Sala: ");
         Put (S.Nombre_Sala);
         Put (" Pelicula: ");
         Put (S.Identificador_Peli);
         New_Line;
         Put ("La sala esta vacia.");
         New_Line;
         RETURN;
      END IF;

      FOR I IN 1 .. Filas LOOP
         Put (Integer'Image (I));
         FOR J IN 1 .. Localidades_Fila LOOP
            IF S.Array_Localidades (I, J) = False THEN
               Put (" _ ");
            ELSIF S.Array_Localidades (I, J) = True THEN
               Put (" & ");
            END IF;
         END LOOP;
         New_Line;
      END LOOP;

   END Mostrar_Sala;

   FUNCTION Normalizar_String (
         S            : Sala;
         Rango_Maximo : Positive)
     RETURN String IS
   BEGIN
      RETURN "en proceso";
   END Normalizar_String;

   PROCEDURE Copiar_Sala (
         S          : IN OUT Sala;
         S_A_Copiar : IN     Sala) IS
   BEGIN
      S := S_A_Copiar;
   END Copiar_Sala;

END Salas;
