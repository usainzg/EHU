with Ada.Integer_Text_IO, Ada.Text_IO;
use Ada.Integer_Text_IO, Ada.Text_IO;

with Primos; use Primos;

procedure Probar_Primos is
   N, N1, N2  : Integer;
begin
   -- Crear lista de enteros L1 con los 10 primeros enteros
    Put("===> Probando primos ...");
    N := 2;
    N1 := 6;
    N2 := 7;

    Put("===> Probando la función Es_Primo ...");
    Put("2 es primo => "&Boolean'Image(Primos.Es_Primo(N)));
    New_Line;
    Put("6 no es primo => "&Boolean'Image(Primos.Es_Primo(N1)));
    New_Line;
    Put("7 es primo => "&Boolean'Image(Primos.Es_Primo(N2)));
    New_Line;


    N := 12;
    N1 := 2;
    N2 := 90;

    Put("===> Probando la función Es_Abundante ...");
    Put("12 es abundante => "&Boolean'Image(Primos.Es_Abundante(N)));
    New_Line;
    Put("2 no es abundante => "&Boolean'Image(Primos.Es_Abundante(N1)));
    New_Line;
    Put("90 es abundante => "&Boolean'Image(Primos.Es_Abundante(N2)));
    New_Line;
   
end Probar_Primos;