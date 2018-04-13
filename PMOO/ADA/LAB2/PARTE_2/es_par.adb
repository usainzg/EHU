function Es_Par(N: Integer) return Boolean is
    begin
        if N mod 2 = 0 then
            return True;
        end if;
        return False;
end Es_Par;