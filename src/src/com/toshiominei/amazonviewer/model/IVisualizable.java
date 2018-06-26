package com.toshiominei.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	/**
	 * Este m�todo captura el tiempo exacto de inicio de visualizaci�n.
	 * 
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto
	 * @return Devuelve la fecha y hora capturada
	 * */
	Date startToSee(Date dateI);
	
	/**
	 * Este m�todo captura el tiempo exacto de inicio y final de visualizaci�n
	 * 
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto
	 * @param dateF es un objeto {@code Date} con el tiempo de final exacto
	 * */
	void stopToSee(Date dateI, Date dateF);
}
