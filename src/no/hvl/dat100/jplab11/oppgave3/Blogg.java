package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	private Innlegg[] innleggstabell;
	private int nesteLedige;

	public Blogg() {
		innleggstabell = new Innlegg[20];
		nesteLedige = 0;
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}

	public Innlegg[] getSamling() {
		return innleggstabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		int i = 0;
		int indeks = -1;
		boolean funnet = false;
		while (i < innleggstabell.length && !funnet) {
			if (innleggstabell[i] != null && innlegg != null) {
				if (innleggstabell[i].erLik(innlegg)) {
					indeks = i;
					funnet = true;
				}
			}
			i++;
		}
		return indeks;
	}

	public boolean finnes(Innlegg innlegg) {
		int i = 0;
		boolean funnet = false;
		while (i < innleggstabell.length && !funnet) {
			if (innleggstabell[i] != null) {
				if (innleggstabell[i].erLik(innlegg)) {
					funnet = true;
				}
			}
			i++;
		}
		return funnet;
	}

	public boolean ledigPlass() {
		boolean b = false;
		if (nesteLedige < innleggstabell.length) {
			b = true;
		}
		return b;
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean b = false;
		if (!finnes(innlegg) && ledigPlass()) {
			innleggstabell[nesteLedige] = innlegg;
			b = true;
			nesteLedige++;
		}
		return b;
	}

	@Override
	public String toString() {
		String b = nesteLedige + "\n";
		for (int i = 0; i < innleggstabell.length; i++) {
			if (innleggstabell[i] != null) {
				b += innleggstabell[i].toString();
			}
		}

		return b;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] lengde = innleggstabell;
		this.innleggstabell = new Innlegg[lengde.length * 2];
		for (int i = 0; i < lengde.length; i++) {
			this.innleggstabell[i] = lengde[i];
		}
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean b = false;
		if (ledigPlass()) {
			leggTil(innlegg);
			b = true;
		} else {
			utvid();
			b = true;
		}
		return b;
	}

	public boolean slett(Innlegg innlegg) {
		boolean b = false;
		if (finnes(innlegg)) {
			int indeks = finnInnlegg(innlegg);
			innleggstabell[indeks] = innleggstabell[nesteLedige - 1];
			innleggstabell[nesteLedige - 1] = null;
			nesteLedige--;
			b = true;
		}
		return b;
	}

	public int[] search(String keyword) {
// bruk contains(keyword)
		int antall = 0;
		int[] idTab = new int[innleggstabell.length];
		for (int i = 0; i < innleggstabell.length; i++) {
			if (innleggstabell[i].toString().contains(keyword)) {
				idTab[antall] = innleggstabell[i].getId();
				antall++;
			}
		}
		return idTab;
	}
}