package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

import co.edu.unbosque.model.persistance.FileHandler;

public class CandidatoDAOimpl implements CandidatoDAO {
	
	private ArrayList <CandidatoDTO> list;

	public CandidatoDAOimpl() {
		list = new ArrayList<>();
		loadFile();
	}
	private void loadFile() {
		String content = FileHandler.loadFile("candidatos.csv");
		String[] lines = content.split("\n");
		for (String s : lines) {
			if (s.equals(""))
				continue;
			String[] columns = s.split(",");
			list.add(new CandidatoDTO());
		}
		
	}
	@Override
	public void create(String name, int cedula, String cargo, int edad) {
		list.add(new CandidatoDTO(name,cedula,cargo,edad));
		writeFile();
		
	}

	private void writeFile() {
			String content = showall();
			FileHandler.writeFile("candidatos.csv", content);
		
	}

	@Override
	public boolean deleteByName(String name) {
		boolean found = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNombre().equals(name)) {
				list.remove(i);
				writeFile();
				return true;
			}
		}
		return false;
	}
	@Override
	public String showall() {
		// TODO Auto-generated method stub
		return null;
	}

}
