package dionis.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Синглтон конфигурации
 * 
 * @author Ярных А.О.
 * 
 */
public class Configuration {

	private Configuration() {
	}

	/** Путь до файла схемы **/
	public static String xsdPath = "/Dionis/src/dionis/xsd/Dionis.xsd";
	/** Путь до файлов сериализации **/
	public static Path inputBase = Paths.get("/home/alm/dionis.xml");
	public static Path outputBase = Paths.get("/home/alm/dionis_out.xml");
	
}
