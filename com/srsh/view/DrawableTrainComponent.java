package com.srsh.view;

import com.srsh.model.TrainComponent;

import java.awt.*;

/**
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public  abstract class DrawableTrainComponent extends Drawable {
    protected TrainComponent tc;

    public DrawableTrainComponent(TrainComponent tc, String image){
        super(image);
        this.tc = tc;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, 10, 10, 100, 100, null);
    }
}
