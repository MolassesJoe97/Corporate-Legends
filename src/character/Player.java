package character;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class Player extends Character {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public int keys = 0;

    public final int screenX;
    public final int screenY;

    public Player (GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - gamePanel.tileSize/2;
        screenY = gamePanel.screenHeight/2 - gamePanel.tileSize/2;

        hitbox = new Rectangle();
        hitbox.x = 12;
        hitbox.y = 24;
        hitboxDefaultX = hitbox.x;
        hitboxDefaultY = hitbox.y;
        hitbox.width = 24;
        hitbox.height = 24;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues () {
        worldX = 0;
        worldY = 0;
        speed = 4;
    }

    public void getPlayerImage () {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/playerDown1")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/playerDown2")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
