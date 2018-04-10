
package Listas is

   type Lista is limited private;     -- Tipo lista ordenada creciente

   procedure Crear_Vacia (
         L :    out Lista);
   -- Post: crea la lista vacia L

      procedure Colocar (
            L : in out Lista;
            E : in     Integer);
   -- Pre: L es una lista ordenada crecientemente
   -- Post: Coloca en orden creciente el elemento E en L si hay espacio en la lista
   --   Si la lista está llena dará un mensaje de Lista_Llena

   procedure Obtener_Primero (
         L : in     Lista;
         P: out Integer);
   -- Pre: L es una lista ordenada crecientemente
   -- Post: P es el primer elemento de la lista L, si L no está vacía.
   --   Si la lista está vacía dará un mensaje de Lista_Vacia

   function Esta (
            L : in     Lista;
            N : in     Integer)
        return Boolean;
   -- Post: True sii C esta en la lista L

   procedure Borrar_Primero (
         L : in out Lista);
   -- Pre: L es una lista ordenada crecientemente
   --   Si la lista está vacía dará un mensaje de Lista_Vacia

   procedure Crear_Sublista(
            L : in     Lista;
            Sl: out Lista);
   -- Pre: L es una lista ordenada crecientemente
   -- Post: La sublista Sl esta formada por los 4 primeros elementos pares de la lista L.
   --      Si no hay 4, la creará con los elementos que pares que haya en L.

   function Es_Vacia (
         L : in     Lista)
     return Boolean;
   -- Pre: L es una lista ordenada crecientemente
   -- Post: True sii la lista L es vacia

   function Igual (
         L1,
         L2 : in     Lista)
     return Boolean;
--    Pre: L1 y L2 son listas ordenadas
--    Post: True sii L1 y L2 son iguales (representan listas iguales)

   procedure Copiar (
         L1 :    out Lista;
         L2 : in     Lista);
   -- Pre: L2 es lista ordenada
   -- Post: L1 es una lista ordenada copia de L2.


   private
   -- implementacion dinamica, ligadura simple

   type Nodo;
   type Lista is access Nodo;
   type Nodo is
      record
         Info      : Integer;
         Sig : Lista;
      end record;

end Listas;
