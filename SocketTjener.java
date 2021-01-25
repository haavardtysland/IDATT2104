import java.io.*;
import java.net.*;

class SocketTjener {
  public static void main(String[] args) throws IOException {
    final int PORTNR = 1250;

    ServerSocket tjener = new ServerSocket(PORTNR);
    System.out.println("Logg for tjenersiden. N� venter vi...");
    Socket forbindelse = tjener.accept();  // venter inntil noen tar kontakt

    /* �pner str�mmer for kommunikasjon med klientprogrammet */
    InputStreamReader leseforbindelse = new InputStreamReader(forbindelse.getInputStream());
    BufferedReader leseren = new BufferedReader(leseforbindelse);
    PrintWriter skriveren = new PrintWriter(forbindelse.getOutputStream(), true);

    /* Sender innledning til klienten */
    skriveren.println("Hei, du har kontakt med tjenersiden!");
    skriveren.println("Skriv tall og hva du vil gjøre med dem på format tall tall +/- Avslutt med å trykke Enter uten å taste inn noe annet");

    /* Mottar data fra klienten */
    String linje = leseren.readLine();  // mottar en linje med tekst
    while (linje != null) {  // forbindelsen på klientsiden er lukket
      System.out.println("En klient skrev: " + linje);
      String[] tall = linje.split(" ");
      int x = Integer.parseInt(tall[0]);
      int y = Integer.parseInt(tall[1]);
      String valg = tall[2];
      if(valg.equals("+")){
      skriveren.println("Sum: " + addisjon(x, y));
      } else if (valg.equals("-")){
        skriveren.println("Sum: " + substraksjon(x, y));
      } else {
        skriveren.println("Ugyldig");
      }
      linje = leseren.readLine();  // mottar en linje med tekst
    }

    /* Lukker forbindelsen */
    leseren.close();
    skriveren.close();
    forbindelse.close();
  }

  private static int addisjon(int x, int y) {
    return x + y;
  }

  private static int substraksjon(int x, int y) {
    return x - y;
  }
}
