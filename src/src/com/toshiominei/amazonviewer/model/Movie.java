package com.toshiominei.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.toshiominei.amazonviewer.dao.MovieDao;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * */
public class Movie extends Film implements IVisualizable, MovieDao {
	private int id;
	private int timeViewed;
	
	public Movie() {
		
	}
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public String toString() {
		return "Title: " + getTitle() +
				"\n Genre: " + getGenre() +
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() + 
				"\n Duration: " + getDuration();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	/**
	 * {@inheritDoc }
	 * */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc }
	 * */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		setTimeViewed(result);
	}
	
	public static ArrayList<Movie> makeMoviesList() {
		Movie movie = new Movie();
		return movie.read();
	}

	/**
	 * {@inheritDoc }
	 * */
	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 10000; i++) {
			System.out.println("..........");
		}
		
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
	}
}
