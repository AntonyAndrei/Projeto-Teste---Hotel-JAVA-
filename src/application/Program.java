package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.modelo.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Numero do Quarto: ");
		int numeroDoQuarto = ler.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = dataFormato.parse(ler.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = dataFormato.parse(ler.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("ERRO NA RESERVA: DATA DE CHECK-OUT DEVE SER APOS O CHECK IN ");
		} else {
			Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = dataFormato.parse(ler.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = dataFormato.parse(ler.next());
			
		
				String erro = reserva.atualizarDatas(checkIn, checkOut);
				if (erro != null) {
					System.out.println("Erro na reserva: " + erro);
				} else {
					
				System.out.println("Reserva: " + reserva);
			}
			
			
		}
		
		
		
		
		
		ler.close();

	}

	
}
