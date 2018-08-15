package ru.geekbrains.spacefly.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.spacefly.base.Base2DScreen;

//экран меню
public class MenuScreen extends Base2DScreen {
    SpriteBatch batch;
    Texture background;
    Texture ship;

    Vector2 pos;
 //   Vector2 v;
    Vector2 direction;

    Vector2 touchPos;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        background = new Texture("sky.jpg");
        ship = new Texture("ship.png");
        pos = new Vector2(0, 0);
        touchPos = new Vector2();
        // v = touchPos.nor();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(ship, pos.x, pos.y);
        batch.end();
      //  pos.add(touchPos.nor()); //с каждым срабатыванием рендер картинка отрисовывается в новом месте
        getDirection();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        background.dispose();
        ship.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touchPos.set(screenX, Gdx.graphics.getHeight() - screenY);// инвентируем экран
        System.out.println("touchPos.x = " + touchPos.x + " touchPos.y = " + touchPos);
        return false; // нужно ли дальше обрабатывать это событие
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        return false;
    }

    public void getDirection() {
       // touchPos.nor();
//        pos.add(touchPos.nor());
        if ((touchPos.x < pos.x) && (touchPos.y < pos.y)) {
            pos.add(-touchPos.nor().x, -touchPos.nor().y);
//        } else
//        if (touchPos.x < pos.x) {
//            pos.add(-touchPos.x, touchPos.y);
//        }else
//        if (touchPos.y < pos.y) {
//            pos.add(touchPos.x, -touchPos.y);
        }else
            pos.add(touchPos.nor());


    }
}
