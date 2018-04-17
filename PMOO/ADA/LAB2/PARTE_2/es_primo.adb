with Suma_Divisores_Propios;
function Es_Primo(N: Integer) return Boolean is
    begin
        if Suma_Divisores_Propios(N) = 1 then
            return True;
        end if;
        return False;
end Es_Primo;