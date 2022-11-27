import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PostStatus {
	
	@Test 
	public void TestPostStatus () throws UnirestException {
		//İngilizce'den İspanyolca'ya Merhaba Dünya Çevirisi
		HttpResponse<String> response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("Accept-Encoding", "application/gzip")
				.header("X-RapidAPI-Key", "9d059a5ademsh177a495d0aaa50ep1eb887jsn796d6e5504b8")
				.header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
				.body("q=Hello%2C%20world!&target=es&source=en")
				.asString();
		assertEquals(response.getStatus(),200);
		System.out.println("Http Status : " + response.getStatus());
		System.out.println(response.getBody());
	}
	
}
