package e2;

import java.util.Collections;
import java.util.List;


public class DependenciaFuerte extends Tareas implements Dependencia {
    private void introducirEntradas(){
        addTareaAOtraTarea('C', 'A');
        addTareaAOtraTarea('C', 'F');
        addTareaAOtraTarea('A', 'B');
        addTareaAOtraTarea('A', 'D');
        addTareaAOtraTarea('B', 'E');
        addTareaAOtraTarea('D', 'E');
        addTareaAOtraTarea('F', 'E');
        addTareaAOtraTarea('G', 'F');
        addTareaAOtraTarea('G', 'H');
        addTareaAOtraTarea('F', 'J');
        addTareaAOtraTarea('H', 'J');
    }
    public static void main(String[] args) {
        DependenciaFuerte dependenciaFuerte = new DependenciaFuerte();
        dependenciaFuerte.introducirEntradas();

        dependenciaFuerte.ordenEjecucion();
        System.out.println("dependenciaFuerte.getListaConOrden() = " + dependenciaFuerte.getListaConOrden());
    }


    @Override
    public List<Character> ordenEjecucion() {
        for(int h = 0; h < getFILAS() && !isEmptyMatriz(); h++){
            for(int row = 0; row < getCOLUMNAS(); row ++){
                if(!checkIfTareaEnSubMatriz(getTareas()[row][0])){
                    getListaParaDecidir().add(getTareas()[row][0]);
                }
            }
            Collections.sort(getListaParaDecidir());
            if(!isEmptyMatriz()){
                getListaConOrden().add(getListaParaDecidir().get(0));
            }
            removeSubtareas(getPosicionCandidatoAEliminar(getListaParaDecidir().get(0)));
            removeTareaCol0(getListaParaDecidir().get(0));
            getListaParaDecidir().clear();
        }
        if(!isEmptyMatriz()){
            reiniciarMatriz();
        }
        return getListaConOrden();
    }
}
