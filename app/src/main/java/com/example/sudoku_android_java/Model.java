package com.example.sudoku_android_java;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class Model {
    private static int[][] matriuI=new int[9][9];

    public int getVal(int fila,int columna){
        return matriuI[fila][columna];
    };
    public int setVal(int valor,int fila,int columna){
        int previousVal = matriuI[fila][columna];
        matriuI[fila][columna] = valor;
        if (!comprovaFila(fila)){matriuI[fila][columna] = previousVal; return -1;};
        if (!comprovaCol(columna)){matriuI[fila][columna] = previousVal; return -1;};
        if (!comprovaQuad(fila,columna)){matriuI[fila][columna] = previousVal; return -1;};
        return 0;
    }
    public boolean comprovaFila(int fila){
        Boolean valid = true;
        for (int a = 0; a<9; a++){
            for (int b = 0; b<9; b++){
                if (a != b && matriuI[fila][a] != 0){
                    if (matriuI[fila][a] == matriuI[fila][b]){return false; }
                }
            }
        }

        return valid;
    }
    public boolean comprovaCol(int columna){
        boolean valid = true;
        for (int a = 0; a < 9; a++){
            for (int b = 0; b < 9; b++){
                if (a != b && matriuI[b][columna] != 0){
                    if (matriuI[a][columna] == matriuI[b][columna]){return false;}
                }
            }
        }

        return valid;
    }
    public boolean comprovaQuad(int columna,int fila){
        boolean valid = true;
        int minfila = 0;
        int mincolumna = 0;
        //Determina la cantonada superior esquerra del quadrant
        if (fila < 3){
            minfila = 0;
            if (columna<3) {mincolumna = 0;}
            else if (columna < 6){mincolumna = 3;}
            else {mincolumna = 6;}
        }else if (fila < 6) {
            minfila = 3;
            if (columna<3) {mincolumna = 0;}
            else if (columna < 6){mincolumna = 3;}
            else {mincolumna = 6;}
        } else {
            minfila = 6;
            if (columna<3) {mincolumna = 0;}
            else if (columna < 6){mincolumna = 3;}
            else {mincolumna = 6;}
        }
        //Comprova els valors del quadrant
        for (int a = minfila; a < minfila+3 ; a++){
            for (int b = mincolumna; b < mincolumna + 3; b++) {
                for (int a1 = minfila; a1 < minfila + 3; a1++) {
                    for (int b1 = mincolumna; b1 < mincolumna + 3; b1++) {
                        if (a != a1 && b != b1 && matriuI[a][b] != 0) {
                            if (matriuI[a][b] == matriuI[a1][b1]) {
                                Log.i("Quad", "NO");
                                valid = false;
                            }
                        }
                    }
                }
            }
        }
        Log.i("Quad", "YES");
        return valid;
    }

    public void creaPartida(){
        Random rng = new Random();
        int numsIntroduits = 20;
        Log.i("Inputs",String.valueOf(numsIntroduits));
        int row = 0;
        int col = 0;
        int val = 0;
        for (int a = 0; a < numsIntroduits; a++){
            row = rng.nextInt(9-1);
            col = rng.nextInt(9-1);
            val = rng.nextInt(9-1)+1;
            setVal(row,col,val);
            while (setVal(row,col,val) == -1){
                Log.i("INFO","Regenerant nombre");
                row = rng.nextInt(9-1);
                col = rng.nextInt(9-1);
            }
        }
    }

    public Model() {
        creaPartida();
    }
}