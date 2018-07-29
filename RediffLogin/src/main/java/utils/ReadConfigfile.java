package utils;




import java.io.InputStream;
import java.util.Properties;

public class ReadConfigfile {
	
	protected InputStream input = null;
	protected Properties prop = null;
	
	public ReadConfigfile() {
		
		/* try {
			ReadConfigfile.class.getClassLoader();
			ClassLoader.getSystemResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
			 String path=System.getProperty("user.dir")+"\\src\\main\\java\\properties\\Config.properties";
				Properties prop = new Properties();
				FileInputStream fs = new FileInputStream(path);
				
				prop.load(fs);
			//	System.out.println(prop.getProperty("browser"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public String getBrowser() {
		if(prop.getProperty("browserName")== null)
		return "";
		return prop.getProperty("browserName");
		
	}*/
		/*try {
			input = ReadConfigfile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	public String getBrowser() {
		if (prop.getProperty("browserName") == null)
			return "";
		return prop.getProperty("browserName");
	}
}


