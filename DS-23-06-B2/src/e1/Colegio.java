package e1;

import java.util.ArrayList;

public class Colegio {
    public  String imprimirRecompensa(ArrayList<PersonalLaboral> personalLaboral, ArrayList<Residentes> residentes){
        float totalRecompensa = 0;
        int defensa = 0, herbologia = 0, transformaciones = 0, historia = 0, pociones = 0;
        StringBuilder sb = new StringBuilder();
        if(!personalLaboral.isEmpty()){
            for (PersonalLaboral laboral : personalLaboral) {
                if (laboral.getEmpleo() == PersonalLaboral.Empleo.DOCENTE) {
                    if (laboral.getAsignatura() == Docentes.Asignatura.DEFENSA) {
                        defensa += 1;
                    } else if (laboral.getAsignatura() == Docentes.Asignatura.HERBOLOGIA) {
                        herbologia += 1;
                    } else if (laboral.getAsignatura() == Docentes.Asignatura.TRANSFORMACIONES) {
                        transformaciones += 1;
                    } else if (laboral.getAsignatura() == Docentes.Asignatura.HISTORIA) {
                        historia += 1;
                    } else if (laboral.getAsignatura() == Docentes.Asignatura.POCIONES) {
                        pociones += 1;
                    }
                }
                if (defensa > 1) {
                    throw new IllegalArgumentException();
                } else if (herbologia > 1) {
                    throw new IllegalArgumentException();
                } else if (transformaciones > 1) {
                    throw new IllegalArgumentException();
                } else if (historia > 1) {
                    throw new IllegalArgumentException();
                } else if (pociones > 1) {
                    throw new IllegalArgumentException();
                } else {
                    sb.append(laboral.toString() + ", " + laboral.getHorrocrux() + " horrocruxes): " + laboral.Recompensa() + " galeones. ").append("\n");
                    totalRecompensa += laboral.Recompensa();
                }
            }
        }
        if(!residentes.isEmpty()){
            for (Residentes residente : residentes) {
                sb.append(residente.toString()).append(", ").append(residente.getHorrocrux()).append(" horrocruxes): ").append(residente.Recompensa()).append(" galeones. ").append("\n");
                totalRecompensa += residente.Recompensa();
            }
        }

        sb.append("La recompensa total del Colegio Hogwarts es de ").append(totalRecompensa).append(" galeones.\n");
        return sb.toString().trim();
    }

    public  String imprimirSalarios(ArrayList<PersonalLaboral> personalLaboral){
        float totalSalary = 0;
        StringBuilder sb = new StringBuilder();
        int defensa = 0, herbologia = 0, transformaciones = 0, historia = 0, pociones = 0;
        for (PersonalLaboral laboral : personalLaboral) {
            if (laboral.getEmpleo() == PersonalLaboral.Empleo.DOCENTE) {
                if (laboral.getAsignatura() == Docentes.Asignatura.DEFENSA) {
                    defensa += 1;
                } else if (laboral.getAsignatura() == Docentes.Asignatura.HERBOLOGIA) {
                    herbologia += 1;
                } else if (laboral.getAsignatura() == Docentes.Asignatura.TRANSFORMACIONES) {
                    transformaciones += 1;
                } else if (laboral.getAsignatura() == Docentes.Asignatura.HISTORIA) {
                    historia += 1;
                } else if (laboral.getAsignatura() == Docentes.Asignatura.POCIONES) {
                    pociones += 1;
                }
            }
            if (defensa > 1) {
                throw new IllegalArgumentException();
            } else if (herbologia > 1) {
                throw new IllegalArgumentException();
            } else if (transformaciones > 1) {
                throw new IllegalArgumentException();
            } else if (historia > 1) {
                throw new IllegalArgumentException();
            } else if (pociones > 1) {
                throw new IllegalArgumentException();
            } else {
                sb.append(laboral.toString()).append("): ").append(laboral.Salario()).append(" galeones.").append("\n");
                totalSalary += laboral.Salario();
            }
        }
        sb.append("El gasto de Hogwarts en personal es de ").append(totalSalary).append(" galeones. \n");
        return sb.toString().trim();
    }
}
