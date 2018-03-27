WITH Ada.Text_Io; USE Ada.Text_Io;

procedure Ver_Contiene_Caracter is
   -- salida: 7 booleanos(SE)
   -- post: corresponden a cada uno de los casos de pruebas dise�ados.

   function Contiene_Caracter (
         S : String;
         L : Character)
     return Boolean is
   -- EJERCICIO 3- ESPECIFICA E IMPLEMENTA recursivamente el subprograma
   --   Contiene_a que decide si el string S contiene el car�cter 'a'.
   BEGIN
      -- Completar
      if S'Size = 0 then
        return False;
      end if;

      if S(S'First) = L then
        return True;
      end if;

      return Contiene_Caracter(S(S'First + 1 .. S'Last), L);
   end Contiene_Caracter ;


begin
   Put_Line("-------------------------------------");
   Put("La palabra vacia no contiene el caracter 'a': ");
   Put(Boolean'Image(Contiene_Caracter("", 'a')));
   New_Line;
   New_Line;
   New_Line;
   Put_Line("-------------------------------------");
   Put_Line("Palabras de un caracter");
   Put("-- La palabra de 1 caracter 'a' contiene el caracter 'a': ");
   Put(Boolean'Image(Contiene_Caracter("a", 'a')));
   New_Line;
   Put("-- La palabra de 1 caracter 'b' contiene el caracter 'b': ");
   Put(Boolean'Image(Contiene_Caracter("b", 'b')));
   New_Line;
   New_Line;
   New_Line;
   Put_Line("-------------------------------------");
   Put_Line("Palabras de varios caracteres");
   Put("-- 'abcd' contiene el caracter 'b': ");
   Put(Boolean'Image(Contiene_Caracter("abcd", 'b')));
   New_Line;
   Put("-- 'dcba' contiene el caracter 'a': ");
   Put(Boolean'Image(Contiene_Caracter("dcba", 'a')));
   New_Line;
   Put("-- 'dcbabcd' contiene el caracter 'a': ");
   Put(Boolean'Image(Contiene_Caracter("dcbabcd", 'a')));
   New_Line;
   Put("-- Pero 'dcbbcd' no contiene el caracter 'e': ");
   Put(Boolean'Image(Contiene_Caracter("dcbbcd", 'e')));
   New_Line;
   Put_Line("-------------------------------------");
end Ver_Contiene_Caracter;
