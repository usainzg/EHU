WITH Ada.Text_IO;
USE Ada.Text_IO;
WITH Salas, Cine;
USE Salas;

PROCEDURE Probar_Cines IS
   S1,
   S2,
   S3,
   S4,
   S5 : Salas.Sala;
BEGIN
   S1 := Crear_Sala("  Ava  ", 12,18);
   Modificar_Pelicula(S1, "FormaDAgua");

   S2 := Crear_Sala("Marilyn", 12,18);
   Modificar_Pelicula(S2,"BlackPanth");

   S3 := Crear_Sala("Audrey ", 11,10);
   Modificar_Pelicula(S3,"HiloInvisi");

   S4 := Crear_Sala("Hepburn", 11,10);
   Modificar_Pelicula(S4,"CuaderSara");

   S5 := Crear_Sala("  Rita ", 11,10);
   Modificar_Pelicula(S5,"HiloInvisi");

   Cine.Crear_Cine(" Golem ");
   Cine.Anadir_Sala(S1);
   Cine.Anadir_Sala(S2);
   Cine.Anadir_Sala(S3);
   Cine.Anadir_Sala(S4);
   Cine.Anadir_Sala(S5);
   Cine.Mostrar_Salas;

   Cine.Mostrar_Cartelera;
   New_Line;
   New_Line;

   Cine.Vender_Localidades_Contiguas("HiloInvisi", 9);
   Cine.Vender_Localidades_Contiguas( "HiloInvisi" ,8);
   Cine.Vender_Localidades_Contiguas( "HiloInvisi", 7);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 6);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 5);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 10);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 6);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 3);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 10);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 10);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 10);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 10);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 6);
   Cine.Vender_Localidades_Contiguas("HiloInvisi", 6);


   Cine.Vender_Localidades_Contiguas("CuaderSara", 10);
   Cine.Vender_Localidades_Contiguas("CuaderSara", 10);
   Cine.Vender_Localidades_Contiguas("CuaderSara", 10);
   Cine.Vender_Localidades_Contiguas("CuaderSara", 10);

   Cine.Mostrar_Salas;

   Cine.Cambiar_Peliculas("HiloInvisi", "SinPelicul");
   Cine.Mostrar_Cartelera;


END Probar_Cines;
