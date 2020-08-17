package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.modelo.Reserva;
import exeptions.modelo.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.print("Numero do Quarto: ");
			int numeroDoQuarto = ler.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = dataFormato.parse(ler.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = dataFormato.parse(ler.next());
			
		
			Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = dataFormato.parse(ler.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = dataFormato.parse(ler.next());
			
		
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
		} catch (ParseException e) {
			System.out.println("Data invalida! ");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
	
		
		ler.close();

	}

	
}
