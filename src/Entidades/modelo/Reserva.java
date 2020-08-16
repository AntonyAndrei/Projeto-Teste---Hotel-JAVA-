package Entidades.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private static SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");

	private int numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;


	public Reserva(int numeroDoQuarto, Date checkIn, Date checkOut) {
		super();
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	public int getNumeroDoQuarto() {
		return numeroDoQuarto;
	}


	public void setNumeroDoQuarto(int numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}


	public long duracao() {
		long diferencaEmMs = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferencaEmMs, TimeUnit.MILLISECONDS);
	}
	
	public String atualizarDatas(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na reserva: Datas de reservas tem que ser futuras.";
		} 
		if (!checkOut.after(checkIn)) {
			return "ERRO NA RESERVA: DATA DE CHECK-OUT DEVE SER APOS O CHECK IN ";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}


	@Override
	public String toString() {
		return "Quarto #" + numeroDoQuarto 
				+ ", Check-in " + dataFormato.format(checkIn)
				+ ", Check-Out " + dataFormato.format(checkOut)
				+ ", Duracao: " + duracao() + " Noites.";
	}
	
	
	
}
