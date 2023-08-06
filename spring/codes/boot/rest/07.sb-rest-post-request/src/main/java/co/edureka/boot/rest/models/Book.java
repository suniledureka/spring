package co.edureka.boot.rest.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Book {
	private Integer bookId;
	private String bookTitle;
	private Float bookPrice;
}
