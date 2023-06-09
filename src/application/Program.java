package application;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Program {

	public static void main(String[] args) throws Exception {
		
		// fazer uma requisição http e buscar os 250 filmes
		String url = "https://api.themoviedb.org/3/movie/popular?api_key=b7a68307539a2673a636405a0dc01f2e";
		var address = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(address).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		System.out.println(body);
		
		// Extrair somente os dados que interessam (nome, poster, rating)	
		JsonParser parser = new JsonParser();
		
		List<Map<String, String>> listOfMovies = parser.parse(body);
		
		// Exibir e manipular dados
		for (Map<String, String> movie : listOfMovies) {
			System.out.println();
			System.out.println(movie.get("title"));
			System.out.println(movie.get("release_date"));
			System.out.println(movie.get("overview"));
		}

	}

}
