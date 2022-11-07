package recomendacionDesafio;

import java.util.List;

import main.DesafioDelUsuario;
import main.Usuario;

public class RecomendadorPorPreferencias extends RecomendadorDesafio {

	@Override
	public List<DesafioDelUsuario> recomendacionDesafiosPara(Usuario usuario) {
		return this.desafiosNoTomadosOrdenadosSegunNivelDeCoincidencia(usuario).subList(0, 5);
	}

	public List<DesafioDelUsuario> desafiosNoTomadosOrdenadosSegunNivelDeCoincidencia(Usuario usuario) {
		 return usuario.desafiosSinAceptar()
				 .stream()
				 .sorted((unDesafio, otroDesafio) -> 
				 	this.nivelDeCoincidencia(usuario, unDesafio).compareTo(this.nivelDeCoincidencia(usuario, otroDesafio)))
				 .toList();
	}

}
