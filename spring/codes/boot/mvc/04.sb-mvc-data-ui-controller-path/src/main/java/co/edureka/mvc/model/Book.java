package co.edureka.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	private Integer bookId;
	private String bookTitle;
	private Float bookPrice;
}
