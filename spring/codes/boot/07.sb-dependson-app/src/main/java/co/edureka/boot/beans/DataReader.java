package co.edureka.boot.beans;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("dataWriter")
public class DataReader {

	public DataReader() {
		System.out.println("DataReader :: Constructor");
	}

}
