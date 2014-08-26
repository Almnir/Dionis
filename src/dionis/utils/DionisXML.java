package dionis.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import dionis.exception.DionisXMLException;
import dionis.xml.Dionis;

/**
 * Класс отвечает за маршализацию/демаршализацию конфигурации Диониса из/в XML.
 * 
 * @author Ярных А.О.
 * 
 */
public class DionisXML {

	private final String schemeUrl = "http://www.w3.org/2001/XMLSchema";
	private Dionis dionisJaxb;

	public DionisXML() {

	}

	/**
	 * Распаковываем из XML
	 * 
	 * @param xmlFile
	 *            путь до XML-файла
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 * @throws IllegalModuleConfigException
	 * @throws SAXException
	 * @throws URISyntaxException
	 */
	public void unmarshall(final Path xmlFile) throws JAXBException,
			IOException, SAXException, URISyntaxException {
		JAXBContext jc = JAXBContext.newInstance(Dionis.class);
		Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();

		jaxbUnmarshaller.setSchema(SchemaFactory.newInstance(this.schemeUrl)
				.newSchema(new File(Configuration.xsdPath)));

		try (InputStream is = Files.newInputStream(xmlFile)) {
			this.dionisJaxb = (Dionis) jaxbUnmarshaller.unmarshal(is);
		}
	}

	/**
	 * Упаковываем в XML
	 * 
	 * @param xmlFile
	 *            путь до XML-файла
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ModuleException
	 * @throws SAXException
	 * @throws URISyntaxException
	 */
	public void marshall(final Path xmlFile) throws JAXBException, IOException,
			DionisXMLException, SAXException, URISyntaxException {
		if (dionisJaxb == null) {
			throw new DionisXMLException(
					"Ошибка сериализации конфигурации Диониса, конфигурация пуста.");
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(Dionis.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		jaxbMarshaller.setSchema(SchemaFactory.newInstance(this.schemeUrl)
				.newSchema(new File(Configuration.xsdPath)));

		try (OutputStream os = Files.newOutputStream(xmlFile);) {
			jaxbMarshaller.marshal(this.dionisJaxb, os);
		}
	}

	/**
	 * Получить класс настроек Диониса
	 * 
	 * @return класс настроек Диониса
	 * @throws ModuleException
	 */
	public Object getDionisJaxb() throws DionisXMLException {
		if (dionisJaxb == null) {
			throw new DionisXMLException("Конфигурация пуста.");
		}
		return this.dionisJaxb;
	}

	/**
	 * Установить класс настроек Диониса
	 * 
	 * @param dionisConfig
	 *            класс настроек Диониса
	 * 
	 * @throws ModuleException
	 */
	public void setDionisJaxb(final Object dionisConfig)
			throws DionisXMLException {
		if (dionisConfig instanceof Dionis) {
			this.dionisJaxb = (Dionis) dionisConfig;
		} else {
			throw new DionisXMLException("Jaxb, не верно задан аргумент.");
		}
	}
}
