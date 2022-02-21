package e2;

public class Slopes {
    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int posy = 0;
        int posx = 0;
        int j;
        int arbol = 0;
        int columnas = 0;

        //Comprobación matriz cuadrada.
        for (char[] value : slopeMap) {
            for (int l = 0; l < value.length; l++) {
                columnas++;
            }
            if (columnas != slopeMap.length) {
                throw new IllegalArgumentException();
            }
            columnas = 0;
        }

        // Comprobación de caracteres.
        for (char[] chars : slopeMap) {
            for (j = 0; j < chars.length; j++) {
                if (chars[j] != '#' && chars[j] != '.') {
                    throw new IllegalArgumentException();
                }
            }
        }

        //Comprobación right - down.
        if(right >= slopeMap[0].length || right < 1){
            throw new IllegalArgumentException();
        }
        if(down >= slopeMap.length || down < 1){
            throw new IllegalArgumentException();
        }
        /////////////////

        //Condición para salir del mapa.
        while(posy < slopeMap.length){
            //Recorrido de columnas
            for (j = 0; j < right; j++){
                posx++;
                if (posx == slopeMap.length){
                    posx = 0;
                }
                if (posx< slopeMap.length && slopeMap[posy][posx]=='#'){
                    arbol++;
                }
            }
            if (posy<slopeMap.length-1){
                for (j=0; j<down; j++){
                    posy++;
                    if (posy<slopeMap.length){
                        if(slopeMap[posy][posx] == '#'){
                            arbol++;
                        }
                    }
                }
            } else {
                posy++;
            }
        }

        return arbol;
        }




    public static int jumpTheSlope ( char[][] slopeMap, int right, int down ){
        int posy = 0;
        int arbol = 0;
        int columnas = 0;
        int j;


        //Comprobación matriz cuadrada.
        for (char[] chars : slopeMap) {
            for (int l = 0; l < chars.length; l++) {
                columnas++;
            }
            if (columnas != slopeMap.length) {
                throw new IllegalArgumentException();
            }
            columnas = 0;
        }

        // Comprobación de caracteres.
        for (char[] chars : slopeMap) {
            for (j = 0; j < chars.length; j++) {
                if (chars[j] != '#' && chars[j] != '.') {
                    throw new IllegalArgumentException();
                }
            }
        }

        //Comprobación right - down.
        if(right >= slopeMap[0].length || right < 1){
            throw new IllegalArgumentException();
        }
        if(down >= slopeMap.length || down < 1){
            throw new IllegalArgumentException();
        }
        /////////////////////////

        for (int i = 0; i < slopeMap.length; i = i + down) {
            if (posy > slopeMap.length - 1) {
                posy = posy - slopeMap.length;
            }
            if (slopeMap[i][posy] == '#') {
                arbol++;
            }
            posy = posy + right;
        }
        return arbol;
    }
}



