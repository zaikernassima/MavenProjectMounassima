package net.kiranatos.snake;

import javafx.scene.image.ImageView;

abstract class Assets {
	static ImageView snake_head = new ImageView(Assets.class.getClassLoader().getResource("img/head.png").toString());
	static ImageView snake_body = new ImageView(Assets.class.getClassLoader().getResource("img/body.png").toString());
	static ImageView apple = new ImageView(Assets.class.getClassLoader().getResource("img/apple.png").toString());
}