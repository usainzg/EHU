package Centro_Mensajeria is 
    procedure Inicializar(Nombre: String; Localidad: String);
    procedure Localizar_Envios_Cercanos(Geo: GeoLoc.Geo; LCer: Lista_Envios.Lista);
    function Localidad() return String;
    procedure Anadir_Envio(Env: Envios.Envio);
end Centro_Mensajeria;