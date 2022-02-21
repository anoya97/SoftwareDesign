package e1;

public class GuardaBosques extends PersonalLaboral{
    private final boolean nocturno;
    public GuardaBosques(String name, String lastName, int age, float horrocrux, Empleo empleo1, boolean nocturno) {
        super(name, lastName, age, horrocrux, empleo1);
        this.nocturno = nocturno;
    }
    @Override
    public float Recompensa() {
        return getHorrocrux() * 75;
    }
    @Override
    public int Salario() {
        if(nocturno){
            return 170 + 10;
        } else {
            return 170;
        }
    }

    @Override
    public boolean isNocturno() {
        return nocturno;
    }
    @Override
    public String toString() {
        return getName() + " " + getLastName() + " " + "(Guardabosque";
    }
    @Override
    public Docentes.Asignatura getAsignatura() {
        return null;
    }
}
