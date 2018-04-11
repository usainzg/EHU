package Primos is

    function Es_Primo (N: Integer) return Boolean;
    function Es_Abundante(N: Integer) return Boolean;

    private 
        function Suma_Divisores_Propios (N: Integer) return Integer;
        function Es_Divisor(N, M: Integer) return Boolean;
end Primos;
