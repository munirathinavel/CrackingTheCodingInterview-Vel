package practise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class A {

	/**
	 * Locates the universe-formula??????????????????????????????? file.
	 */
	public static void main(String[] args) {
		locateUniverseFormula();
	}

	static String locateUniverseFormula() {
		File a = new File("munirathinavel//Downloads");
	//	absolute=C:\Users\munirathinavel\Vel_Workspace\Java-Praxis-All-In-One\Users

		File parentFolder = new File(a.getParent());
		File b = new File(parentFolder, "../General Application.pdf");
		try {
			String absolute = b.getCanonicalPath();
			System.out.println("absolute=" + absolute);
		} catch (IOException e1) {
			e1.printStackTrace();
		} // may throw IOException

		try (Stream<Path> paths = Files.walk(Paths.get("C://Users//munirathinavel//Downloads"))) {
			// paths.filter(Files::isRegularFile).forEach(System.out::println);
		} catch (Exception e) {
			return null;
		}
		return "";

	}

}