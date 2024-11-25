import java.util.Date;

public class claseCita {
	private String fecha;
	private String hora;
	private int idCita, idCliente, idServicio;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String string) {
		this.fecha = string;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	
	
	
}
