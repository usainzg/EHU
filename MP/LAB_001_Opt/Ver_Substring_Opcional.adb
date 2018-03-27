WITH Ada.Text_Io; USE Ada.Text_Io;

procedure Ver_Substring_Opcional is
   -- salida: 11 booleanos(SE)
   -- post: corresponden a cada uno de los casos de pruebas dise�ados.

   function Substring_Sub(
         S : String;
         Sub : String)
     return Boolean is
   -- EJERCICIO 3- ESPECIFICA E IMPLEMENTA recursivamente el subprograma
   --   Substring_aa que decide si el string S contiene el substring 'aa'.
   BEGIN
      -- Completar
      if S'Size < Sub'Size then
        return False;
      end if;

      if S(S'First .. S'First + 1) = Sub then
        return True;
      end if;
      return Substring_Sub(S(S'First + 1 .. S'Last), Sub);
   end Substring_Sub;


begin
   Put_Line("-------------------------------------");
   Put("La palabra vacia no contiene el string 'aa': ");
   Put(Boolean'Image(Substring_Sub("", "aa")));
   New_Line;
   New_Line;
   New_Line;
   Put_Line("-------------------------------------");
   Put_Line("Palabras de 1 caracter");
   Put("-- La palabra de 1 caracter 'a' no contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("a", "aa")));
   New_Line;
   Put("-- La palabra de 1 caracter 'b' no contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("b", "aa")));
   New_Line;
   New_Line;
   New_Line;
   Put_Line("-------------------------------------");
   Put_Line("Palabras de varios caracteres");
   Put("-- 'aaaa' contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("aaaa", "aa")));
   New_Line;
   Put("-- 'bbbb' no contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("bbbb", "aa")));
   New_Line;
   Put("-- 'abab' no contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("abab", "aa")));
   New_Line;
   Put("-- 'baba' no contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("baba", "aa")));
   New_Line;
   Put("-- 'abba' no contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("abba", "aa")));
   New_Line;
   Put("-- 'aabb' contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("aabb", "aa")));
   New_Line;
   Put("-- 'baab' contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("baab", "aa")));
   New_Line;
   Put("-- 'bbaa' contiene el substring 'aa': ");
   Put(Boolean'Image(Substring_Sub("bbaa", "aa")));
   New_Line;
   Put_Line("-------------------------------------");
end Ver_Substring_Opcional;
