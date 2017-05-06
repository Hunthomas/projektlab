package com.srsh.model;

import java.awt.*;

/**
 * Created by Andras on 2017.04.15..
 */
public class CoalWagon extends TrainComponent{
    /**
     *
     * @param id
     */
    public CoalWagon(int id){
        super(id);
        System.out.print("created com.srsh.model.CoalWagon with id: ");
    }

    @Override
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if(next != null){
            ret += next.atStation(c, passengerNumber);
        }
        return ret;
    }

    @Override
    public void step() {
        Collection collection = current.getCollection();

        //ellenőrzi, hogy a végén van-e
        boolean atEnd = collection.myComponentAtEnd(this);

        //ha igen
        if(atEnd){
            //lekéri a következő pályaelemet
            Component next = current.getNext(previousComponent, this);

            //beállítja az aktuálisat és az előzőt
            previousComponent = current;
            current = next;

            //vagont helyez be
            //előző komponensünk megegyezik a jelenlegi A/B/C/D oldallal
            //akkor a jelenlegi komponensünk azon oldalára kell lehelyezni a vonatelemet
            if(previousComponent == current.getNextSide('A'))
                current.insert(this, 'A',0);
            else if(previousComponent == current.getNextSide('B'))
                current.insert(this, 'B',0);
            else if(previousComponent == current.getNextSide('C'))
                current.insert(this, 'C',0);
            else if(previousComponent == current.getNextSide('D'))
                current.insert(this, 'D',0);

        }

        System.out.println("which moved " + id + " new position " + current._getId() + " " + current.getCollection()._getMyPosition(this));

        //következőt lépteti ha van
        if(next != null)
            next.step();

    }

    @Override
    public void place(Component current, char side, int offset) {      // ??
        this.current = current;
        this.current.insert(this, side, offset);
        //TODO: ellenőrizni kell még hogy van-e már ott traincomponent
        if(next != null){
            next.place(current, side, offset + 40);
        }
    }

    @Override
    public void list(){
        System.out.println("com.srsh.model.Wagon "+ this.id +" on "+ this.current.id +  " at "+ "pos" +
                "; next: "+nextId+", previous: "+ previousId +";"+"\n"+ "collied "+ this.destroyed+"; destoyed "+this.destroyed+"; derailed "+derailed);
    }
}
