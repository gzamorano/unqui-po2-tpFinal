import java.util.ArrayList;
import java.util.List;

import estadoDesafio.EsperandoAceptacion;
import recomendacionDesafio.Preferencia;

public class Usuario {
	private List<DesafioDelUsuario> desafiosDelUsuario = new ArrayList<DesafioDelUsuario>();
	private Preferencia preferencia;
	
	public Usuario(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public List<DesafioDelUsuario> getDesafiosDelUsuario() {
		return this.desafiosDelUsuario;
	}

	public void añadirDesafioDelUsuario(DesafioDelUsuario desafioDelUsuario) {
		this.getDesafiosDelUsuario().add(desafioDelUsuario);
	}

	public boolean superoElDesafio(DesafioDelUsuario desafioDelUsuario) {
		return desafioDelUsuario.estaCompleto();
	}

	public void aceptarDesafio(DesafioDelUsuario desafioDelUsuario) {
		desafioDelUsuario.aceptarDesafio();
	}

	public Double porcentajeDeCompletitud(DesafioDelUsuario desafioDelUsuario) {
		return desafioDelUsuario.porcentajeDeCompletitud();
	}

	public List<DesafioDelUsuario> desafiosCompletados() {
		return this.getDesafiosDelUsuario()
								.stream()
								.filter(desafioUsuario -> desafioUsuario.estaCompleto())
								.toList();
	}

	public Double porcentajeDeCompletitudGeneral() {
		List<DesafioDelUsuario> desafiosAceptadosYCompletados = this.getDesafiosDelUsuario()
											.stream()
											.filter(desafioUsuario -> !(desafioUsuario.getEstadoDesafio() instanceof EsperandoAceptacion))
											.toList();
		
		Double porcentajeTotal = desafiosAceptadosYCompletados
											.stream()
											.mapToDouble(desafio -> desafio.porcentajeDeCompletitud())
											.sum();
		
		return  porcentajeTotal / desafiosAceptadosYCompletados.size();
	}

}
