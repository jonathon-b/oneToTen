package Utilities;

import java.awt.image.BufferedImage;

public class ImageSlicer {

    BufferedImage i;
    int rows,cols;

    public ImageSlicer(BufferedImage i, int cols, int rows){
        this.i=i;
        this.rows=rows; this.cols = cols;
    }

    public BufferedImage getSlice(int col, int row){
        return i.getSubimage((i.getWidth()/this.cols)*col,(i.getHeight()/this.rows)*row,i.getWidth()/this.cols+1,i.getHeight()/this.rows);
    }

}
