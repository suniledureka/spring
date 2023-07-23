package co.edureka.boot.beans;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class DataWriter {

	public DataWriter() {
		System.out.println("DataWriter :: Constructor");
	}

}
