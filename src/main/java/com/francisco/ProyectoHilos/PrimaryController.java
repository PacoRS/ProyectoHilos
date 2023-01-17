package com.francisco.ProyectoHilos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import AccesoAtomico.CompraEntradas;
import AccesoAtomico.CopiaNumEntradas;
import AccesoAtomico.Cuenta;
import Cooperantes.Contador;
import Cooperantes.Hilo;
import Model.Persona;
import ModelDao.PersonaDAO;
import ProductorConsumidor.Buffer;
import ProductorConsumidor.Consumidor;
import ProductorConsumidor.Productor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextFlow;

public class PrimaryController {
	// Parte de Productor Consumidor
	@FXML
	private Button verPerona;
	@FXML
	public TableView<Persona> tablaPersona;
	@FXML
	public TableColumn<Persona, String> EntradaTF;
	@FXML
	public TableColumn<Persona, String> SalidaTF;
	@FXML
	public TextField txt = new TextField();

	// Parte Hilos Cooperativos
	@FXML
	private Button cuenta;
	@FXML
	public TableView<Hilo> tabla1;
	@FXML
	public TableColumn<Hilo, String> caja1;

	// Parte de Acceso Atomico
	@FXML
	private Button cuenta1;
	@FXML
	public TextField entradas = new TextField();
	

	// todos los ObservableList
	public static ObservableList<Persona> personas = FXCollections.observableArrayList();

	public static ObservableList<Hilo> caja11 = FXCollections.observableArrayList();

	public static ObservableList<Cuenta> caja = FXCollections.observableArrayList();

	@FXML
	public void muestrainfo(ActionEvent event) {
		configuraTabla();
		tablaPersona.setItems(personas);

	}

	private void configuraTabla() {

		EntradaTF.setCellValueFactory(cadapersona -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadapersona.getValue().getAccionEntrada());
			return v;
		});
		SalidaTF.setCellValueFactory(cadapersona -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadapersona.getValue().getAccionSalida());
			return v;
		});

	}

	@FXML
	public void contarLasCajas(ActionEvent event) {
		configuraTabla1();
		tabla1.setItems(caja11);

	}

	private void configuraTabla1() {

		caja1.setCellValueFactory(cadapersona -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadapersona.getValue().getMensaje());
			return v;
		});

	}

	@FXML
	public void compraEntradas(ActionEvent event) {

		Cuenta cuenta = new Cuenta(Float.parseFloat(entradas.getText()));
		CompraEntradas ana = new CompraEntradas(cuenta, "Ana", 30);
		CompraEntradas pepe = new CompraEntradas(cuenta, "Pepe", 10);
		CompraEntradas antonio = new CompraEntradas(cuenta, "Antonio", 20);
		CompraEntradas andrea = new CompraEntradas(cuenta, "Andrea", 30);

		ana.start();
		pepe.start();
		antonio.start();
		andrea.start();

	}
}
