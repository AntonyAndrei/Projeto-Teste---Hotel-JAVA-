package Entidades.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exeptions.modelo.DomainException;

public class Reserva {
	
	private static SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");

	private int numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;


	public Reserva(int numeroDoQuarto, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("DATA DE CHECK-OUT DEVE SER APOS O CHECK IN ");
		}
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
	
	public void atualizarDatas(Date checkIn, Date checkOut) throws DomainException {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DomainException("Datas de reservas tem que ser futuras.");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("DATA DE CHECK-OUT DEVE SER APOS O CHECK IN ");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	@Override
	public String toString() {
		return "Quarto #" + numeroDoQuarto 
				+ ", Check-in " + dataFormato.format(checkIn)
				+ ", Check-Out " + dataFormato.format(checkOut)
				+ ", Duracao: " + duracao() + " Noites.";
	}
	
	
	
}
