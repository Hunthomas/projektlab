
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Wagon implements TrainComponent {
    /**
     *
     */
    private TrainComponent next = null;

    /**
     *
     */
    private TrainComponent previous = null;

    /**
     * Default constructor
     */
    public Wagon() {
    }

    /**
     * Állomásra érve hívódik meg.
     * @param c Az állomás színe
     * @return
     */
    public void atStation(Color c) {
        System.out.println("[Wagon].atStation(c: Color)");
        if(next != null){ //ha van mögötte lévő kocsi akkor értesítjük hogy állomáson vagyunk
            //üresség vizsgálata itt még nem jelenik meg.
            next.atStation(c);
        }
    }

    /**
     * Vagon léptetési metódusa.
     * @param c  - őt hívó komponens
     * @return
     */
    @Override
    public void step() {
        System.out.println("[Wagon].step()");
        // TODO implement here
        //return null;
    }

    /**
     * Kisiklatja a kocsit
     * @return
     */
    public void derail() {
        System.out.println("[Wagon].derail()");
        if(next != null){ //ha van mögette lévő kocsi kisiklatjuk
            next.derail();
        }
    }

    /**
     * A kocsit követő elem beállítására szolgál.
     * @param tc - A következő elem a vonatban
     */
    public void setNext(TrainComponent tc){
        next = tc;
    }

    /**
     * A kocsit megelőző elem beállítására szolgál
     * @param tc
     */
    public void setPrevious(TrainComponent tc){
        previous = tc;
    }

}