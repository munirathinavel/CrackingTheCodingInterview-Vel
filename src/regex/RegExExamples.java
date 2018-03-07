package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExamples {

	public static void main(String[] args) {

		String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";

		String regex = ".*http://.*";

		boolean matches = Pattern.matches(regex, text);

		System.out.println("matches = " + matches);

		text = "This is the text which is to be searched " + "for occurrences of the word 'is'.";

		regex = "is";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
		}

		String s = "This is is one one more more sentense";
		String reg = "\\b(\\w+)(\\W+\\1\\b)+";
		pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

		Matcher m = pattern.matcher(s);

		while (m.find()) {
			s = s.replaceAll(m.group(), m.group(1));
		}

		System.out.println(s);
		
	       regex = "<(.+)>(^[<].+)</\\1>"; //<(.+)>(^[<].+)</\\1>
	      Pattern p = Pattern.compile(regex);
	         String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
	         m = p.matcher(line);
	          StringBuffer sb = new StringBuffer();
	          while(m.find()){
	              sb.append(m.group(2));
	          }
	          System.out.println(sb.toString());
	}
}
