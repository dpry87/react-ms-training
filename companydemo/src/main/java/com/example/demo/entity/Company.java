package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String companyName;
	private double turnover;
	private String ceo;
	@OneToMany(mappedBy="comp", cascade = CascadeType.ALL)
    private List<Director> board;
	private boolean isListed;
	private String sector;
	private String writeup;

	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getTurnover() {
		return turnover;
	}
	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public List<Director> getBoard() {
		return board;
	}
	public void setBoard(List<Director> board) {
		this.board = board;
	}
	public boolean isListed() {
		return isListed;
	}
	public void setListed(boolean isListed) {
		this.isListed = isListed;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getWriteup() {
		return writeup;
	}
	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}
	public long getId() {
		return id;
	}
	
	
	
	
}
