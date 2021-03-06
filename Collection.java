
import java.util.*;

/**
 * 
 */
public class Collection {

    ArrayList<TrainComponent> trainComponents;

    /**
     * Default constructor
     */
    public Collection() {
        trainComponents = new ArrayList<TrainComponent>();
    }


    /**
     * @param l
     */
    public void insert(TrainComponent l) {
        System.out.println("[Collection].insert(TrainComponent l)");
        trainComponents.add(l);
    }

    /**
     * @param l
     */
    public void remove(TrainComponent l) {
        System.out.println("[Collection].remove(TrainComponent l)");
        trainComponents.remove(l);
    }

    /**
     * @param l 
     * @return
     */
    public boolean myComponentAtEnd(TrainComponent l) {
        System.out.println("[Collection].myComponentAtEnd(TrainComponent l)");
        return false;
    }

    public TrainComponent getFirst(){
        if(trainComponents.isEmpty()){
            return null;
        } else {
            return trainComponents.get(0);
        }
    }

}