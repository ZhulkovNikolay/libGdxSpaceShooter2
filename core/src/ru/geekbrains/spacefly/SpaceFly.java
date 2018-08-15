package ru.geekbrains.spacefly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpaceFly extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture ship;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("sky.jpg");
        ship = new Texture("ship.png");

        Vector2 v1 = new Vector2(1, 3); // вектор скорости
        Vector2 v2 = new Vector2(0, -1); //вектор направления
        v1.add(v2); //сложили вектора
        System.out.println("v1.x = " + v1.x + " v1.y = " + v1.y);

        v1.set(4, 3);
        v2.set(1, 2);
        v1.sub(v2);
        System.out.println("v1.x = " + v1.x + " v1.y = " + v1.y);

        v1.set(10,20);
        v1.scl(0.9f);
        System.out.println("v1.x = " + v1.x + " v1.y = " + v1.y);

        System.out.println("v1.len = " + v1.len());

        v1.nor(); // вектор направления
        System.out.println("v1.x = " + v1.x + " v1.y = " + v1.y);
        System.out.println("v1.len = " + v1.len());

        System.out.println(v2.dot(v1));
        System.out.println("v2.x = " + v2.x + " v2.y = " + v2.y);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(ship, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }
}
