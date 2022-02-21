package e2;

import java.util.ArrayList;
import java.util.List;

public class Tareas implements TasreasManager{
    private final int COLUMNAS = 10;
    private final int FILAS = 20;
    private List<Character> listaConOrden = new ArrayList<>();
    private List<Character> listaParaDecidir = new ArrayList<>();
    private List<String> entradas = new ArrayList<>();
    private char[][] tareas = new char[FILAS][COLUMNAS];

    public int getCOLUMNAS() {
        return COLUMNAS;
    }
    public int getFILAS() {
        return FILAS;
    }
    public List<Character> getListaConOrden() {
        return listaConOrden;
    }
    public List<Character> getListaParaDecidir() {
        return listaParaDecidir;
    }
    public List<String> getEntradas(){
        return entradas;
    }
    public char[][] getTareas() {
        return tareas;
    }
    private int buscarEspacio(){
        for(int i = 0; i <= FILAS; i++){
            if(tareas[i][0] == '\0'){
                return i;
            }
        }
        return 0;
    }

    private void addTarea(char x) {
        if(x != '\0'){
            int aux = buscarEspacio();
            for(int row = 0; row < FILAS; row++){
                if(tareas[row][0] == x){
                    break;
                } else if(row == aux){
                    tareas[aux][0] = x;
                    break;
                }
            }
        } else throw new IllegalArgumentException();
    }

    @Override
    public void addTareaAOtraTarea(char x, char y) {
        int row, col;
        if(x != '\0' && y != '\0'){
            addTarea(x);
            addTarea(y);
            for(row = 0; row < FILAS && tareas[row][0] != x; row++); // Encontrar fila para añadir la tarea sucesiva.
            for(col = 1; col < COLUMNAS && tareas[row][col] != 0; col++); // Encontrar espacio en la matriz en las columnas.
            tareas[row][col] = y;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void removeTareaCol0(char x) {
        int row;
        if(x != '\0'){
            for(row = 0; row < FILAS; row++){
                if (tareas[row][0] == x){
                    tareas[row][0] = 0;
                }
            }
        } else throw new IllegalArgumentException();
    }

    @Override
    public void removeSubtareas(int pos){
        for(int i = 1; i < COLUMNAS; i++){
            tareas[pos][i] = '\0';
        }
    }

    @Override
    public boolean checkIfTareaEnSubMatriz(char x) {
        int col, row;
        char[][] subMatriz = getTareas();
        for(row = 0; row < getFILAS(); row++){
            for (col = 1; col < getCOLUMNAS(); col++){
                if(subMatriz[row][col] == x){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getPosicionCandidatoAEliminar(char x) {
        for(int row = 0; row < getFILAS(); row++){
            if(x == getTareas()[row][0]){
                return row;
            }
        }
        return -1;
    }

    @Override
    public void addSubtareas(int pos) {
        if(!getListaParaDecidir().isEmpty()){
            for(int col = 0; col < getCOLUMNAS(); col++){
                if(getTareas()[pos][col] != '\0'){
                    if(!getListaParaDecidir().contains(getTareas()[pos][col])){
                        if(!getListaConOrden().contains(getTareas()[pos][col])){
                            if(getTareas()[pos][col] != '\0')
                                getListaParaDecidir().add(getTareas()[pos][col]);
                        }
                    }
                } else break;
            }
            removeSubtareas(pos);
            removeTareaCol0(getListaParaDecidir().get(0));
        }
    }

    @Override
    public boolean isEmptyMatriz(){
        for(int i = 0; i < getFILAS(); i++){
            for(int j = 0; j < getCOLUMNAS(); j++){
                if(getTareas()[i][j] != '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void reiniciarMatriz(){
        if(!isEmptyMatriz()){
            for(int row = 0; row < getFILAS(); row++){
                for(int col = 0; col < getCOLUMNAS(); col++){
                    getTareas()[row][col] = '\0';
                }
            }
        }
    }
    @Override
    public void removeTareasEnListas(List<Character> listaConOrden, List<Character> listaParaDecidir){
        for (Character character : listaConOrden) {
            listaParaDecidir.remove(character);
        }
    }

    public void addToMatrix(List<String> entradas) {
        for(int i = 0; i < entradas.size(); i++){
            for(int j = 0; entradas.get(i).charAt(j) != '\0'; j++){
                if(entradas.get(i).charAt(j) != '-' || entradas.get(i).charAt(j) != '>' || entradas.get(i).charAt(j) != 'Ñ' || entradas.get(i).charAt(j) != 'Ç'){
                    addTareaAOtraTarea('s', 'a');
                }
            }

        }
    }
}
