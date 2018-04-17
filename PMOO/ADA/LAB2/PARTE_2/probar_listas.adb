with Ada.Integer_Text_IO, Ada.Text_IO;
use Ada.Integer_Text_IO, Ada.Text_IO;

with Listas;
with Es_Abundante;
with Crear_Sublista_4Primos;
with Crear_Sublista_Pares;
with Listas_Enteros;

procedure Probar_Listas is
      
      procedure Crear_Sublista_3Abundantes is new Listas_Enteros.Crear_Sublista(Cuantos => 3, Filtro => Es_Abundante);

      procedure Escribir_Contenido(L: in out Listas_Enteros.Lista; Lista: String) is
            N: Integer;
      begin
            -- Contenido de L1 con los 10 primeros enteros
            Put_Line("El contenido de la Lista "&Lista&" es:");
            Put("===> ");
            while not Listas_Enteros.Es_Vacia(L) loop
            Listas_Enteros.Obtener_Primero(L, N);
            Put(N,2);
            Put(" ");
            Listas_Enteros.Borrar_Primero(L);
            end loop;
            New_Line; New_Line;
      end Escribir_Contenido;

      procedure Escribir_Contenidos(L1: in out Listas_Enteros.Lista; L1s: String; L2: in out Listas_Enteros.Lista; L2s: String) is
            N1, N2: Integer;

      begin
            Put_Line("===> El contenido de las Listas "&L1s&" y "&L2s&" es:");
            while not Listas_Enteros.Es_Vacia(L1) loop
            Listas_Enteros.Obtener_Primero(L1, N1);
            Listas_Enteros.Obtener_Primero(L2, N2);
            Put(N1, 4);
            Put("  --  ");
            Put(N2, 4);
            New_Line;
            Listas_Enteros.Borrar_Primero(L1);
            Listas_Enteros.Borrar_Primero(L2);
            end loop;
      end Escribir_Contenidos;

      

      L1,
            L1p,
            L2,
            L3,
            L4,
            L2p,
            Lp1,
            Lp2,
            L3primos,
            L4abudantes : Listas_Enteros.Lista;
      N,
            N1,
            N2  : Integer;

      begin
      -- Crear lista de enteros L1 con los 10 primeros enteros
      Put("===> Creando L1 ...");
      Listas_Enteros.Crear_Vacia(L1);

      for I in 1..10 loop
            Listas_Enteros.Colocar(L1, I);
            if Listas_Enteros.Esta(L1, I) then
            Put(I, 0);
            Put(" ");
            else
            Put("NO");
            Put(I, 0);
            Put(" ");
            end if;
      end loop;
      Crear_Sublista_Pares(L1, L1p); -- Los pares de L1
      New_Line; New_Line;

      -- Crear lista de enteros L2 con los enteros desde el 11 al 23
      Put("===> Creando L2 ...");
      Listas_Enteros.Crear_Vacia(L2);
      for I in 11..23 loop
            Listas_Enteros.Colocar(L2, I);
            if Listas_Enteros.Esta(L2, I) then
            Put(I, 0);
            Put(" ");
            else
            Put("NO");
            Put(I, 0);
            Put(" ");
            end if;
      end loop;
      Crear_Sublista_Pares(L2, L2p); -- Los pares de L2
      New_Line; New_Line;

      Put("===> Creando L3 ...");
      Listas_Enteros.Crear_Vacia(L3);
      for I in 11..23 loop
            Listas_Enteros.Colocar(L3, I);
            if Listas_Enteros.Esta(L3, I) then
            Put(I, 0);
            Put(" ");
            else
            Put("NO");
            Put(I, 0);
            Put(" ");
            end if;
      end loop;
      --Crear_Sublista_4Primos(L3, L3primos); -- Los pares de L2
      New_Line; New_Line;

      Put("===> Creando L4 ...");
      Listas_Enteros.Crear_Vacia(L4);
      for I in 11..23 loop
            Listas_Enteros.Colocar(L4, I);
            if Listas_Enteros.Esta(L4, I) then
            Put(I, 0);
            Put(" ");
            else
            Put("NO");
            Put(I, 0);
            Put(" ");
            end if;
      end loop;
      Crear_Sublista_3Abundantes(L4, L4abudantes); -- Los pares de L2
      New_Line; New_Line;


      -- Contenido de L1 con los 10 primeros enteros
      Put("===> ");
      Escribir_Contenido(L1, "L1");

      -- Contenido de L2 con los 10 primeros enteros
      Put("===> ");
      Escribir_Contenido(L2, "L2");

      Put("===> ");
      Escribir_Contenido(L3, "L3");

      Put("===> ");
      Escribir_Contenido(L3primos, "L3primos");

      Put("===> ");
      Escribir_Contenido(L4, "L4");

      Put("===> ");
      Escribir_Contenido(L4abudantes, "L4abudantes");

      -- Crear lista de enteros pares Lp con los 5 primeros pares del 2 al 8
      Listas_Enteros.Crear_Vacia(Lp1);
      N:= 2;
      while N<=10 loop
            Listas_Enteros.Colocar(Lp1, N);
            N:= N+2;
      end loop;

      -- Trataremos las listas de pares L1p y Lp1
      if Listas_Enteros.Igual(Lp1, L1p) then
            Put_Line("La lista Lp1 y la obtenida como sublista de pares L1p son iguales");
            Escribir_Contenidos(L1p, "L1p", Lp1, "Lp1");
      else
            Put_Line("La lista Lp1 y la obtenida como sublista de pares L1p NO son iguales");
            -- Contenido de L1p
            Put("===> ");
            Escribir_Contenido(L1p, "L1p");
      end if;
      New_Line; New_Line;


      -- Trataremos las listas de pares L2p y Lp2
      Listas_Enteros.Copiar(Lp2, L2p);
      if Listas_Enteros.Igual(Lp2, L2p) then
            Put_Line("La lista Lp2 y la obtenida como copia L2p son iguales");
            Escribir_Contenidos(L2p, "L2p", Lp2, "Lp2");
      else
            Put_Line("La lista Lp2 y la obtenida como copia L2p NO son iguales");
            -- Contenido de L2p
            Put("===> ");
            Escribir_Contenido(L2p, "L2p");
      end if;
end Probar_Listas;