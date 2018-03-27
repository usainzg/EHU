with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Ver_Enesima_Potencia is
   -- entrada: 2 natural
   -- salida: 4 naturales y 1 natural, Pot (SE)
   -- post: Los cuatro naturales corresponden a 4 de casos de prueba

   function Potencia (M: Natural; N: Natural) return Natural is
   -- EJERCICIO 1 (Opcional)- ESPECIFICA E IMPLEMENTA recursivamente el subprograma
   --   Potencia que calcula la n-�sima potencia de M.

   begin
      -- Completar
      if N = 0 then
        return 1;
      end if;

      if N > 0 then
        return M * Potencia(M, N-1);
      end if;

      return 0;
   end Potencia;

begin
      ---------- PRUEBAS EXPL�CITAS A PROBAR
   Put_Line ("--------------------------------");
   Put("   CASO1: 2^0= "); put(2**0, 0); put(", y con tu programa es --> ");    Put (Potencia(2, 0), 0); Put_Line(".");
   New_Line;New_Line;
   Put_Line ("--------------------------------");
   Put("   CASO2: 3^1= "); put(3**1, 0); put(", y con tu programa es --> ");    Put (Potencia(3, 1), 0); Put_Line(".");
   New_Line;New_Line;
   Put_Line ("--------------------------------");
   Put("   CASO3: 5^5= "); put(5**5, 0); put(", y con tu programa es --> ");    Put (Potencia(5, 5), 0); Put_Line(".");
   New_Line;New_Line;
   Put_Line ("--------------------------------");
   Put("   CASO4: 4^15= "); put(4**15, 0); put(", y con tu programa es --> ");    Put (Potencia(4, 15), 0); put_line(".");
   New_Line;New_Line;
   Put_Line ("--------------------------------");
   Put_Line ("--------------------------------");
end Ver_Enesima_Potencia;
