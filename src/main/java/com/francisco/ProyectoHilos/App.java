package com.francisco.ProyectoHilos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import AccesoAtomico.CompraEntradas;
import AccesoAtomico.CopiaNumEntradas;
import AccesoAtomico.Cuenta;
import Cooperantes.Contador;
import Cooperantes.Hilo;
import ProductorConsumidor.Buffer;
import ProductorConsumidor.Consumidor;
import ProductorConsumidor.Productor;

/**
 * JavaFX App
 */
public class App extends Application {
	private static final int NUM_HILOS = 6;
	private static final int CUENTA_TOTAL = 600;
	private static Scene scene;
	PrimaryController pr = new PrimaryController();
	Hilo h = new Hilo();

	@Override
	public void start(Stage stage) throws IOException {

		scene = new Scene(loadFXML("primary"), 600, 400);
		stage.setScene(scene);
		stage.show();

		Buffer b = new Buffer(2);
		Productor p = new Productor(b);
		Consumidor c = new Consumidor(b);
		p.start();
		c.start();

		Contador c1 = new Contador();
		Thread[] hilos = new Thread[NUM_HILOS];

		for (int i = 0; i < NUM_HILOS; i++) {
			Thread th = new Thread(new Hilo(i, CUENTA_TOTAL / NUM_HILOS, c1));
			th.start();
			hilos[i] = th;

		}

		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String mm = ("Cuenta global: " + c1.getCuenta()+" Euros");
		h.setMensaje(mm);
		pr.caja11.add(h);

	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}