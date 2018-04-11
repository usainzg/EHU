package body Primos is

    function Es_Primo(N: Integer) return Boolean is
    begin
        if Suma_Divisores_Propios(N) = 1 then
            return True;
        end if;
        return False;
    end Es_Primo;

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

    function Es_Divisor(N, M: Integer) return Boolean is
    begin
        if (M mod N) = 0 then
            return True;
        end if;
        return False;
    end Es_Divisor;

    function Es_Abundante(N: Integer) return Boolean is
    begin
        if Suma_Divisores_Propios(N) > N then
            return True;
        end if;
        return False; 
    end Es_Abundante;


end Primos;