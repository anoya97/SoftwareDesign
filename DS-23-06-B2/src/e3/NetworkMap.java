package e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class NetworkMap implements NetworkManager{
    private final Map <String, List<TopicOfInterest>> mapUsers = new HashMap<>();
    private final List <String> users = new ArrayList<>();
    private final List<TopicOfInterest> topicOfInterestsList = new ArrayList<>();

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if(user != null){
            topicOfInterestsList.addAll(topicsOfInterest);
            mapUsers.put(user, topicsOfInterest);
            users.add(user);
        }
    }
    @Override
    public void removeUser(String user) {
        if(user != null){
            mapUsers.remove(user);
            users.remove(user);
        } else throw new IllegalArgumentException();
    }
    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if(user != null){
            topicOfInterestsList.add(topicOfInterest);
            List <TopicOfInterest> lista1 = mapUsers.get(user);
            lista1.add(topicOfInterest);
            mapUsers.replace(user, lista1);
        } else throw new IllegalArgumentException();
    }
    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if(user != null && topicOfInterest != null){
            topicOfInterestsList.remove(topicOfInterest);
            List<TopicOfInterest> lista1 = mapUsers.get(user);
            lista1.remove(topicOfInterest);
            mapUsers.replace(user, lista1);
        } else throw new IllegalArgumentException();
    }
    @Override
    public List<String> getUsers() {
        return users;
    }
    @Override
    public List<TopicOfInterest> getInterest() {
        return topicOfInterestsList;
    }
    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        if(user != null){
            return mapUsers.get(user);
        } else throw new IllegalArgumentException();
    }
}