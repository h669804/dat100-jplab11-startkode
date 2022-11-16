package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileWriter;
import java.io.FileNotFoundException;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		boolean b = false;
		try {
			FileWriter skriver = new FileWriter(mappe+filnavn);
			skriver.write(samling.toString());
			skriver.close();
			b = true;
		}
		catch(Exception e) {
			b = false;
		}
		return b;
	}
}