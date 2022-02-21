package e1;

public class Conserjes extends PersonalLaboral{
    private final boolean nocturno;
    public Conserjes(String name, String lastName, int age, float horrocrux, Empleo empleo1, boolean nocturno) {
        super(name, lastName, age, horrocrux, empleo1);
        this.nocturno = nocturno;
    }

    public boolean isNocturno() {
        return nocturno;
    }
    @Override
    public Docentes.Asignatura getAsignatura() {
        return null;
    }
    @Override
    public float Recompensa() {
        return getHorrocrux() * 65;
    }
    @Override
    public int Salario() {
        if(nocturno){
            return 150 + 10;
        } else {
            return 150;
        }
    }
    @Override
    public String toString() {
        return getName() + " " + getLastName() + " " + "(Conserje";
    }
}
