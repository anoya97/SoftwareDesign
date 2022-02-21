package e2;

import java.util.Collections;
import java.util.List;

public class DependenciaDebil extends Tareas implements Dependencia{
    private boolean primeraIter = true;
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
        DependenciaDebil dependenciaDebil = new DependenciaDebil();
        dependenciaDebil.introducirEntradas();

        System.out.println(dependenciaDebil.ordenEjecucion());
    }


    @Override
    public List<Character> ordenEjecucion() {
        for(int i = 0; i < getFILAS() && !isEmptyMatriz(); i++){
            if(primeraIter){
                for (int a = 0; a < getFILAS(); a++){
                    if(!checkIfTareaEnSubMatriz(getTareas()[a][0])){
                        getListaParaDecidir().add(getTareas()[a][0]);
                    }
                }
                Collections.sort(getListaParaDecidir());
                addSubtareas(getPosicionCandidatoAEliminar(getListaParaDecidir().get(0)));
                primeraIter = false;
            } else{
                Collections.sort(getListaParaDecidir());
                addSubtareas(getPosicionCandidatoAEliminar(getListaParaDecidir().get(0)));
            }
            if(getListaParaDecidir().size()!=0){
                getListaConOrden().add(getListaParaDecidir().get(0));}
            removeTareasEnListas(getListaConOrden(), getListaParaDecidir());
        }
        if(!isEmptyMatriz()){
            reiniciarMatriz();
        }
        return getListaConOrden();
    }
}
