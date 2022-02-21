package e2;

import java.util.List;

public interface TasreasManager {
     void addTareaAOtraTarea(char x, char y);
     boolean isEmptyMatriz();
     void removeTareaCol0(char x);
     void removeSubtareas(int pos);
     boolean checkIfTareaEnSubMatriz(char x);
     int getPosicionCandidatoAEliminar(char x);
     void addSubtareas(int pos);
     void reiniciarMatriz();
     void removeTareasEnListas(List<Character> listaConOrden, List<Character> listaParaDecidir);
}