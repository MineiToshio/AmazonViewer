package com.toshiominei.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import com.toshiominei.amazonviewer.model.Book;
import com.toshiominei.amazonviewer.model.Chapter;
import com.toshiominei.amazonviewer.model.Film;
import com.toshiominei.amazonviewer.model.Movie;
import com.toshiominei.amazonviewer.model.Serie;
import com.toshiominei.makereport.Report;
import com.toshiominei.util.AmazonUtil;

/**
 * <h1>Amazon Viewer</h1>
 * AmazonViewer es un programa que permite visualizar movies, series con sus respectivos chapters,
 * books y magazines. Permite generar reportes generales y con fecha del día.
 * <p>
 * Existen algunas reglas como que todos los elementos pueden ser visualizados o leídos a excepción
 * de las magazines. Estas solo pueden ser vistas a modo de exposición sin ser leídas.
 * 
 * @author Sergio Minei
 * @version 1.1
 * @since 2018
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showMenu();
	}

	public static void showMenu() {
		int exit = 0;
		do {
			System.out.println("BIENVENIDOS A AMAZON VIEWER");
			System.out.println();
			System.out.println("Seleccionada el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			System.out.println();
			System.out.println("Escribe la opción que desee ejecutar: ");
			
			int response = AmazonUtil.validateUserResponseMenu(0, 6);
			
			switch (response) {
			case 0:
				System.out.println("saliste del sistema!");
				exit = 0;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				exit  = 1;
				break;
			case 6:
				makeReport(new Date());
				exit  = 1;
				break;

			default:
				System.out.println("Opción no disponible");
				exit  = 1;
				break;
			}
		} while(exit != 0);
	}
	
	static ArrayList<Movie> movies  = new ArrayList();
	public static void showMovies() {
		movies  = Movie.makeMoviesList();
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			AtomicInteger atomicInteger = new AtomicInteger(1);
			movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement() + ". " +  m.getTitle() + " Visto " + m.isViewed()));
			
			/*for (int i = 0; i < movies.size(); i++) {
				System.out.println(i + 1 + " . " + movies.get(i).getTitle() + " Visto " + movies.get(i).isViewed());
			}*/
			
			System.out.println("0. Regresar al menu");
			System.out.println();
			
			
			int response = AmazonUtil.validateUserResponseMenu(0, movies.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			else if(response > 0) {
				Movie movieSelected = movies.get(response - 1); 
				movieSelected.view();
			}
			
			
			
		} while(exit != 0);
	}
	
	static ArrayList<Serie> series = Serie.makeSeriesList();
	public static void showSeries() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			AtomicInteger atomicInteger = new AtomicInteger(1);
			series.forEach(s -> System.out.println(atomicInteger.getAndIncrement() + ". " + s.getTitle() + " Visto: " + s.isViewed()));
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, series.size());
			
			if(response == 0) {
				showMenu();
			}
			
			showChapters(series.get(response-1).getChapters());
			
		} while(exit !=0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			AtomicInteger atomicInteger = new AtomicInteger(1);
			chaptersOfSerieSelected.forEach(c -> System.out.println(atomicInteger.getAndIncrement() + ". " + c.getTitle() + " Visto: " + c.isViewed()));
			
			/*for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}*/
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
			
			if(response == 0) {
				exit = 0;
			}
			
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.view();
			}
		}while(exit !=0);
	}
	
	static ArrayList<Book> books= Book.makeBookList();
	public static void showBooks() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).getIsReaded());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			int response = AmazonUtil.validateUserResponseMenu(0, books.size());;
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}			
			else if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.view();
			}
			
		}while(exit !=0);
	}
	
	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
		} while(exit != 0);
	}
	
	public static void makeReport() {
		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension(".txt");
		report.setTitle(":: VISTOS ::");
		StringBuilder contentReport = new StringBuilder();
		
		movies.stream()
			.filter(m -> m.getIsViewed())
			.forEach(m -> contentReport.append(m.toString() + "\n"));
		
		//Predicate<Serie> seriesViewed = s -> s.getIsViewed();
		Consumer<Serie> seriesEach = s -> {
			ArrayList<Chapter> chapters = s.getChapters();
			chapters.stream()
				.filter(c -> c.getIsViewed())
				.forEach(c -> contentReport.append(c.toString() + "\n"));
		};
		series.stream().forEach(seriesEach);
		
		books.stream()
			.filter(b -> b.getIsReaded())
			.forEach(m -> contentReport.append(m.toString() + "\n"));
		
		report.setContent(contentReport.toString());
		report.makeReport();
		System.out.println("Reporte Generado");
		System.out.println();
	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		
		Report report = new Report();
		report.setNameFile("reporte " + dateString);
		report.setExtension(".txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		report.setContent(contentReport);
		report.makeReport();
	}
}
