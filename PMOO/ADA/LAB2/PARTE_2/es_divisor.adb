function Es_Divisor(N, M: Integer) return Boolean is
    begin
        if (M mod N) = 0 then
            return True;
        end if;
        return False;
end Es_Divisor;