package e2;

import java.util.Collections;
import java.util.List;

public class OrdenJerarquico extends Tareas implements Dependencia{
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
        OrdenJerarquico ordenJerarquico = new OrdenJerarquico();
        ordenJerarquico.introducirEntradas();

        System.out.println(ordenJerarquico.ordenEjecucion());

    }

    @Override
    public List<Character> ordenEjecucion() {
        for(int i = 0; i < getFILAS() && !isEmptyMatriz(); i++){
            if(primeraIter){
                for (int j = 0; j < getFILAS(); j++){
                    if(!checkIfTareaEnSubMatriz(getTareas()[j][0])){
                        getListaParaDecidir().add(getTareas()[j][0]);
                    }
                }
                Collections.sort(getListaParaDecidir());
                for(int h = 0; h < getListaParaDecidir().size(); h++){
                    getListaConOrden().add(getListaParaDecidir().get(h));
                }
                for(int f = 0; f < getListaConOrden().size(); f++){
                    addSubtareas(getPosicionCandidatoAEliminar(getListaParaDecidir().get(f)));
                }
                removeTareasEnListas(getListaConOrden(), getListaParaDecidir());
                primeraIter = false;
            } else{
                if(!getListaParaDecidir().isEmpty()) {
                    Collections.sort(getListaParaDecidir());
                    for (int h = 0; h < getListaParaDecidir().size(); h++) {
                        getListaConOrden().add(getListaParaDecidir().get(h));
                    }
                    int aux = 0;
                    for(int g = 0; g < getListaConOrden().size(); g++){
                        if(getListaParaDecidir().get(0) == getListaConOrden().get(g)){
                            aux = g;
                        }
                    }
                    for (int d = aux; d < getListaParaDecidir().size(); d++) {
                        if (getListaConOrden().size() > d && getPosicionCandidatoAEliminar(getListaConOrden().get(d)) != -1) {
                            addSubtareas(getPosicionCandidatoAEliminar(getListaConOrden().get(d)));
                        }
                    }
                    removeTareasEnListas(getListaConOrden(), getListaParaDecidir());
                }
            }
        }
        if(!isEmptyMatriz()){
            reiniciarMatriz();
        }
        return getListaConOrden();
    }

}
