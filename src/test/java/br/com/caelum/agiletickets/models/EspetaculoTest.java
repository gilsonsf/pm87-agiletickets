package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}
	
	@Test
	public void deveCriarEspetaculoComUmaSessao() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2014, 8, 14);
		LocalDate fim = new LocalDate(2014, 8, 14);
		LocalTime horario = new LocalTime(20, 0);
		
		espetaculo.criaSessoes(inicio, fim , horario, Periodicidade.DIARIA);

		assertTrue(espetaculo.getSessoes().size() == 1);
		assertTrue(espetaculo.getSessoes().get(0).getInicio().equals(inicio.toDateTime(horario)));
	}
	
	@Test
	public void deveCriarEspetaculoComDuasSessao() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2014, 8, 14);
		LocalDate fim = new LocalDate(2014, 8, 15);
		LocalTime horario = new LocalTime(20, 0);
		
		espetaculo.criaSessoes(inicio, fim , horario, Periodicidade.DIARIA);

		assertTrue(espetaculo.getSessoes().size() == 2);
	}
	
	@Test
	public void deveCriarEspetaculoComDatasDiferentes() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2014, 8, 14);
		LocalDate fim = new LocalDate(2014, 8, 15);
		LocalTime horario = new LocalTime(20, 0);
		
		espetaculo.criaSessoes(inicio, fim , horario, Periodicidade.DIARIA);
		
		assertTrue(espetaculo.getSessoes().get(0).getInicio().equals(inicio.toDateTime(horario)));
		assertTrue(espetaculo.getSessoes().get(1).getInicio().equals(fim.toDateTime(horario)));
	}
	
	@Test
	public void deveVerificarSeOFelipeMama() {
		assertTrue("Felipe mama?", true);
	}
	
	
	
	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	

	
}
