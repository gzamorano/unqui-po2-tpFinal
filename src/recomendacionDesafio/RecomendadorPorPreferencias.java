package recomendacionDesafio;

import java.util.List;

import main.DesafioDelUsuario;
import main.Usuario;

public class RecomendadorPorPreferencias extends RecomendadorDesafio {

	@Override
	public List<DesafioDelUsuario> recomendacionDesafiosPara(Usuario usuario) {
		return this.desafiosOrdenadosSegunNivelDeCoincidencia(usuario).subList(0, 5);
	}

}
