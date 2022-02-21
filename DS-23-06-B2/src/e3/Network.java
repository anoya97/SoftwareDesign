package e3;

import java.util.ArrayList;
import java.util.List;

public class Network  implements NetworkManager{
    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }
    NetworkManager networkManager = null;
    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if (user == null|| user.equals("")){
            throw new IllegalArgumentException();
        } else{
            networkManager.addUser(user, topicsOfInterest);

        }
    }
    @Override
    public void removeUser(String user) {
        networkManager.removeUser(user);
    }
    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {

        networkManager.addInterest(user, topicOfInterest);

    }
    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest){
        networkManager.removeInterest(user, topicOfInterest);
    }
    @Override
    public List<String> getUsers() {
        return networkManager.getUsers();
    }
    @Override
    public List<TopicOfInterest> getInterest() {
        return networkManager.getInterest();
    }
    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return networkManager.getInterestsUser(user);
    }
    public  List<String> getUsersTopicInCommon(TopicOfInterest topicOfInterest){
        List<String> userArrayList = new ArrayList<>();
        for(int i = 0; i < networkManager.getUsers().size(); i++){
            List<TopicOfInterest> interesesLista = networkManager.getInterestsUser(networkManager.getUsers().get(i));
            if(interesesLista.contains(topicOfInterest)){
                userArrayList.add(networkManager.getUsers().get(i));
            }

        }
        return userArrayList;
    }
    public List<TopicOfInterest> getInterestsInCommon(String user1, String user2){
        List<TopicOfInterest> intereses;
        List<TopicOfInterest> interesesEnComun = new ArrayList<>();

        intereses=networkManager.getInterestsUser(user1);
        for (int i=0;i<networkManager.getInterestsUser(user2).size();i++){
            if (intereses.contains(networkManager.getInterestsUser(user2).get(i))){
                interesesEnComun.add(networkManager.getInterestsUser(user2).get(i));
            }
        }
        return interesesEnComun;
    }
    public String getInfoNetwork(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < networkManager.getUsers().size(); i++){
            sb.append(networkManager.getUsers().get(i)).append(" -> ");
            for (int j = 0; j < networkManager.getInterestsUser(networkManager.getUsers().get(i)).size(); j++){
                sb.append(networkManager.getInterestsUser(networkManager.getUsers().get(i)).get(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

}
