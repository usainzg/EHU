with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Ver_Tipo_Vector is

  type T_Vector is array (Positive range <>) of Integer;

  Vector: T_Vector (1..10);
  Vector2: T_Vector(1..100);

  function Suma_Componentes(Vector: T_Vector) return Integer is
  begin
    if Vector'Length = 0 then
      return 0;
    end if;

    return Vector'First + Suma_Componentes(Vector(Vector'First + 1 .. Vector'Last));
  end Suma_Componentes;

  function Numero_Menores(Vector: T_Vector; Int: Integer) return Integer is
  begin
    if Vector'Length = 0 then
      return 0;
    end if;

    if Vector(Vector'First) < Int then
      return 1 + Numero_Menores(Vector(Vector'First + 1 .. Vector'Last), Int);
    end if;

    return Numero_Menores(Vector(Vector'First + 1 .. Vector'Last), Int);

  end Numero_Menores;

  begin
    -- Suma de componentes
    for J in 1 .. 10 loop
      Vector(J) := J;
    end loop;
    Put_Line("Suma de los 10 primeros: 55 -> "&Integer'Image(Suma_Componentes(Vector)));
    for J in 1 .. 100 loop
      Vector2(J) := J;
    end loop;
    Put_Line("Suma de los 100 primeros: 5050 -> "&Integer'Image(Suma_Componentes(Vector2)));

    -- Menores a entero
    Put_Line("Menores a 3 en Vector: 2 -> "&Integer'Image(Numero_Menores(Vector, 3)));
    Put_Line("Menores a 6 en Vector: 5 -> "&Integer'Image(Numero_Menores(Vector, 6)));
    Put_Line("Menores a 10 en Vector: 9 -> "&Integer'Image(Numero_Menores(Vector, 10)));



    
end Ver_Tipo_Vector;
