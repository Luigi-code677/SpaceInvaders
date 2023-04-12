/**
 *
 */
package viewEntity;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import constants.DefaultRoot;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class Invader {
    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private boolean isVis;
    private String stringImage;
    private final Image IMG_INVADER;

    public Invader(int xPosition, int yPosition, String stringImage) {
        this.width = DefaultRoot.WIDTH_INVADER;
        this.height = DefaultRoot.HEIGHT_INVADER;
        this.isVis = true;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.stringImage = stringImage;
        IMG_INVADER = new ImageIcon(Objects.requireNonNull(getClass().getResource(this.stringImage))).getImage();
    }

    public boolean isVis() {
        return isVis;
    }

    public void setVis(boolean isVis) {
        this.isVis = isVis;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getStringImage() {
        return stringImage;
    }

    public void setStringImage(String stringImage) {
        this.stringImage = stringImage;
    }

    public Image getImgInvader() {
        return IMG_INVADER;
    }

}
