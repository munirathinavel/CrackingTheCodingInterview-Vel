package intuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Movies {
	int page;
	int per_page;
	int total;
	int total_pages;
	List<Movie> data;

}

class Movie {
	String Poster;
	String Title;
	String Type;
	String Year;
	String imdbID;
}

public class Solution {

	public static void main(String[] args) throws IOException {

		List<String> titles = new ArrayList<String>();

		String url1 = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";
		Movies movies = getMoviesAndUpdateTitles(titles, url1);
		int currentPage = 1;
		int totalPages = movies.total_pages;

		for (Movie movie : movies.data) {
			titles.add(movie.Title);
		}

		while (currentPage <= totalPages) {
			movies = getMoviesAndUpdateTitles(titles, url1 + "&page=" + currentPage + 1);

			for (Movie movie : movies.data) {
				titles.add(movie.Title);
			}
			currentPage++;
		}
		Collections.sort(titles);
		for (String title : titles) {
			System.out.println(title);
		}

	}

	private static Movies getMoviesAndUpdateTitles(List<String> titles, String urlSource)
			throws MalformedURLException, IOException, ProtocolException {

		String urlString = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		// Reading response from input Stream
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String output;
		StringBuffer response = new StringBuffer();

		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();

		// printing result from response

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		Movies movies = gson.fromJson(response.toString(), Movies.class);

		return movies;
	}

}
