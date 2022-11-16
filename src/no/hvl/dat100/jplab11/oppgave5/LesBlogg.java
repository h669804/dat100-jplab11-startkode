package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		BufferedReader leser;
		PrintWriter skriver;
		Blogg innlegg = null;
		int nesteLedige = 0;
		try {
			leser = new BufferedReader(new FileReader(mappe + filnavn));
			innlegg = new Blogg(leser.read());
			Innlegg[] innleggstabell = innlegg.getSamling();
			nesteLedige = innlegg.getAntall();

			for (int i = 0; i < innleggstabell.length; i++) {
				while (leser.readLine() != null) {
					if (leser.readLine().equals(TEKST)) {
						//Innlegg bilde = 
						//innleggstabell[nesteLedige] = bilde;
						nesteLedige++;
					}
					if (leser.readLine().equals(BILDE)) {
						//Innlegg bilde = Bilde(id, bruker, dato, likes, tekst, url);
						//innleggstabell[nesteLedige] = bilde;  
						nesteLedige++;

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return innlegg;
	}

}
