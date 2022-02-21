package e2;

import org.junit.jupiter.api.Test;

class API_DependenciasTest {
    API_Dependencias api_dependencias = new API_Dependencias();

    @Test
    void DependenciaDebil(){
        DependenciaDebil dependenciaDebil = new DependenciaDebil();
        api_dependencias.setDependenciasManager(dependenciaDebil);

        dependenciaDebil.addTareaAOtraTarea('C', 'A');
        dependenciaDebil.addTareaAOtraTarea('C', 'F');
        dependenciaDebil.addTareaAOtraTarea('A', 'B');
        dependenciaDebil.addTareaAOtraTarea('A', 'D');
        dependenciaDebil.addTareaAOtraTarea('B', 'E');
        dependenciaDebil.addTareaAOtraTarea('D', 'E');
        dependenciaDebil.addTareaAOtraTarea('F', 'E');
        dependenciaDebil.addTareaAOtraTarea('G', 'F');
        dependenciaDebil.addTareaAOtraTarea('G', 'H');
        dependenciaDebil.addTareaAOtraTarea('F', 'J');
        dependenciaDebil.addTareaAOtraTarea('H', 'J');

        dependenciaDebil.getTareas();
        dependenciaDebil.ordenEjecucion();
    }

    @Test
    void DependenciaFuerte(){
        DependenciaFuerte dependenciaFuerte= new DependenciaFuerte();
        api_dependencias.setDependenciasManager(dependenciaFuerte);

        dependenciaFuerte.addTareaAOtraTarea('C', 'A');
        dependenciaFuerte.addTareaAOtraTarea('C', 'F');
        dependenciaFuerte.addTareaAOtraTarea('A', 'B');
        dependenciaFuerte.addTareaAOtraTarea('A', 'D');
        dependenciaFuerte.addTareaAOtraTarea('B', 'E');
        dependenciaFuerte.addTareaAOtraTarea('D', 'E');
        dependenciaFuerte.addTareaAOtraTarea('F', 'E');
        dependenciaFuerte.addTareaAOtraTarea('G', 'F');
        dependenciaFuerte.addTareaAOtraTarea('G', 'H');
        dependenciaFuerte.addTareaAOtraTarea('F', 'J');
        dependenciaFuerte.addTareaAOtraTarea('H', 'J');
    }
    @Test
    void OrdenJerarquico(){
        OrdenJerarquico ordenJerarquico= new OrdenJerarquico();
        api_dependencias.setDependenciasManager(ordenJerarquico);

        ordenJerarquico.addTareaAOtraTarea('C', 'A');
        ordenJerarquico.addTareaAOtraTarea('C', 'F');
        ordenJerarquico.addTareaAOtraTarea('A', 'B');
        ordenJerarquico.addTareaAOtraTarea('A', 'D');
        ordenJerarquico.addTareaAOtraTarea('B', 'E');
        ordenJerarquico.addTareaAOtraTarea('D', 'E');
        ordenJerarquico.addTareaAOtraTarea('F', 'E');
        ordenJerarquico.addTareaAOtraTarea('G', 'F');
        ordenJerarquico.addTareaAOtraTarea('G', 'H');
        ordenJerarquico.addTareaAOtraTarea('F', 'J');
        ordenJerarquico.addTareaAOtraTarea('H', 'J');
    }
}