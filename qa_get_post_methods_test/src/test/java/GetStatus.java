import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

public class GetStatus {
	@Test
	public void GetRequest() throws UnirestException
	 {
	 
		GetRequest resp = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?interval=5min&function=TIME_SERIES_INTRADAY&symbol=MSFT&datatype=json&output_size=compact")
				.header("X-RapidAPI-Key", "9d059a5ademsh177a495d0aaa50ep1eb887jsn796d6e5504b8")
				.header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com");
 System.out.println("Http Status : "	+ resp.asString().getStatus());		
		JsonNode response = resp
				.asJson().getBody();
		assertEquals(resp.asString().getStatus(),200);
		System.out.println(response);         // gives the full json response
		System.out.println(response.getArray().length());  // gives the no of items
}
}