package estadoDesafio;

import main.DesafioDelUsuario;

public class DesafioAceptado extends EstadoDesafio {

	@Override
	public void aceptarDesafio(DesafioDelUsuario desafio) {
		// no hace nada, el desafio ya fue aceptado
	}

	@Override
	public void superarDesafio(DesafioDelUsuario desafioDelUsuario) {
		desafioDelUsuario.setEstado(new DesafioCompletado());
	}

	@Override
	public void incrementarCantidadMuestrasRecolectadas(DesafioDelUsuario desafioDelUsuario) {
		desafioDelUsuario.setCantidadMuestrasRecolectadas(desafioDelUsuario.getCantidadMuestrasRecolectadas()+1);
		desafioDelUsuario.comprobarCompletitud();
	}

	@Override
	public void calificarDesafio(DesafioDelUsuario desafioDelUsuario, Integer puntuacion) {
		// no hace nada, el desafio todavía está en curso
	}
	
	@Override 
	public boolean estaActivo() {
		return true;
	}

}
