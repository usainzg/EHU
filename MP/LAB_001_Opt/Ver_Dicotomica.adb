with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Ver_Dicotomica is

   type T_Vector is array (Positive range <>) of Integer;

   Vector: T_Vector (1..10);
   I: Integer;

   function Dicotomica (Vector: T_Vector; N:Integer) return Integer is
     begin 
	-- COMPLETAR
	Null;
        
   end Dicotomica;


begin
   Put_Line ("Dame un vector ordenado de menor a mayor de 10 enteros, un entero Por linea:");
   for J in 1 .. 10 loop
      Get(Vector(J));
   end loop;
   Put_Line ("Dame un entero a buscar:");
   Get (I);
   Put_line ("La posición del entero a buscar es:");
   Put (Dicotomica(Vector,I));
end Ver_Dicotomica;
