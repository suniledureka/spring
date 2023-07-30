package co.edureka.cms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTACT_MASTER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {
	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	public Contact(String contactName, String contactNumber) {
		super();
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}	
	
	
}
