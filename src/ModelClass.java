/**
 * @author Michael Cohen
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

public abstract class ModelClass {
	
	@SuppressWarnings("rawtypes")
	protected Map parse(String data) {
		JsonParserFactory factory = JsonParserFactory.getInstance();
		JSONParser parser = factory.newJsonParser();
		Map jsonData = parser.parseJson(data);
		Map root = (Map) jsonData.get("root");
		
		return root;
	}
	protected String get(String urlAddress) throws IOException {
		urlAddress = "http://pokeapi.co/api/v1/" + urlAddress;
		URL url = new URL(urlAddress);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}
		
		//Buffer Result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		//Disconnect
		rd.close();
		conn.disconnect();
		
		return sb.toString();
	}
}
