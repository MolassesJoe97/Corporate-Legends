package main;

import character.Character;
//import object.Object;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker (GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Character entity) {
        int entityLeftWorldX = entity.worldX + entity.hitbox.x;
        int entityRightWorldX = entityLeftWorldX + entity.hitbox.width;
        int entityTopWorldY = entity.worldY + entity.hitbox.y;
        int entityBottomWorldY = entityTopWorldY + entity.hitbox.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileManager.tiles[tileNum1].canCollide || gp.tileManager.tiles[tileNum2].canCollide){
                    entity.collision = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileManager.tiles[tileNum1].canCollide || gp.tileManager.tiles[tileNum2].canCollide){
                    entity.collision = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileManager.tiles[tileNum1].canCollide || gp.tileManager.tiles[tileNum2].canCollide){
                    entity.collision = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileManager.tiles[tileNum1].canCollide || gp.tileManager.tiles[tileNum2].canCollide){
                    entity.collision = true;
                }
                break;
        }
    }
//    public int checkObject(Character entity, boolean player) {
//        int index = 999;
//
//        for (int i = 0; i < gp.obj.length; i++) {
//            if (gp.obj[i] != null) {
//                entity.hitbox.x = entity.worldX + entity.hitbox.x;
//                entity.hitbox.y = entity.worldY + entity.hitbox.y;
//
//                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
//                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
//
//                switch (entity.direction) {
//                    case "up":
//                        entity.hitbox.y -= entity.speed;
//                        if (entity.hitbox.intersects(gp.obj[i].solidArea)) {
//                            if (gp.obj[i].collision){
//                                entity.collisionOn = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "down":
//                        entity.solidArea.y += entity.speed;
//                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
//                            if (gp.obj[i].collision){
//                                entity.collisionOn = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "left":
//                        entity.solidArea.x -= entity.speed;
//                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
//                            if (gp.obj[i].collision){
//                                entity.collisionOn = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "right":
//                        entity.solidArea.x += entity.speed;
//                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
//                            if (gp.obj[i].collision){
//                                entity.collisionOn = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                }
//                entity.solidArea.x = entity.solidAreaDefaultX;
//                entity.solidArea.y = entity.solidAreaDefaultY;
//                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
//                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
//            }
//        }
//
//        return index;
//    }
}