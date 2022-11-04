package estadoDesafio;

import main.DesafioDelUsuario;

public class DesafioCompletado extends EstadoDesafio {

	@Override
	public void aceptarDesafio(DesafioDelUsuario desafio) {
		// no hace nada, el desafio ya fue aceptado e incluso completado
	}

	@Override
	public void superarDesafio(DesafioDelUsuario desafioDelUsuario) {
		// no hace nada, el desafio ya fue superado
	}

	@Override
	public void incrementarCantidadMuestrasRecolectadas(DesafioDelUsuario desafioDelUsuario) {
		// no hace nada, el desafio ya fue completado
	}

	@Override
	public void calificarDesafio(DesafioDelUsuario desafioDelUsuario, Integer puntuacion) {
		desafioDelUsuario.setPuntuacion(puntuacion);
	}

}
