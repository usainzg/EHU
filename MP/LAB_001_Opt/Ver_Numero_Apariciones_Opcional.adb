WITH Ada.Text_Io; USE Ada.Text_Io;
WITH Ada.Integer_Text_Io; USE Ada.Integer_Text_Io;

procedure Ver_Num_Apariciones_Opcional is
   -- salida: 11 enteros(SE)
   -- post: corresponden a cada uno de los casos de pruebas dise�ados.

  -- pre: { True }
   function Num_Apariciones_Caracter (
         S : String;
         L : Character)
     return Integer is
   -- EJERCICIO 4- ESPECIFICA E IMPLEMENTA recursivamente el subprograma
   --   Num_Apariciones_a que devuelve el numero de apariciones del car�cter 'a' en el string S
   BEGIN
      -- Completar
      if S'Size = 0 then
        return 0;
      end if;

      if S(S'First) = L then
        return 1 + Num_Apariciones_Caracter(S(S'First + 1 .. S'Last), L);
      end if;
      return Num_Apariciones_Caracter(S(S'First + 1 .. S'Last), L);
   end Num_Apariciones_Caracter ;

   -- post: { True <=> (Contiene_Caracter(S, L) == Contador=(1<=n<=S'Length ^ S(n) == L))}

begin
   Put_Line("-------------------------------------");
   Put("La palabra vacia contiene 0 apariciones del caracter 'a': ");
   Put(Num_Apariciones_Caracter("", 'a'));
   New_Line;
   New_Line;
   New_Line;
   Put_Line("-------------------------------------");
   Put_Line("Palabras de 1 caracter");
   Put("-- La palabra de 1 caracter 'a' contiene 1 aparicion del caracter 'a': ");
   Put(Num_Apariciones_Caracter("a", 'a'));
   New_Line;
   Put("-- La palabra de 1 caracter 'b' contiene 0 apariciones del caracter 'a': ");
   Put(Num_Apariciones_Caracter("b", 'a'));
   New_Line;
   New_Line;
   New_Line;
   Put_Line("-------------------------------------");
   Put_Line("Palabras de varios caracteres");
   Put("-- 'aaaa' contiene 4 apariciones del caracter 'a': ");
   Put(Num_Apariciones_Caracter("aaaa", 'a'));
   New_Line;
   Put("-- 'bbbb' contiene 0 apariciones del caracter 'a': ");
   Put(Num_Apariciones_Caracter("bbbb", 'a'));
   New_Line;
   Put("-- 'abab' contiene 2 apariciones del caracter 'a': ");
   Put(Num_Apariciones_Caracter("abab", 'a'));
   New_Line;
   Put("-- 'baba' contiene 2 apariciones del caracter 'b': ");
   Put(Num_Apariciones_Caracter("baba", 'b'));
   New_Line;
   Put("-- 'abba' contiene 2 apariciones del caracter 'a': ");
   Put(Num_Apariciones_Caracter("abba", 'a'));
   New_Line;
   Put("-- 'baab' contiene 2 apariciones del caracter 'b': ");
   Put(Num_Apariciones_Caracter("baab", 'b'));
   New_Line;
   Put("-- 'abbb' contiene 1 aparicion del caracter 'a': ");
   Put(Num_Apariciones_Caracter("abbb", 'a'));
   New_Line;
   Put("-- 'babb' contiene 1 aparicion del caracter 'a': ");
   Put(Num_Apariciones_Caracter("babb", 'a'));
   New_Line;
   Put("-- 'bbab' contiene 1 aparicion del caracter 'a': ");
   Put(Num_Apariciones_Caracter("bbab", 'a'));
   New_Line;
   Put("-- 'bbba' contiene 1 aparicion del caracter 'a': ");
   Put(Num_Apariciones_Caracter("bbba", 'a'));
   New_Line;
   Put_Line("-------------------------------------");
end Ver_Num_Apariciones_Opcional;
