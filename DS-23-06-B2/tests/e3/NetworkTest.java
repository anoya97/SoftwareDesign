package e3;

import e2.Apartamentos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class NetworkTest {
    Network network = new Network();
    @Test
    void NetworkMatrix(){
        NetworkMatrix networkMatrix = new NetworkMatrix();
        List<TopicOfInterest> topicOfInterestList = new ArrayList<>();

        network.setNetworkManager(networkMatrix);
        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest animales = new TopicOfInterest("Animales");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        network.addUser("Angel", topicOfInterestList);
        network.addUser("Ruben", topicOfInterestList);
        network.addUser("Roberto", topicOfInterestList);
        network.addUser("Blanca", topicOfInterestList);
        topicOfInterestList.add(musica);
        network.addUser("Sofia", topicOfInterestList);
        network.addInterest("Angel", futbol);
        network.addInterest("Ruben", animales);
        network.addInterest("Blanca", danza);

        assertEquals("Angel", network.getUsers().get(0));
        assertEquals("Ruben", network.getUsers().get(1));
        assertEquals("Roberto", network.getUsers().get(2));
        assertEquals("Blanca", network.getUsers().get(3));
        assertEquals("Sofia", network.getUsers().get(4));

        assertEquals(futbol.toString(), network.getInterest().get(0).toString());
        assertEquals(animales.toString(), network.getInterest().get(1).toString());
        assertEquals(danza.toString(), network.getInterest().get(2).toString());
        assertEquals(musica.toString(), network.getInterest().get(3).toString());

        network.removeUser("Angel");
        assertEquals("Ruben", network.getUsers().get(0));
        assertEquals("Roberto", network.getUsers().get(1));
        assertEquals("Blanca", network.getUsers().get(2));
        assertEquals("Sofia", network.getUsers().get(3));


        assertEquals(animales.toString(),network.getInterestsUser("Ruben").get(0).toString());
        network.addInterest("Ruben", musica);
        assertEquals(animales.toString(),network.getInterestsUser("Ruben").get(0).toString());
        assertEquals(musica.toString(),network.getInterestsUser("Ruben").get(1).toString());
        network.removeInterest("Ruben", animales);
        assertEquals(musica.toString(),network.getInterestsUser("Ruben").get(0).toString());
    }

    @Test
    void NetworkMap(){
        NetworkMap networkMap = new NetworkMap();
        network.setNetworkManager(networkMap);

        List<TopicOfInterest> topicOfInterestListAngel = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListRuben = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListBlanca = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListSofia = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListRoberto = new ArrayList<>();


        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest animales = new TopicOfInterest("Animales");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        network.addUser("Angel", topicOfInterestListAngel);
        network.addUser("Ruben", topicOfInterestListRuben);
        network.addUser("Roberto", topicOfInterestListRoberto);
        network.addUser("Blanca", topicOfInterestListBlanca);
        topicOfInterestListSofia.add(musica);
        network.addUser("Sofia", topicOfInterestListSofia);
        network.addInterest("Angel", futbol);
        network.addInterest("Ruben", animales);
        network.addInterest("Blanca", danza);

        assertEquals("Angel", network.getUsers().get(0));
        assertEquals("Ruben", network.getUsers().get(1));
        assertEquals("Roberto", network.getUsers().get(2));
        assertEquals("Blanca", network.getUsers().get(3));
        assertEquals("Sofia", network.getUsers().get(4));

        assertEquals(futbol.toString(), network.getInterest().get(1).toString());
        assertEquals(animales.toString(), network.getInterest().get(2).toString());
        assertEquals(danza.toString(), network.getInterest().get(3).toString());
        assertEquals(musica.toString(), network.getInterest().get(0).toString());

        network.removeUser("Angel");
        assertEquals("Ruben", network.getUsers().get(0));
        assertEquals("Roberto", network.getUsers().get(1));
        assertEquals("Blanca", network.getUsers().get(2));
        assertEquals("Sofia", network.getUsers().get(3));


        assertEquals(animales.toString(),network.getInterestsUser("Ruben").get(0).toString());
        network.addInterest("Ruben", musica);
        assertEquals(animales.toString(),network.getInterestsUser("Ruben").get(0).toString());
        assertEquals(musica.toString(),network.getInterestsUser("Ruben").get(1).toString());
        network.removeInterest("Ruben", animales);
        assertEquals(musica.toString(),network.getInterestsUser("Ruben").get(0).toString());

    }

    @Test
    void getUseresTopicInCommonMatrix(){
        List<TopicOfInterest> topicOfInterestList = new ArrayList<>();
        NetworkMatrix networkMatrix = new NetworkMatrix();
        network.setNetworkManager(networkMatrix);
        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest animales = new TopicOfInterest("Animales");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        network.addUser("Angel", topicOfInterestList);
        network.addUser("Ruben", topicOfInterestList);
        network.addUser("Roberto", topicOfInterestList);
        network.addUser("Blanca", topicOfInterestList);
        network.addUser("Sofia", topicOfInterestList);
        network.addInterest("Angel", futbol);
        network.addInterest("Angel", musica);
        network.addInterest("Sofia", musica);
        network.addInterest("Ruben", animales);
        network.addInterest("Blanca", danza);

        assertEquals("[Angel, Sofia]", network.getUsersTopicInCommon(musica).toString());
        assertEquals("[Angel]", network.getUsersTopicInCommon(futbol).toString());
    }

    @Test
    void getUseresTopicInCommonMap(){
        NetworkMap networkMap = new NetworkMap();
        network.setNetworkManager(networkMap);

        List<TopicOfInterest> topicOfInterestListAngel = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListRuben = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListBlanca = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListSofia = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListRoberto = new ArrayList<>();

        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest animales = new TopicOfInterest("Animales");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        network.addUser("Angel", topicOfInterestListAngel);
        network.addUser("Ruben", topicOfInterestListRuben);
        network.addUser("Roberto", topicOfInterestListRoberto);
        network.addUser("Blanca", topicOfInterestListBlanca);
        network.addUser("Sofia", topicOfInterestListSofia);
        network.addInterest("Angel", futbol);
        network.addInterest("Angel", musica);
        network.addInterest("Ruben", animales);
        network.addInterest("Sofia", musica);
        network.addInterest("Blanca", danza);

        assertEquals("[Angel, Sofia]", network.getUsersTopicInCommon(musica).toString());
        assertEquals("[Angel]", network.getUsersTopicInCommon(futbol).toString());
    }

    @Test
    void getInterestsInCommonMatrix(){
        List<TopicOfInterest> topicOfInterestList = new ArrayList<>();
        NetworkMatrix networkMatrix = new NetworkMatrix();
        network.setNetworkManager(networkMatrix);
        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest animales = new TopicOfInterest("Animales");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        network.addUser("Angel", topicOfInterestList);
        network.addUser("Ruben", topicOfInterestList);
        network.addUser("Roberto", topicOfInterestList);
        network.addUser("Blanca", topicOfInterestList);
        network.addUser("Sofia", topicOfInterestList);
        network.addInterest("Angel", futbol);
        network.addInterest("Angel", musica);
        network.addInterest("Sofia", musica);
        network.addInterest("Ruben", animales);
        network.addInterest("Blanca", danza);

        assertEquals("[Musica]", network.getInterestsInCommon("Angel", "Sofia").toString());
        assertEquals("[]", network.getInterestsInCommon("Angel", "Blanca").toString());
    }

    @Test
    void getInterestsInCommonMap(){
        NetworkMap networkMap = new NetworkMap();
        network.setNetworkManager(networkMap);

        List<TopicOfInterest> topicOfInterestListAngel = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListRuben = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListBlanca = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListSofia = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListRoberto = new ArrayList<>();


        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest animales = new TopicOfInterest("Animales");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        network.addUser("Angel", topicOfInterestListAngel);
        network.addUser("Ruben", topicOfInterestListRuben);
        network.addUser("Roberto", topicOfInterestListRoberto);
        network.addUser("Blanca", topicOfInterestListBlanca);
        network.addUser("Sofia", topicOfInterestListSofia);
        network.addInterest("Angel", futbol);
        network.addInterest("Angel", musica);
        network.addInterest("Ruben", animales);
        network.addInterest("Sofia", musica);
        network.addInterest("Blanca", danza);

        assertEquals("[Musica]", network.getInterestsInCommon("Angel", "Sofia").toString());
        assertEquals("[]", network.getInterestsInCommon("Ruben", "Angel").toString());
    }
    
    @Test
    void getInfoNetworkMap(){
        List<TopicOfInterest> topicOfInterestListRuben = new ArrayList<>();
        List<TopicOfInterest> topicOfInterestListBlanca = new ArrayList<>();

        List<String> usuarios = new ArrayList<>();
        NetworkMap networkMap = new NetworkMap();
        network.setNetworkManager(networkMap);

        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        TopicOfInterest deportes = new TopicOfInterest("Deportes");
        network.addUser("Ruben", topicOfInterestListRuben);
        network.addUser("Blanca", topicOfInterestListBlanca);

        network.addInterest("Ruben", futbol);
        network.addInterest("Ruben", deportes);
        network.addInterest("Blanca", danza);
        network.addInterest("Blanca", musica);
        assertEquals("Ruben -> Futbol Deportes \n" +
                "Blanca -> Danza Musica", network.getInfoNetwork());
    }

    @Test
    void getInfoNetworkMatrix(){
        List<TopicOfInterest> topicOfInterestList = new ArrayList<>();
        NetworkMatrix networkMatrix = new NetworkMatrix();
        network.setNetworkManager(networkMatrix);

        TopicOfInterest danza = new TopicOfInterest("Danza");
        TopicOfInterest futbol = new TopicOfInterest("Futbol");
        TopicOfInterest musica = new TopicOfInterest("Musica");
        TopicOfInterest deportes = new TopicOfInterest("Deportes");
        network.addUser("Ruben", topicOfInterestList);
        network.addUser("Blanca", topicOfInterestList);

        network.addInterest("Ruben", futbol);
        network.addInterest("Ruben", deportes);
        network.addInterest("Blanca", danza);
        network.addInterest("Blanca", musica);
        assertEquals("Ruben -> Futbol Deportes \n" +
                "Blanca -> Danza Musica", network.getInfoNetwork());
    }

    @Test
    void testExceptionsMap (){
        NetworkMap networkMap = new NetworkMap();
        network.setNetworkManager(networkMap);
        List<TopicOfInterest> topicOfInterestListBlanca = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> new TopicOfInterest(null));
        assertThrows(IllegalArgumentException.class, () -> network.addUser(null,topicOfInterestListBlanca));
        assertThrows(IllegalArgumentException.class, () -> network.removeUser(null));
        assertThrows(IllegalArgumentException.class, () -> network.getInterestsUser(null));
    }

}