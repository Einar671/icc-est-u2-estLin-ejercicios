package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : texto.toCharArray()){
            stack.push(c);
        }
        StringBuilder reversa = new StringBuilder();
        while(!stack.isEmpty()){
            reversa.append(stack.pop());
        }
        return String.valueOf(reversa);
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
public boolean validarSimbolos(String expresion) {
    if (expresion == null) return false;
    
    Stack<Character> cStack = new Stack<>();
    for (char c : expresion.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            cStack.push(c);
        } else if (c == ')' || c == ']' || c == '}') {
            if (cStack.isEmpty()) {
                return false;
            }
            char ultimo = cStack.pop();
            if (!isMatchingPair(ultimo, c)) {
                return false;
            }
        }
    }
    return cStack.isEmpty();
}

private boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '{' && close == '}') ||
           (open == '[' && close == ']');
}





    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<Integer>();
        while(!pila.isEmpty()){
            int temp = pila.pop();
            while(!aux.isEmpty() && aux.peek()>temp){
                pila.push(aux.pop());
            }
            aux.push(temp);
        }
        while(!aux.isEmpty()){
            pila.push(aux.pop());
        }
        List<Integer> listaFinal = new ArrayList<Integer>();
        while(!pila.isEmpty()){
            listaFinal.add(pila.pop());
        }
        return listaFinal;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> numerosPares = new LinkedList<Integer>();
        LinkedList<Integer> numerosImpares = new LinkedList<Integer>();
        for(int numero : original){
            if(numero%2 == 0){
                numerosPares.add(numero);
            }else{
                numerosImpares.add(numero);
            }
        }
        numerosPares.addAll(numerosImpares);
        return numerosPares ;
    }
}
