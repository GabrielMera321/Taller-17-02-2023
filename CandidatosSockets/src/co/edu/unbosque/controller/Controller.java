package co.edu.unbosque.controller;

import java.util.Properties;

import co.edu.unbosque.model.CandidatoDAOimpl;
import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View view;
	private Properties prop;
	private CandidatoDAOimpl candidato;
	private int seleccion = -1;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		view = new View();
		candidato = new CandidatoDAOimpl();
		prop = FileHandler.loadProperties();
		
		switchcase();
	}

	private void switchcase() {
		// TODO Auto-generated method stub
		while (seleccion !=0) {
			view.printString(prop.getProperty("persistencia.menu.titulomenu"));
			view.printString(prop.getProperty("persistencia.menu.seleccion"));
			view.printString(prop.getProperty("persistencia.menu.seleccion.agregar"));
			view.printString(prop.getProperty("persistencia.menu.seleccion.retirar"));
			view.printString(prop.getProperty("persistencia.menu.seleccion.show"));
			view.printString(prop.getProperty("persistencia.menu.seleccion.salir"));
			
			
			
			int seleccion = view.readint();
			switch (seleccion) {
			case 1:{
				view.burnLine();
				view.printString(prop.getProperty("persistencia.pa.nombre"));
				String name = view.readString();
				view.printString(prop.getProperty("persistencia.pa.cedula"));
				int cedula = view.readint();
				view.burnLine();
				view.printString(prop.getProperty("persistencia.pa.cargo"));
				String cargo = view.readString();
				view.burnLine();
				view.printString(prop.getProperty("persistencia.pa.edad"));
				int edad = view.readint();
				candidato.create(name, cedula, cargo, edad);
				view.printString(prop.getProperty("persistencia.pa.agregado"));
				break;
				
			}
			case 2:{
				view.burnLine();
				view.printString(prop.getProperty("persistencia.pa.borrar"));
				String name = view.readStringLine();
				if(candidato.deleteByName(name)) {
					view.printString(prop.getProperty("persistencia.pa.borrado"));
				}
					else {
						view.printString(prop.getProperty("persistencia.pa.erroralborrar"));
						
				}
				break;
				}
			case 3:{
				view.printString(prop.getProperty("persistencia.show.all"));
				view.printString(candidato.showall());
				break;
			}
			case 0:{
				view.printString(prop.getProperty("persistencia.menu.exit"));
			}
			}
			
		}
		}
	}



