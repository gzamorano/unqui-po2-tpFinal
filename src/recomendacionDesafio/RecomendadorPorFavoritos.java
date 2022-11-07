package recomendacionDesafio;

import java.util.List;

import main.Desafio;
import main.DesafioDelUsuario;
import main.Usuario;

public class RecomendadorPorFavoritos extends RecomendadorDesafio {

	@Override
	public List<DesafioDelUsuario> recomendacionDesafiosPara(Usuario usuario) {
		return this.desafiosOrdenadosPorSimilitud(this.desafiosConMayorCoincidencia(usuario, 20), usuario.desafioFavorito()).subList(0, 5);
	}
	
	public List<DesafioDelUsuario> desafiosOrdenadosPorSimilitud(List<DesafioDelUsuario> desafiosAOrdenar, DesafioDelUsuario desafioFavorito) {
		return desafiosAOrdenar
				.stream()
				.sorted((unDesafio, otroDesafio) -> 
					this.similitudEntreDesafios(unDesafio, desafioFavorito).compareTo(this.similitudEntreDesafios(otroDesafio, desafioFavorito)))
				.toList();
	}

	public Double similitudEntreDesafios(DesafioDelUsuario unDesafio, DesafioDelUsuario desafioFavorito) {
		Desafio desafio1   = unDesafio.getDesafio();
		Desafio desafioFav = desafioFavorito.getDesafio(); 
		Integer diferenciaMuestras = Math.abs(desafio1.getCantMuestrasParaBatir() - desafioFav.getCantMuestrasParaBatir());
		Integer diferenciaDificultad = Math.abs(desafio1.getDificultad() - desafioFav.getDificultad());
		Integer diferenciaRecompensa = Math.abs(desafio1.getRecompensa() - desafioFav.getRecompensa());
		
		return (diferenciaMuestras+diferenciaDificultad+diferenciaRecompensa)/3d;
	}

	public List<DesafioDelUsuario> desafiosConMayorCoincidencia(Usuario usuario, Integer cantidad) {
		return this.desafiosOrdenadosSegunNivelDeCoincidencia(usuario).subList(0, cantidad);			 		
	}
 
}
