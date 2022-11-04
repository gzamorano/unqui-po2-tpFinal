package estadoDesafio;

import main.DesafioDelUsuario;

public class EsperandoAceptacion extends EstadoDesafio{

	@Override
	public void aceptarDesafio(DesafioDelUsuario desafio) {
		desafio.setEstado(new DesafioAceptado());
	}

	@Override
	public void superarDesafio(DesafioDelUsuario desafioDelUsuario) {
		// no hace nada, el desafio ni siquiera fue aceptado
	}

	@Override
	public void incrementarCantidadMuestrasRecolectadas(DesafioDelUsuario desafioDelUsuario) {
		// no hace nada, el desafio aún no está aceptado
	}

	@Override
	public void calificarDesafio(DesafioDelUsuario desafioDelUsuario, Integer puntuacion) {
		// no hace nada, el desafio ni siquiera fue aceptado
	}
	
}
