package body Centro_Mensajeria is
    LEnvios: Lista_Envios.Lista;
    Nombre: String(1..4);
    Ubicacion: String(1..4);

    procedure Localizar_Envios_Cercanos(Geo: in GeoLoc.Geo; out LCer: Lista_Envios.Lista) is
    LAux: Lista_Envios.Lista;
    EnvAux: Envios.Envio;
    GeoAux: GeoLoc.Geo;
    begin
        Listas_Envios.Crear_Vacia(LCer);
        Listas_Envios.Copiar(LAux, LEnvios);
        while not Listas_Envios.Es_Vacia(LAux) loop
            Listas_Envios.Obtener_Primero(LAux, EnvAux);
            Listas_Envios.Eliminar_Primero(LAux);
            GeoAux := Envios.GeoActual(EnvAux);
            if GeoLoc.Distancia(GeoAux, Geo) < 1.0 then
                Listas_Envios.Anadir(LCer, EnvAux);
            end if;
        end loop;
    end Localizar_Envios_Cercanos;