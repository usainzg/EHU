with Ada.Text_IO, Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;

with Primos; use Primos;

package body Listas is

      procedure Crear_Vacia (
            L :    out Lista) is
      begin
            L := null;
      end Crear_Vacia;

      procedure Colocar (
            L : in out Lista;
            E : in     Integer) is
            -- Algoritmo recursivo
      begin

            if L = null or else E<= L.Info then
            L := new Nodo'(E, L);  -- Colocar al comienzo
            else
            Colocar (L.Sig, E);
            end if;
      end Colocar;

      procedure Obtener_Primero (
            L : in     Lista;
            P :    out Integer) is
      begin
            if L = null then
            Put_Line("Lista_Vacia");
            else
            P:= L.Info;
            end if;
      end Obtener_Primero;

      function Esta (
            L : in     Lista;
            N : in     Integer)
            return Boolean is
            -- Algoritmo iterativo
            Auxi : Lista := L;
      begin
            while Auxi/=null and then N> Auxi.Info loop
            Auxi:= Auxi.Sig;
            end loop;
            return Auxi/=null and then N= Auxi.Info;
      end Esta;

      procedure Borrar_Primero (
            L : in out Lista) is
      begin
            if L = null then
            Put_Line("Lista_Vacia");
            else
            L := L.Sig;
            end if;
      end Borrar_Primero;

      procedure Crear_Sublista(
            L  : in     Lista;
            Sl :    out Lista;
            Cuantos: Integer) is
            -- Algoritmo iterativo
            Cont: Natural:=0;
            AuxL: Lista:= L;
            AuxSl: Lista:= null;
      begin
            Sl:=null;
            while AuxL/= null and Cont < Cuantos loop
            if AuxL.Info mod 2=0 then
                  Cont:= Cont+1;
                  if Sl=null then
                  Sl:= new Nodo'(AuxL.Info, null);
                  AuxSl:= Sl;
                  else
                  AuxSl.Sig:= new Nodo'(AuxL.Info, null);
                  AuxSl:= AuxSl.Sig;
                  end if;
            end if;
            AuxL:= Auxl.Sig;
            end loop;
      end Crear_Sublista;

      function Es_Vacia (
            L : in     Lista)
            return Boolean is
      begin
            return L = null;
      end Es_Vacia;

      function Igual (
            L1,
            L2 : in     Lista)
            return Boolean is
            -- Algoritmo recursivo
      begin
            if L1 = null and L2 = null then
            return True;
            elsif L1 = null or L2 = null then
            return False;
            else
            return L1.Info=L2.Info and then
                  Igual(L1.Sig, L2.Sig); -- Llamada recursiva!
            end if;
      end Igual;

      procedure Copiar (
            L1 :    out Lista;
            L2 : in     Lista) is
            -- Algoritmo recursivo
      begin
            if L2 = null then
            L1 := null;
            else
            Copiar(L1, L2.Sig);
            L1 := new Nodo'(L2.Info, L1);
            end if;
      end Copiar;

      procedure Crear_Sublista_4Primos(
            L : in     Lista;
            Sl: out Lista
            ) is
            Cont: Natural:=0;
            AuxL: Lista:= L;
            AuxSl: Lista:= null;
      begin
            Sl:=null;
            while AuxL/= null and Cont < 4 loop
            if Primos.Es_Primo(AuxL.Info) then
                  Cont:= Cont+1;
                  if Sl=null then
                  Sl:= new Nodo'(AuxL.Info, null);
                  AuxSl:= Sl;
                  else
                  AuxSl.Sig:= new Nodo'(AuxL.Info, null);
                  AuxSl:= AuxSl.Sig;
                  end if;
            end if;
            AuxL:= Auxl.Sig;
            end loop;
      end Crear_Sublista_4Primos;

      procedure Crear_Sublista_3Abundantes(
            L : in     Lista;
            Sl: out Lista
            ) is
            Cont: Natural:=0;
            AuxL: Lista:= L;
            AuxSl: Lista:= null;
      begin
            Sl:=null;
            while AuxL/= null and Cont < 3 loop
            if Primos.Es_Primo(AuxL.Info) then
                  Cont:= Cont+1;
                  if Sl=null then
                  Sl:= new Nodo'(AuxL.Info, null);
                  AuxSl:= Sl;
                  else
                  AuxSl.Sig:= new Nodo'(AuxL.Info, null);
                  AuxSl:= AuxSl.Sig;
                  end if;
            end if;
            AuxL:= Auxl.Sig;
            end loop;
      end Crear_Sublista_3Abundantes;
end Listas;

