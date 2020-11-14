package starter;

import java.util.ArrayList;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Level {
	private int levelNumber;
	
	private int numberOfEnemiesLight;
	private int numberOfEnemiesMedium;
	private int numberOfEnemiesHeavy;
	private int numberOfPlayers;
	
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Shield> shields = new ArrayList<Shield>();
	ArrayList<CharacterEntity> users = new ArrayList<CharacterEntity>();
	ArrayList<GRect> enemyRectangles = new ArrayList<GRect>();
	
	Projectile enemyProjectile = new Projectile(5);
	Projectile userProjectile = new Projectile(5);
	Hitbox userHitbox = new Hitbox(50, 70);
	Hitbox enemyHitbox = new Hitbox(50, 70);
	CharacterEntity user = new CharacterEntity(100, 50, false, 800, 800, userProjectile, userHitbox);
	
	EnemyType typeLight = new EnemyType(50, 10, enemyHitbox, EnemyTypeCode.LIGHT);
	 
	EnemyType typeMedium = new EnemyType(100, 20, enemyHitbox, EnemyTypeCode.MEDIUM);
	 
	EnemyType typeHeavy = new EnemyType(200, 50, enemyHitbox, EnemyTypeCode.HEAVY);
	
	Shield tempGameShield1 = new Shield(100, 200, 500, 200, 700);
	Shield tempGameShield2 = new Shield(100, 200, 500, 200, 700);
	
	public Level(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	public GRect createUser() {
		GRect userRect = new GRect(user.getCoordX(), user.getCoordY(), user.getUserHitbox().getHeight(), user.getUserHitbox().getWidth());
		return userRect;
	}
	public void placeScoreSystem() {
		
	}
	
	public int getNumberOfEnemiesLight() {
		return numberOfEnemiesLight;
	}
	public void setNumberOfEnemiesLight(int numberOfEnemiesLight) {
		this.numberOfEnemiesLight = numberOfEnemiesLight;
	}
	public int getNumberOfEnemiesMedium() {
		return numberOfEnemiesMedium;
	}
	public void setNumberOfEnemiesMedium(int numberOfEnemiesMedium) {
		this.numberOfEnemiesMedium = numberOfEnemiesMedium;
	}
	public int getNumberOfEnemiesHeavy() {
		return numberOfEnemiesHeavy;
	}
	public void setNumberOfEnemiesHeavy(int numberOfEnemiesHeavy) {
		this.numberOfEnemiesHeavy = numberOfEnemiesHeavy;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	
	public Enemy makeEnemy(EnemyType type, boolean isDestroyed, int coordX, int coordY, Projectile enemyProjectile) {
		Enemy temp = new Enemy(type, isDestroyed, coordX, coordY, enemyProjectile);
		return temp;
	}
	public void initLevel() {
		int tempX = 0; //Used in order to keep all X coordinates equal throughout each row
		if(levelNumber == 1) {
			numberOfEnemiesLight = 30;
			for(int i = 0; i < 31; i++) {
				tempX++;
				if(i < 10) { //layer one
					Enemy enemyLight = makeEnemy(typeLight, false, 80 + (80 * tempX), 50 , enemyProjectile);
					enemies.add(enemyLight);
					if(tempX == 10) { //Resets tempX at the end of each row
						tempX = 0;
					}
					
				} if(i > 9 && i < 20) { //layer two
					Enemy light2 = makeEnemy(typeLight, false, 80 + (80 * tempX), 150 , enemyProjectile);
					enemies.add(light2);
					if(tempX == 10) {
						tempX = 0;
					}
					
				} if(i > 20 && i < 31) { //layer three
					Enemy light3 = makeEnemy(typeLight, false, 80 + (80 * tempX), 250 , enemyProjectile);
					enemies.add(light3);
					if(tempX == 10) {
						tempX = 0;
					}
				}
			}
			shields.add(tempGameShield1);
			shields.add(tempGameShield2);
		}
		if(levelNumber == 2) {
			numberOfEnemiesLight = 20;
			numberOfEnemiesMedium = 10;
			for(int i = 0; i < 31; i++) {
				tempX++;
				if(i < 10) { //layer one
					Enemy medium = new Enemy(typeMedium, false, 80 + (80 * tempX), 50 , enemyProjectile);
					enemies.add(medium);
					if(tempX == 10) {
						tempX = 0;
					}
				} if(i > 9 && i < 20) { //layer two
					Enemy light1 = new Enemy(typeLight, false, 80 + (80 * tempX), 150 , enemyProjectile);
					enemies.add(light1);
					if(tempX == 10) {
						tempX = 0;
					}
				} if(i > 20 && i < 31) { //layer three
					Enemy light2 = new Enemy(typeLight, false, 80 + (80 * tempX), 250 , enemyProjectile);
					enemies.add(light2);
					if(tempX == 10) {
						tempX = 0;
					}
				}
			}
			shields.add(tempGameShield1);
			shields.add(tempGameShield2);
		}
		
		if(levelNumber == 3) {
			numberOfEnemiesLight = 10;
			numberOfEnemiesMedium = 10;
			numberOfEnemiesHeavy = 10;
			for(int i = 0; i < 31; i++) {
				tempX++;
				if(i < 10) { //layer one
					Enemy heavy = new Enemy(typeHeavy, false, 80 + (80 * tempX), 50 , enemyProjectile);
					enemies.add(heavy);
					if(tempX == 10) {
						tempX = 0;
					}
				} if(i > 9 && i < 20) { //layer two
					Enemy medium = new Enemy(typeMedium, false, 80 + (80 * tempX), 150 , enemyProjectile);
					enemies.add(medium);
					if(tempX == 10) {
						tempX = 0;
					}
				} if(i > 20 && i < 31) { //layer three
					Enemy light = new Enemy(typeLight, false, 80 + (80 * tempX), 250 , enemyProjectile);
					enemies.add(light);
					if(tempX == 10) {
						tempX = 0;
					}
				}
			}
			shields.add(tempGameShield1);
			shields.add(tempGameShield2);
		}
	}
	public void printArrayList() { //Prints the arrayList 
		System.out.println("size: " + enemies.size());
		System.out.println("size of Shields: " + shields.size());
		for(Enemy temp : enemies) {
			System.out.println("CoordX: " + temp.getCordinateX() + " CoordY: " + temp.getCordinateY() + " Enemy Type: " + temp.getTypeOfEnemy().geteTypeCode());
		}
	}
	
	public ArrayList<GRect> createEnemyRect() { //Creates new GRects to be called in Gameplay.java
		GRect tempRec;
		for(Enemy temp : enemies) {
			tempRec = new GRect(temp.getCordinateX(), temp.getCordinateY(), temp.getTypeOfEnemy().getEnemyHitbox().getWidth(), temp.getTypeOfEnemy().getEnemyHitbox().getHeight());
			enemyRectangles.add(tempRec);
		}
		return enemyRectangles;
	}
	public void placeShield() {
		
	}
	public void clearEnemyList() {
		if (enemies.size() != 0) {
			enemies.clear();
		}
		else {
			System.out.println("Enemies Arraylist already clear");
		}
	}
	public void destroyEnemy(int coordX, int coordY) {
		for (Enemy temp : enemies) {
			if (coordX == temp.getCordinateX() && coordY == temp.getCordinateY()) {
				Enemy tempEnemy = new Enemy(temp.getTypeOfEnemy(), temp.isDestroyed(), temp.getCordinateX(), temp.getCordinateY(), temp.getEnemyProjectile());
				enemies.remove(tempEnemy);
			}
		}
	}
}
//oui