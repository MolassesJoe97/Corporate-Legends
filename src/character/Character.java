package character;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Character {
    // Sprites
    BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    // Position and move speed
    public int worldX, worldY, speed;
    // Set default sprite to down
    public String direction = "down";

    // Sprite flags
    public int spriteCounter = 0;
    public int spriteNum = 1;

    // Hit box
    public Rectangle hitbox;
    public int hitboxDefaultX, hitboxDefaultY;
    public boolean collision = false;
}
