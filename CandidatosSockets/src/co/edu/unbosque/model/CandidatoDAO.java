package co.edu.unbosque.model;

public interface CandidatoDAO {
	
	public void create (String name, int cedula, String cargo, int hora_llegada);
	
	public boolean deleteByName (String name);
	
	public String showall();

}
