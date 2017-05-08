package com.srsh.view;

import com.srsh.model.Siding;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicSiding extends DrawableComponent {
    /**
     * constructor for graphical sidings with the component object and string path to img
     * @param siding
     */
    GraphicSiding(Siding siding) {
        super(siding);
        this.z_index = 2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(c.getPoint().x - 5, c.getPoint().y - 5, 10, 10);
        g.setColor(Color.BLACK);
    }
}
