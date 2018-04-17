with Listas_Ordenadas_Gen, Envios;
package Lista_Envios is new Listas_Ordenadas_Gen (
    MAX => 1000,
    Componente => Envios.Envio,
    Precede => Envios.Precede,
    Copiar => Envios.Copiar,
    Igual => Envios.Igual
);
