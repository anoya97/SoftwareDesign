package e3;

import java.util.Objects;

public class TopicOfInterest {
    public TopicOfInterest(String topicOfInterest) {
        if (topicOfInterest != null){
            this.topicOfInterest = topicOfInterest;
        } else throw new IllegalArgumentException();
    }
    @Override
    public String toString() {
        return topicOfInterest ;
    }
    public String topicOfInterest;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicOfInterest that = (TopicOfInterest) o;
        return Objects.equals(topicOfInterest, that.topicOfInterest);
    }
}
