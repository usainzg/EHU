with Es_Divisor;
function Suma_Divisores_Propios (N: Integer) return Integer is
    Cont: Integer;
    begin
        Cont := 0;
        for I in 1..N-1 loop
            if Es_Divisor(I, N) then 
                Cont := Cont + I;
            end if;
        end loop;
        return Cont;
end Suma_Divisores_Propios;