package dionis.models;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import dionis.exception.DionisXMLException;
import dionis.utils.Configuration;
import dionis.utils.DionisXML;
import dionis.xml.Dionis;

/**
 * Класс XML Access Object
 * 
 * @author Ярных А.О.
 * 
 */
public class DionisXAO {

	private static DionisXML dionisXML = new DionisXML();

	// статический объект конфигурации "Диониса"
	public static Dionis dionis = new Dionis();

	private DionisXAO() {
	}

	/**
	 * Метод, десериализующий данные из XML и возвращающий объект конфигурации
	 * 
	 * @return
	 */
	public static Dionis getDionis() {
		try {
			dionisXML.unmarshall(Configuration.inputBase);
			dionis = (Dionis) dionisXML.getDionisJaxb();
		} catch (DionisXMLException | JAXBException | IOException
				| SAXException | URISyntaxException e) {
			e.printStackTrace();
		}
		return dionis;
	}

	/**
	 * Метод, сериализующий объект конфигурации dionis в XML
	 * 
	 * @param dionis
	 */
	public static void setDionis(Dionis dionis) {
		try {
			dionisXML.marshall(Configuration.outputBase);
			dionisXML.setDionisJaxb(dionis);
		} catch (DionisXMLException | JAXBException | IOException
				| SAXException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
