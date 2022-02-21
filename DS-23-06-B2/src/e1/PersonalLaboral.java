package e1;

public abstract class PersonalLaboral extends Integrantes {
    enum Empleo {
        DOCENTE, GUARDABOSQUE, CONSERJE
    }

    private final PersonalLaboral.Empleo empleo;
    public PersonalLaboral(String name, String lastName, int age, float horrocrux, Empleo empleo) {
        super(name, lastName, age, horrocrux);
        this.empleo = empleo;
    }
    public Empleo getEmpleo() {
        return empleo;
    }

    public abstract Docentes.Asignatura getAsignatura();

    public abstract float Recompensa();

    public abstract  int Salario();

    public abstract boolean isNocturno();

}
