with Suma_Divisores_Propios;
function Es_Abundante(N: Integer) return Boolean is
    begin
        if Suma_Divisores_Propios(N) > N then
            return True;
        end if;
        return False; 
end Es_Abundante;