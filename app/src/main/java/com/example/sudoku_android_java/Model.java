package com.example.sudoku_android_java;

import java.util.Arrays;

public class Model {

    int matriz[][] = new int[9][9];

    private int getVal(int fila, int columna) {
    return matriz[fila][columna];
    }
    private int setVal(int valor, int fila, int columna) {
        if(valor < 1 || valor > 9 ) {
            this.matriz[fila][columna] = valor;
            return matriz[fila][columna];
        }
        return matriz[fila][columna];
    }

    private boolean comprovaFila(int fila) {
        for(int i=0; i < matriz.length; i++){
            int array []= new int[0];
            if((Arrays.asList(array).contains(matriz[fila][i]))){
                return false;
            }else{
                array[i]=(matriz[fila][i]);
            }
            return true;
        }
    return true;
    }

    private boolean comprovaCol(int columna) {
        for(int i=0; i < matriz.length; i++){
            int array []= new int[0];
            if((Arrays.asList(array).contains(matriz[i][columna]))){
                return false;
            }else{
                array[i]=(matriz[i][columna]);
            }
            return true;
        }
        return true;
    }

    private boolean comprovaQuad (int fila, int columna) {
    return true;
    }

    private void creaPartida () {
        boolean bucle = true;
        int contador = 0;
        while(bucle){
            int i = (int) (Math.random()*9);
            int j = (int) (Math.random()*9);
            int v = (int) (Math.random()*9);
            if(getVal(i,j) == 0 && v>0){
                setVal(v,i,j);
                if(comprovaFila(i) && comprovaCol(j)){
                    contador++;

                } else{
                    setVal(0,i,j);
                }
            }
            if(contador == 20){
                bucle = false;
            }
        }
    }

}
