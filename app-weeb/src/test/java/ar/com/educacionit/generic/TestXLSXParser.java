package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public class TestXLSXParser {

	public static void main(String[] args) {

		String path = "./src/test/java/ar/com/educacionit/generic/clase35.xlsx";
		
		IParser<Collection <Articulos>> xlsxParser = new XLSFileParser(path);
		
		try {
			Collection<Articulos> articulos = xlsxParser.parse();
//			System.out.println(articulos.size() == 1);
			System.out.println(articulos);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
