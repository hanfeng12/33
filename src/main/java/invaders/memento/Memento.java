package invaders.memento;

import invaders.engine.GameEngine;
import invaders.factory.Projectile;
import invaders.gameobject.Enemy;
import invaders.gameobject.GameObject;
import invaders.rendering.Renderable;

import java.util.ArrayList;
import java.util.List;

public class Memento {


    private int score = 0;
    private int myFPSTimer = 0;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private ArrayList<Double> xs = new ArrayList<>();
    private ArrayList<Integer> xdels = new ArrayList<>();
    private ArrayList<Double> ys = new ArrayList<>();

    private List<Renderable> renderables =  new ArrayList<>();

    double playerx;
    double playery;
    public Memento(GameEngine gameEngine)
    {
        this.score = gameEngine.getScore();
        this.myFPSTimer = gameEngine.getMyFPSTimer();

        playerx = gameEngine.getPlayer().getPosition().getX();
        playery = gameEngine.getPlayer().getPosition().getY();

        for(int i=0;i<gameEngine.getRenderables().size();i++)
        {
            renderables.add(gameEngine.getRenderables().get(i));
        }

        for(int i=0;i<gameEngine.getGameObjects().size();i++)
        {
            GameObject obj = gameEngine.getGameObjects().get(i);
            if(obj instanceof Enemy)
            {
                Enemy e = (Enemy) obj;
                gameObjects.add(obj);
                xs.add(e.getPosition().getX());
                ys.add(e.getPosition().getY());
                xdels.add(e.getxVel());
            }
            else if(obj instanceof Projectile)
            {
                Projectile e = (Projectile) obj;
                gameObjects.add(obj);
                xs.add(e.getPosition().getX());
                ys.add(e.getPosition().getY());
            }
        }

    }


    void restore(GameEngine gameEngine)
    {
        gameEngine.setScore(this.score);
        gameEngine.setMyFPSTimer(this.myFPSTimer);

        gameEngine.getPlayer().getPosition().setX(playerx);
        gameEngine.getPlayer().getPosition().setY(playery);

//        gameEngine.getRenderables().clear();
        for(int i=0;i<this.renderables.size();i++)
        {
            if(!gameEngine.getRenderables().contains(this.renderables.get(i)))
            {
                gameEngine.getRenderables().add(this.renderables.get(i));
            }
        }

        for(int i=0;i<this.gameObjects.size();i++)
        {
            GameObject obj = this.gameObjects.get(i);
            if(obj instanceof Enemy)
            {
                for(int j=0;j<gameEngine.getGameObjects().size();j++)
                {
                    if(obj == gameEngine.getGameObjects().get(j))
                    {
                        Enemy e = (Enemy) gameEngine.getGameObjects().get(j);
                        e.getPosition().setX(xs.get(i));
                        e.getPosition().setY(ys.get(i));
                        e.setxVel(xdels.get(i));
                    }
                }
            }
            else if(obj instanceof Projectile)
            {
                for(int j=0;j<gameEngine.getGameObjects().size();j++)
                {
                    if(obj == gameEngine.getGameObjects().get(j))
                    {
                        Projectile e = (Projectile) gameEngine.getGameObjects().get(j);
                        e.getPosition().setX(xs.get(i));
                        e.getPosition().setY(ys.get(i));
                    }
                }
            }
        }
    }

}
