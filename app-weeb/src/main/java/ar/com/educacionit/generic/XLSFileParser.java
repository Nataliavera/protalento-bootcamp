package ar.com.educacionit.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Articulos;

public class XLSFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public XLSFileParser(String path) {
		super(path);
	}

//	IMPLEMENTAR EL METODO GENERICO PERO NO DANDOLE UN TIPO CONCRETO 
	@Override
	public Collection<Articulos> parse() throws ParseException {

//		LIBRERIA POI DE APACHE 

//		LEER UN BINARIO 
		File xlsxFile = new File(super.getFilepath());

		Collection<Articulos> articulos = new ArrayList<Articulos>();
		try (InputStream xlsxInputStream = new FileInputStream(xlsxFile);) {
//			CLASES PROPIAS DE LA LIBRERIA 
			try (Workbook workbook = new XSSFWorkbook(xlsxInputStream);) {

//			REPRESENTA LA HOJA 1 DEL LIBRO DE EXCEL 
				Sheet hojas = workbook.getSheetAt(0);

//			COLLECTION
				Iterator<Row> filasHojas = hojas.iterator();

				boolean primerFila = true;
//			LEO LA PRIMER FILA DE LOS TITULOS PARA SALTEARLOS 

				while (filasHojas.hasNext()) {
					Row filaActual = filasHojas.next();
					if (primerFila) {
						primerFila = false;
						continue;
					}
//			LEO LAS FILAS DE LOS DATOS 
					Iterator<Cell> celdas = filaActual.iterator();

//		ARTICULOS
					Articulos articulo = new Articulos();

					while (celdas.hasNext()) {
						Cell celdaActual = celdas.next();
						String valor;
						switch (celdaActual.getColumnIndex()) {// 0 > N
						case 0:
							valor = celdaActual.getStringCellValue();// ME DEVUELVE EL VALOR DE LA CELDA
							articulo.setTitulo(valor);
							break;
						case 1:
							valor = celdaActual.getStringCellValue();// ME DEVUELVE EL VALOR DE LA CELDA
							articulo.setCodigo(valor);
							break;
						case 2:
							Double valorD = celdaActual.getNumericCellValue();// ME DEVUELVE EL VALOR DE LA CELDA
							articulo.setPrecio(valorD);
							break;
						case 3:
							Double stock = celdaActual.getNumericCellValue();// ME DEVUELVE EL VALOR DE LA CELDA
							articulo.setStock(stock.longValue());
							break;
						case 4:
							Double marcasId = celdaActual.getNumericCellValue();// ME DEVUELVE EL VALOR DE LA CELDA
							articulo.setMarcaId(marcasId.longValue());
							break;
						case 5:
							Double categoriasId = celdaActual.getNumericCellValue();// ME DEVUELVE EL VALOR DE LA CELDA
							articulo.setCategoriaId(categoriasId.longValue());
						default:
							break;
						}
						articulo.setFechaCreacion(new Date());
					}
					articulos.add(articulo);
				}
			}
		} catch (IOException e) {
			throw new ParseException("No se ha podido parsear el archivo: " + getFilepath(), e);
		}

		return articulos;
	}
	
	/*
	 * RECOORE LAS CELDAS DE UNA FILA Y POR CADA CELDA MIRA QUE ATRIBUTO CORRESPONDE EN ARTICULO Y 
	 * SETEA DICHO VALOR */

}
