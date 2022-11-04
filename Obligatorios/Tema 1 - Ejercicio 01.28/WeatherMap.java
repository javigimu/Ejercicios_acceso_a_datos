package com.javier.ejercicio_tema1.entidades;

import java.util.List;

/**
 * Clase para almacenar los datos obtenidos de la API openweathermap
 * @author Javi
 *
 */
public class WeatherMap2 {
	
	private Coord coord;
	private List<Weather> weather;
	private Main main;
	private String name;
	
	
	public WeatherMap2(Coord coord, List<Weather> weather, Main main, String name) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.main = main;
		this.name = name;
	}	

	public Coord getCoord() {
		return coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public Main getMain() {
		return main;
	}

	public String getName() {
		return name;
	}
	
	public String getTemp() {
		return String.format("%.2f", main.getTemp()-273.15);
	}

	public String getHumidity() {
		return "" + main.getHumidity();
	}



	private class Coord {
		private double lon;
		private double lat;
		
		public Coord(double lon, double lat) {
			super();
			this.lon = lon;
			this.lat = lat;
		}

		public double getLon() {
			return lon;
		}

		public void setLon(double lon) {
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}	
	}
	
	private class Weather {
		private long id;
		private String main;
		private String description;
		private String icon;
		
		public Weather(long id, String main, String description, String icon) {
			super();
			this.id = id;
			this.main = main;
			this.description = description;
			this.icon = icon;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}	
	}

	private class Main {
		private double temp;
		private double feels_like;
		private double temp_min;
		private double temp_max;
		private double pressure;
		private int humidity;
		
		public Main(double temp, double feels_like, double temp_min, double temp_max, double pressure,
				int humidity) {
			super();
			this.temp = temp;
			this.feels_like = feels_like;
			this.temp_min = temp_min;
			this.temp_max = temp_max;
			this.pressure = pressure;
			this.humidity = humidity;
		}

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

		public double getFeels_like() {
			return feels_like;
		}

		public void setFeels_like(double feels_like) {
			this.feels_like = feels_like;
		}

		public double getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		public double getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}

		public double getPressure() {
			return pressure;
		}

		public void setPressure(double pressure) {
			this.pressure = pressure;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}	
	}
	
}
