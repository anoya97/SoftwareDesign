package e1;


public class Residentes extends Integrantes {

    enum ResidenteTipo {
        FANTASMA, ESTUDIANTE
    }
    enum Casas{
        GRYFFINDOR, RAVENCLAW, SLYTHERIN, HUFFLEPUFF
    }

    public Casas getCasa() {
        return casa;
    }

    public ResidenteTipo getResidenteTipo() {
        return residenteTipo;
    }

    private final Residentes.Casas casa;
    private final Residentes.ResidenteTipo residenteTipo;
    public Residentes(String name, String lastName, int age, float horrocrux, Casas casa, ResidenteTipo residenteTipo) {
        super(name, lastName, age, horrocrux);
        this.casa = casa;
        this.residenteTipo = residenteTipo;
    }
    public float Recompensa (){
        if(this.residenteTipo == ResidenteTipo.ESTUDIANTE){
            if(this.casa == Casas.SLYTHERIN){
                return this.getHorrocrux()* 90 * 2;
            } else{
                return this.getHorrocrux()* 90;
            }
        } else if(this.residenteTipo == ResidenteTipo.FANTASMA){
            if(this.casa == Casas.SLYTHERIN){
                return this.getHorrocrux()* 80 * 2;
            } else{
                return this.getHorrocrux()* 80;
            }
        } return 0;
    }

    @Override
    public String toString() {
        if(residenteTipo == ResidenteTipo.FANTASMA){
            return getName() + " " + getLastName() + " (Fantasma de " + this.casa;
        }else {
            return getName() + " " + getLastName() + " (Estudiante de " + this.casa;
        }
    }

}
