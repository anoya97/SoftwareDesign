package e3;
import java.util.ArrayList;
import java.util.List;

public class NetworkMatrix implements NetworkManager {
    private final int COLUMNAS = 100;
    private final int FILAS = 100;
    private final String [][] usuarios = new String[FILAS][COLUMNAS];

    private int buscarEspacio(){
        for(int i = 0; i < FILAS; i++){
            if(usuarios[i][0] == null){
                return i;
            }
        }
        return 0;
    }
    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if(user != null){
            int j = buscarEspacio();
            usuarios[j][0] = user;
            for(int i = 0 ; i < topicsOfInterest.size(); i++){
                if(usuarios[j][i+1] == null){
                    usuarios[j][i+1] = topicsOfInterest.get(i).toString();
                }
            }
        } else throw new IllegalArgumentException();

    }
    @Override
    public void removeUser(String user) {
        if(user != null){
            int row;
            for(row = 0; row < FILAS && !user.equals(usuarios[row][0]); row++); // encontrar usuario.
            for(int row1 = 0; row1 < FILAS && usuarios[row1][0] != null; row1++){
                for( int col1 = 0; col1 < COLUMNAS && usuarios[row1][col1] != null; col1++){
                    usuarios[row][col1] = usuarios[row+1][col1];
                }
                row++;
            }
        } else throw new IllegalArgumentException();

    }
    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if(user != null){
            int row;
            for(row = 0; row < FILAS; row++){
                if(user.equals((usuarios[row][0]))){
                    break;
                }
            }

            for(int i = 0; i < COLUMNAS; i++ ){
                if(usuarios[row][i+1] == null){
                    usuarios[row][i+1] = String.valueOf(topicOfInterest);
                    break;
                }
            }
        } else throw new IllegalArgumentException();

    }
    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if (user != null){
            int row;
            int aux = 0;
            for(row = 0; row < FILAS && usuarios[row][0] != null; row++){
                if(user.equals((usuarios[row][0]))){
                    aux++;
                    break;
                }
            }
            int i;
            if (aux != 0){
                for(i = 0; i < COLUMNAS; i++ ){
                    if(usuarios[row][i].equals(String.valueOf(topicOfInterest))){
                        usuarios[row][i] = null;
                        break;
                    }
                }
                while((i < COLUMNAS) && (usuarios[row][i+1] != null)){
                    usuarios[row][i] = usuarios[row][i+1];
                    i++;
                }
            }
        } else throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        for(int row = 0; row < FILAS; row++){
            if(usuarios[row][0] != null){
                users.add(usuarios[row][0]);
            } else {
                break;
            }
        }
        return users;
    }
    @Override
    public List<TopicOfInterest> getInterest() {
        List<TopicOfInterest> intereses = new ArrayList<>();
        for(int row = 0; row < FILAS; row++){
            if(usuarios[row][0] == null){
                break;
            } else{
                for(int col = 1; col < COLUMNAS && usuarios[row][col] != null; col++){
                    intereses.add(new TopicOfInterest(usuarios[row][col]));
                }
            }
        }
        return intereses;
    }
    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        if (user != null) {
            List<TopicOfInterest> intereses = new ArrayList<>();
            //Creamos la lista en pincipio con los intereses del primer usuario.
            int row;
            int aux = 0;
            for (row = 0; row < FILAS; row++) {
                if (user.equals((usuarios[row][0]))) {
                    aux++;
                    break;
                }
            }
            if (aux != 0) {  // Si no se encuentra el usuario, devuelve nada.
                for (int i = 1; i < COLUMNAS && usuarios[row][i] != null; i++) {
                    intereses.add(new TopicOfInterest(usuarios[row][i]));
                }
            }
            return intereses;
        } else throw new IllegalArgumentException();
    }
}


