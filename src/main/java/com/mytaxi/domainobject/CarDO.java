/**
 * 
 */
package com.mytaxi.domainobject;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Udayakumar.Rajan
 *
 */
@Entity
@Table(
	    name = "car",
	    uniqueConstraints = @UniqueConstraint(name = "uc_licenseplate", columnNames = {"licensePlate"})
	)
public class CarDO implements Serializable {
	
	
	public CarDO () {}
	
	public CarDO(String licensePlate, Integer seatCount, Integer convertible, Integer rating, String engineType,
			String color, String style, String manufacturer, String model, String gearType) {
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.rating = rating;
		this.engineType = engineType;
		this.color = color;
		this.style = style;
		this.manufacturer = manufacturer;
		this.model = model;
		this.gearType = gearType;
		

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "License Plate not be null!")
	private String licensePlate;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@Column(nullable = false)
	private Integer seatCount;

	@Column(nullable = false)
	@Size(max = 1)
	private Integer convertible;

	@Column
	private Integer rating;

	@Column(nullable = false)
	private String engineType;

	@Column(nullable = false)
	private String color;

	@Column(nullable = false)
	private String style;

	@Column(nullable = false)
	private String manufacturer;

	@Column(nullable = false)
	private String model;
	
	@OneToOne(mappedBy = "carDO")
	private DriverDO driverDO;
	
	@Column (nullable = false)
	private String gearType;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @param licensePlate
	 *            the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * @return the dateCreated
	 */
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the seatCount
	 */
	public Integer getSeatCount() {
		return seatCount;
	}

	/**
	 * @param seatCount
	 *            the seatCount to set
	 */
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	/**
	 * @return the convertible
	 */
	public Integer getConvertible() {
		return convertible;
	}

	/**
	 * @param convertible
	 *            the convertible to set
	 */
	public void setConvertible(Integer convertible) {
		this.convertible = convertible;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return the engineType
	 */
	public String getEngineType() {
		return engineType;
	}

	/**
	 * @param engineType
	 *            the engineType to set
	 */
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	
	
	/**
	 * @return the driverDO
	 */
	public DriverDO getDriverDO() {
		return driverDO;
	}

	/**
	 * @param driverDO the driverDO to set
	 */
	public void setDriverDO(DriverDO driverDO) {
		this.driverDO = driverDO;
	}
	
	

	/**
	 * @return the transmission
	 */
	public String getGearType() {
		return gearType;
	}

	/**
	 * @param transmission the transmission to set
	 */
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((convertible == null) ? 0 : convertible.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((engineType == null) ? 0 : engineType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((seatCount == null) ? 0 : seatCount.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDO other = (CarDO) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (convertible == null) {
			if (other.convertible != null)
				return false;
		} else if (!convertible.equals(other.convertible))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (engineType == null) {
			if (other.engineType != null)
				return false;
		} else if (!engineType.equals(other.engineType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (seatCount == null) {
			if (other.seatCount != null)
				return false;
		} else if (!seatCount.equals(other.seatCount))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		return true;
	}

}
