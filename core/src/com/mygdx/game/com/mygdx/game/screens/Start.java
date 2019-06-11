package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.DodgeGame;

public class Start implements Screen {
    private DodgeGame game;
    private Texture exitButtonInactive;
    private Texture exitButtonActive;
    private Texture playButtonInactive;
    private Texture playButtonActive;
    private Texture startScreenBackground;
    private static final int EXIT_BUTTON_WIDTH = 300;
    private static final int EXIT_BUTTON_HEIGHT = 150;
    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 150;
    private static final int EXIT_BUTTON_YVALUE = (int)(DodgeGame.HEIGHT * 0.1);
    private static final int PLAY_BUTTON_YVALUE = (int)(DodgeGame.HEIGHT * 0.4);
    private Music music;

    public static Sprite backgroundSprite;
    //private timer Timer;
    public Start(DodgeGame game){
        this.game = game;
        exitButtonInactive = new Texture("sprites/exitButton.jpg");
        exitButtonActive = new Texture("sprites/exitButtonActive.jpg");
        playButtonInactive = new Texture("sprites/playButton2.jpg");
        playButtonActive = new Texture("sprites/playButton2Active.jpg");
        startScreenBackground = new Texture("sprites/dodgeStartScreen.png");
        backgroundSprite = new Sprite(startScreenBackground);
        backgroundSprite.scale(7);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/01 - Menu.mp3"));
        music.setLooping(true);
        music.setVolume(1f);
        music.play();
    }
    public void show(){

    }

    public void render(float delta){
        Gdx.gl.glClearColor(0.5f,0.5f,0.5f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        backgroundSprite.setPosition(DodgeGame.WIDTH / 2 - backgroundSprite.getWidth()/2, DodgeGame.HEIGHT/2 - backgroundSprite.getHeight()/2);
        backgroundSprite.draw(game.batch);

        if(Gdx.input.getX() < DodgeGame.WIDTH/2  + EXIT_BUTTON_WIDTH /2 &&
                Gdx.input.getX() > DodgeGame.WIDTH/2 - EXIT_BUTTON_WIDTH/2 &&
                DodgeGame.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_YVALUE  &&
                DodgeGame.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_YVALUE + EXIT_BUTTON_HEIGHT) {
            game.batch.draw(exitButtonActive, DodgeGame.WIDTH/2 - EXIT_BUTTON_WIDTH/2,EXIT_BUTTON_YVALUE, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if(Gdx.input.isTouched() ==true){
                Gdx.app.exit();
            }
        }

        else {
            game.batch.draw(exitButtonInactive, DodgeGame.WIDTH/2 - EXIT_BUTTON_WIDTH/2,EXIT_BUTTON_YVALUE, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }
        if(Gdx.input.getX() < DodgeGame.WIDTH/2  + PLAY_BUTTON_WIDTH /2 &&
                Gdx.input.getX() > DodgeGame.WIDTH/2 - PLAY_BUTTON_WIDTH/2 &&
                DodgeGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_YVALUE  &&
                DodgeGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_YVALUE + PLAY_BUTTON_HEIGHT) {
            game.batch.draw(playButtonActive, DodgeGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2, PLAY_BUTTON_YVALUE, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            if(Gdx.input.isTouched() == true){
                music.stop();
                this.dispose();
                game.setScreen(new LevelSelect(game));
            }
        }
        else {
            game.batch.draw(playButtonInactive, DodgeGame.WIDTH/2 - PLAY_BUTTON_WIDTH/2,PLAY_BUTTON_YVALUE, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);

        }

        game.batch.end();
    }
    public void resize(int width, int height){

    }
    public void pause(){

    }
    public void resume(){

    }
    public void hide(){

    }
    public void dispose(){
        music.dispose();
    }
}