package e1;

public abstract class Integrantes {
    private final String name;
    private final String lastName;
    private final int age;
    private final float horrocrux;

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() { return age;}
    public float getHorrocrux() {
        return horrocrux;
    }

    public Integrantes(String name, String lastName, int age, float horrocrux) {
        if (name.equals("")){
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }
        if (lastName.equals("")){
            throw new IllegalArgumentException();
        } else {
            this.lastName = lastName;
        }
        if(age > 0){
            this.age = age;
        }
        else {
            throw new IllegalArgumentException();
        }
        if(horrocrux>=0){
            this.horrocrux = horrocrux;
        } else {
            throw new IllegalArgumentException();
        }

    }
    @Override
    public abstract String toString();
}
