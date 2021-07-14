package com.minhle.model;

import javax.persistence.*;

@Table(name = "countries")
@Entity(name = "countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;


	@Column(name = "name")
	private String name;

	@Column(name = "population")
	private int population;

	public Country() {
		super();
	}

	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "\nCountry [Id=" + Id + ", name=" + name + ", population=" + population + "]";
	}

}
