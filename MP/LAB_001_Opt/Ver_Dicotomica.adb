with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Ver_Dicotomica is

   type T_Vector is array (Positive range <>) of Integer;

   Vector: T_Vector (1..10);
   I: Integer;

   function Dicotomica (Vector: T_Vector; N:Integer) return Integer is
   mid : Integer := ((Vector'First + Vector'Last) / 2);
   begin 
	  -- COMPLETAR
    if N > Vector'Size or Vector'Size = 0 then
      return -1;
    end if;

    if Vector((mid)) = I then
      return mid;
    end if;

    if Vector((mid)) > I then
      return Dicotomica(Vector(Vector'First .. mid - 1), I);
    end if;

    if Vector((mid)) < I then
      return Dicotomica(Vector(mid + 1 .. Vector'Last), I);
    end if;
        
    return -1;
   end Dicotomica;

pos : Integer;
begin
    Put_Line ("Dame un vector ordenado de menor a mayor de 10 enteros, un entero Por linea:");
    for J in 1 .. 10 loop
        --Get(Vector(J));
        Vector(J) := J;
    end loop;
    Put_Line ("Dame un entero a buscar:");
    Get (I);
    Put_line ("El resultado de la busqueda es:");
    pos := Dicotomica(Vector,I);
    if pos /= -1 then
        Put_line("Encontrado y posicion: " & Integer'Image(pos));
    else
        Put_line("No encontrado.");
    end if;
end Ver_Dicotomica;
