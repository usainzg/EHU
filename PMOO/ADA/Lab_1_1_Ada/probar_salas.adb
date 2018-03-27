WITH Ada.Text_IO;
USE Ada.Text_IO;

WITH Salas;
USE Salas;

PROCEDURE Probar_Salas IS
   S : Sala;
BEGIN
   S := Crear_Sala("  Ava  ", 12,10);
   Put_Line("El afaro de la sala es"& Integer'Image(Aforo_Sala(S)));
   Put_Line("La sala tiene"&Integer'Image(Plazas_Libres(S))&" libres.");
   Modificar_Pelicula(S, "BlackPanth");
   Put_Line("La pelicula proyectada es "&La_Pelicula(S));
   Mostrar_Sala(S);
   Vender_Localidades_Contiguas(S,9);
   Vender_Localidades_Contiguas(S,8);
   Vender_Localidades_Contiguas(S,7);
   Vender_Localidades_Contiguas(S,6);
   Vender_Localidades_Contiguas(S,5);
   Vender_Localidades_Contiguas(S,10);
   Vender_Localidades_Contiguas(S,6);
   Vender_Localidades_Contiguas(S,3);
   Vender_Localidades_Contiguas(S,10);
   Vender_Localidades_Contiguas(S,10);
   Vender_Localidades_Contiguas(S,10);
   Vender_Localidades_Contiguas(S,10);
   Vender_Localidades_Contiguas(S,6);
   Vender_Localidades_Contiguas(S,6);
   Put_Line("La sala tiene"&Integer'Image(Plazas_Libres(S))&" libres.");
   Mostrar_Sala(S);

   Vender_Localidades_Contiguas(S,4);
   Vender_Localidades_Contiguas(S,4);
   Vender_Localidades_Contiguas(S,4);
   Vender_Localidades_Contiguas(S,4);
   Vender_Localidades_Contiguas(S,5);
   Put_Line("La sala tiene"&Integer'Image(Plazas_Libres(S))&" libres.");
   Mostrar_Sala(S);

   Vender_Localidades_Contiguas(S,1);
   Vender_Localidades_Contiguas(S,2);
   Vender_Localidades_Contiguas(S,4);
   Vender_Localidades_Contiguas(S,1);
   Put_Line("La sala tiene"&Integer'Image(Plazas_Libres(S))&" libres.");
   Mostrar_Sala(S);

   Vender_Localidades_Contiguas(S,1);
   Mostrar_Sala(S);
END Probar_Salas;
