package e1;

public class Docentes extends PersonalLaboral{
    enum Asignatura{
        DEFENSA, HERBOLOGIA, HISTORIA, POCIONES, TRANSFORMACIONES
    }
    private final Docentes.Asignatura asignatura;

    public Docentes(String name, String lastName, int age, float horrocrux, PersonalLaboral.Empleo empleo1, Asignatura asignatura) {
        super(name, lastName, age, horrocrux, empleo1);
        this.asignatura = asignatura;
    }
    public Asignatura getAsignatura() {
        return asignatura;
    }
    @Override
    public float Recompensa() {
        if(this.asignatura == Asignatura.DEFENSA){
            return 0.75f * getHorrocrux() * 50;
        } else {
            return getHorrocrux() * 50;
        }
    }

    @Override
    public int Salario() {
        if(this.asignatura == Asignatura.DEFENSA){
            return 500;
        } else if(this.asignatura == Asignatura.TRANSFORMACIONES){
            return 400;
        } else if(this.asignatura == Asignatura.POCIONES){
            return 350;
        } else if(this.asignatura == Asignatura.HERBOLOGIA){
            return 250;
        } else if (this.asignatura == Asignatura.HISTORIA){
            return 200;
        }
        return 0;
    }
    @Override
    public boolean isNocturno() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + " " + getLastName() + " " + "(Docente de " + asignatura;
    }


}
