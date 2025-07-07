package dvd.mvc.model;

import java.sql.Date;

public class DvdDTO {

	private String dvd_id;
	private String dvd_name;
	private int dvd_unitPrice;
	private String dvd_author;
	private String dvd_description;
	private String dvd_publisher;
	private String dvd_category;
	private int dvd_unitsInStock;
	private Date dvd_releaseDate;
	private String dvd_condition;
	private String dvd_thumbnailUrl;

	public DvdDTO() {}

	public DvdDTO(String dvd_id, String dvd_name, int dvd_unitPrice, String dvd_author, String dvd_description,
			String dvd_publisher, String dvd_category, int dvd_unitsInStock, Date dvd_releaseDate, String dvd_condition,
			String dvd_thumbnailUrl) {
		super();
		this.dvd_id = dvd_id;
		this.dvd_name = dvd_name;
		this.dvd_unitPrice = dvd_unitPrice;
		this.dvd_author = dvd_author;
		this.dvd_description = dvd_description;
		this.dvd_publisher = dvd_publisher;
		this.dvd_category = dvd_category;
		this.dvd_unitsInStock = dvd_unitsInStock;
		this.dvd_releaseDate = dvd_releaseDate;
		this.dvd_condition = dvd_condition;
		this.dvd_thumbnailUrl = dvd_thumbnailUrl;
	}

	public String getDvd_id() {
		return dvd_id;
	}

	public String getDvd_name() {
		return dvd_name;
	}

	public int getDvd_unitPrice() {
		return dvd_unitPrice;
	}

	public String getDvd_author() {
		return dvd_author;
	}

	public String getDvd_description() {
		return dvd_description;
	}

	public String getDvd_publisher() {
		return dvd_publisher;
	}

	public String getDvd_category() {
		return dvd_category;
	}

	public int getDvd_unitsInStock() {
		return dvd_unitsInStock;
	}

	public Date getDvd_releaseDate() {
		return dvd_releaseDate;
	}

	public String getDvd_condition() {
		return dvd_condition;
	}

	public String getDvd_thumbnailUrl() {
		return dvd_thumbnailUrl;
	}

	public void setDvd_id(String dvd_id) {
		this.dvd_id = dvd_id;
	}

	public void setDvd_name(String dvd_name) {
		this.dvd_name = dvd_name;
	}

	public void setDvd_unitPrice(int dvd_unitPrice) {
		this.dvd_unitPrice = dvd_unitPrice;
	}

	public void setDvd_author(String dvd_author) {
		this.dvd_author = dvd_author;
	}

	public void setDvd_description(String dvd_description) {
		this.dvd_description = dvd_description;
	}

	public void setDvd_publisher(String dvd_publisher) {
		this.dvd_publisher = dvd_publisher;
	}

	public void setDvd_category(String dvd_category) {
		this.dvd_category = dvd_category;
	}

	public void setDvd_unitsInStock(int dvd_unitsInStock) {
		this.dvd_unitsInStock = dvd_unitsInStock;
	}

	public void setDvd_releaseDate(Date dvd_releaseDate) {
		this.dvd_releaseDate = dvd_releaseDate;
	}

	public void setDvd_condition(String dvd_condition) {
		this.dvd_condition = dvd_condition;
	}

	public void setDvd_thumbnailUrl(String dvd_thumbnailUrl) {
		this.dvd_thumbnailUrl = dvd_thumbnailUrl;
	}

}