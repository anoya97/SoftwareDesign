package e2;

import java.util.List;
public class API_Dependencias implements TasreasManager, Dependencia{

    public void setTaskManager(TasreasManager taskManager) {
        this.taskManager = taskManager;
    }
    private TasreasManager taskManager = null;

    public void setDependenciasManager(Dependencia dependenciasManager){
        this.dependenciasManager = dependenciasManager;
    }
    private Dependencia dependenciasManager = null;


    @Override
    public List<Character> ordenEjecucion() {
        return dependenciasManager.ordenEjecucion();
    }

    @Override
    public void addTareaAOtraTarea(char x, char y) {
        taskManager.addTareaAOtraTarea(x, y);
    }


    @Override
    public boolean isEmptyMatriz() {
        return taskManager.isEmptyMatriz();
    }

    @Override
    public void removeTareaCol0(char x) {
        taskManager.removeTareaCol0(x);
    }
    @Override
    public void removeSubtareas(int pos){
        taskManager.removeSubtareas(pos);
    }
    @Override
    public boolean checkIfTareaEnSubMatriz(char x) {
        return taskManager.checkIfTareaEnSubMatriz(x);
    }

    @Override
    public int getPosicionCandidatoAEliminar(char x) {
        return taskManager.getPosicionCandidatoAEliminar(x);
    }

    @Override
    public void addSubtareas(int pos) {
        taskManager.addSubtareas(pos);
    }

    @Override
    public void reiniciarMatriz() {
        taskManager.reiniciarMatriz();
    }

    @Override
    public void removeTareasEnListas(List<Character> listaConOrden, List<Character> listaParaDecidir) {
        taskManager.removeTareasEnListas(listaConOrden, listaParaDecidir);
    }
}
