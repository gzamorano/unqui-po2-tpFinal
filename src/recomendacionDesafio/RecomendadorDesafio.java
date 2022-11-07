package recomendacionDesafio;

import java.util.List;

import main.Desafio;
import main.DesafioDelUsuario;
import main.Usuario;

public abstract class RecomendadorDesafio {
	public abstract List<DesafioDelUsuario> recomendacionDesafiosPara(Usuario usuario);

	public List<DesafioDelUsuario> desafiosOrdenadosSegunNivelDeCoincidencia(Usuario usuario) {
		 return usuario.desafiosSinAceptar()
				 .stream()
				 .sorted((unDesafio, otroDesafio) -> 
				 	this.nivelDeCoincidencia(usuario, unDesafio).compareTo(this.nivelDeCoincidencia(usuario, otroDesafio)))
				 .toList();
	}

	public Integer nivelDeCoincidencia(Usuario usuario, DesafioDelUsuario desafioDelUsuario) {
		Preferencia preferenciaUsuario = usuario.getPreferencia();
		Desafio desafio = desafioDelUsuario.getDesafio();
		Integer diferenciaMuestras = Math.abs(desafio.getCantMuestrasParaBatir() - preferenciaUsuario.getCantidadMuestras());
		Integer diferenciaDificultad = Math.abs(desafio.getDificultad() - preferenciaUsuario.getDificultad());
		Integer diferenciaRecompensa = Math.abs(desafio.getRecompensa() - preferenciaUsuario.getRecompensa());
		
		return diferenciaMuestras + diferenciaDificultad + diferenciaRecompensa;
	}
}
