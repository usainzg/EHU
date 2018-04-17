package Bombilla is
    procedure Crear (
        id: in String; 
        potencia_nominal: in Float; 
        luminosidad_nominal: in Float;
        es_regulable: in Boolean;
        bomb: out Bombilla;
    );

    function Potencia(B: in Bombilla) return Float;

    function Esta_Encendida(B: in Bombilla) return Boolean;

    procedure Encender(B: in out Bombilla);

    procedure Actualizar_Luminosidades (B: in out Bombilla; vector: in Vectores_Luminosidad.Vector);

    function Eficacia(B: in Bombilla) return Float;



private

    type Bombilla is record 
        identificador: String(1..4);
        potencia_nominal: Float;
        luminosidad_nominal: Float;
        esta_encendida: Boolean;
        es_regulable: Boolean;
        niveles_potencia_arr: Vectores_Luminosidad.Vector;
    end record;
    



end Bombilla;