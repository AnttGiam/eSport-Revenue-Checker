import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author Antonio Giametta
 * @project Base Dati 2
 */

public class ManagerDB {

    public static String dbName = "ProgettoBD2";
    public static String collectionName = "Players";
    public static GUI gui;
    public static JButton cercaNick;
    public static JButton cercaNazione;
    public static JButton cercaNome;
    public static JButton cercaCognome;
    public static JButton cercaGioco;
    public static JButton cercaGenere;
    public static JButton resetButton;
    public static JButton crescenteButton;
    public static JButton contaGioco;
    public static JButton contaGeneri;
    public static JButton decrescenteButton;
    public static JButton allButton;
    public static JTextField ricercaField;
    public static JTextArea viewArea;


    public ManagerDB(){

    }

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";;
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            if(mongoClient!=null)
                System.out.println("Connesso correttamente a " + uri);
            MongoDatabase database = mongoClient.getDatabase(dbName);
            if(database!=null)
                System.out.println("Selezionato Database " + dbName);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            if(collection!=null)
                System.out.println("Selezionata Collezione " + collectionName);
            gui= new GUI();
            viewArea = gui.getViewArea();
            viewArea.setText("Ciao Sono Entrato");
            cercaNick = gui.getRicercaNick();
            cercaNazione = gui.getRicercaNazionalita();
            cercaNome = gui.getRicercaNome();
            cercaCognome = gui.getRicercaCognome();
            cercaGioco = gui.getRicercaGioco();
            cercaGenere = gui.getRicercaGenere();
            ricercaField= gui.getRicercaField();
            resetButton=gui.getResettaButton();
            crescenteButton=gui.getOrdinaCrescenteButton();
            decrescenteButton=gui.getOrdinaDecrescenteButton();
            contaGioco=gui.getContaGiochi();
            contaGeneri=gui.getContaGeneri();
            allButton=gui.getAllButton();
            allButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaTutti(collection)));
                }
            });
            contaGioco.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(contaGiochiPerGiocatori(collection)));
                }
            });
            contaGeneri.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(contaGenerePerGiocatore(collection)));
                }
            });
            crescenteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(ordinaGuadagni(collection,1)));
                }
            });
            decrescenteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(ordinaGuadagni(collection,0)));
                }
            });
            resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText("");
                }
            });
            cercaNick.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaNickname(collection,ricercaField.getText())));
                }
            });
            cercaNazione.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaNazione(collection,ricercaField.getText())));
                }
            });
            cercaNome.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaNome(collection,ricercaField.getText())));
                }
            });
            cercaCognome.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaCognome(collection,ricercaField.getText())));
                }
            });
            cercaGenere.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaGenere(collection,ricercaField.getText())));
                }
            });
            cercaGioco.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewArea.setText(StringMultipleResult(cercaGioco(collection,ricercaField.getText())));
                }
            });
            Excape();
            gui.setVisible(false);
        }
        System.out.println("Programma Finito");
    }


    //ESCAPE FUNZIONE
    public static void Excape()
    {
        int i=1;
        Scanner scanner = new Scanner(System.in);
        while(i!=0)
        {
            i= scanner.nextInt();
        }
    }
    //QUERY

    public static MongoCursor<Document> cercaTutti(MongoCollection<Document> collection){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco","Paese"),
                Projections.excludeId());

        MongoCursor<Document> risultati = collection.find()
                .projection(projectionFields)
                .sort(Sorts.ascending("Cognome")).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static MongoCursor<Document> cercaNickname(MongoCollection<Document> collection, String Nickname){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco","Paese"),
                Projections.excludeId());

        MongoCursor<Document> risultati = collection.find(eq("Nickname",Nickname))
                .projection(projectionFields)
                .sort(Sorts.ascending("Cognome")).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }
    public static MongoCursor<Document> cercaNazione(MongoCollection<Document> collection, String Nazione){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco"),
                Projections.excludeId());

        MongoCursor<Document> risultati=null;
        try {
                     risultati = collection.find(eq("Paese", Nazione))
                        .projection(projectionFields)
                        .sort(Sorts.ascending("Cognome")).iterator();
             }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (risultati == null) {
            return null;
        } else {
            System.out.println("Trovati Risultati");
            return risultati;
        }
    }

    public static MongoCursor<Document> cercaNome(MongoCollection<Document> collection, String Nome){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco"),
                Projections.excludeId());

        MongoCursor<Document> risultati = collection.find(eq("Nome",Nome))
                .projection(projectionFields)
                .sort(Sorts.ascending("Cognome")).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static MongoCursor<Document> cercaCognome(MongoCollection<Document> collection, String Cognome){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco"),
                Projections.excludeId());

        MongoCursor<Document> risultati = collection.find(eq("Cognome",Cognome))
                .projection(projectionFields)
                .sort(Sorts.ascending("Cognome")).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static MongoCursor<Document> cercaGioco(MongoCollection<Document> collection, String Gioco){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco"),
                Projections.excludeId());

        MongoCursor<Document> risultati = collection.find(eq("Gioco",Gioco))
                .projection(projectionFields)
                .sort(Sorts.ascending("Cognome")).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static MongoCursor<Document> cercaGenere(MongoCollection<Document> collection, String Genere){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco"),
                Projections.excludeId());

        MongoCursor<Document> risultati = collection.find(eq("Genere",Genere))
                .projection(projectionFields)
                .sort(Sorts.ascending("Cognome")).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static MongoCursor<Document> ordinaGuadagni(MongoCollection<Document> collection, int sort){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni","Gioco"),
                Projections.excludeId());

        MongoCursor<Document> results;
        if(sort == 1)
        {
            MongoCursor<Document> risultati = collection.find()
                .projection(projectionFields)
                .sort(Sorts.ascending("Guadagni")).iterator();
            results=risultati;
        }
        else {
            MongoCursor<Document> risultati = collection.find()
                    .projection(projectionFields)
                    .sort(Sorts.descending("Guadagni")).iterator();
            results=risultati;
        }
        if (results == null) {
            return null;
        } else {
            return results;
        }
    }

    public static MongoCursor<Document> contaGenerePerGiocatore(MongoCollection<Document> collection){
        MongoCursor<Document> risultati = collection.aggregate(Arrays.asList(
                Aggregates.group("$Genere", Accumulators.sum("Gioco",1))
        )).iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static MongoCursor<Document> contaGiochiPerGiocatori(MongoCollection<Document> collection){
        MongoCursor<Document> risultati = collection.aggregate(Arrays.asList(
                Aggregates.group("$Gioco", Accumulators.sum("Giocatori",1))
        ))
                .iterator();
        if (risultati == null) {
            return null;
        } else {
            return risultati;
        }
    }

    public static void inserisciGiocatore(MongoCollection<Document> collection, String Nome, String Cognome,String Nickname, String Paese, Double Guadagni, String Gioco, String Genere){
        try {
            InsertOneResult result = collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("Nome",Nome)
                    .append("Cognome",Cognome)
                    .append("Nickname",Nickname)
                    .append("Paese",Paese)
                    .append("Guadagni",Guadagni)
                    .append("Gioco",Gioco)
                    .append("Genere",Genere));
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
        } catch (MongoException me) {
            System.err.println("Unable to insert due to an error: " + me);
        }
    }

    public static void modificaGiocatore(MongoCollection<Document> collection, String Nickname, String Nome, String Cognome, String Paese, String Newnickname, String Gioco, String Genere)
    {
        Document query = new Document().append("Nickname",  Nickname);
        Bson updates = Updates.combine(
                Updates.set("Nome", Nome),
                Updates.set("Cognome", Cognome),
                Updates.set("Paese", Paese),
                Updates.set("Nickname",Newnickname),
                Updates.set("Gioco",Gioco),
                Updates.set("Genere", Genere));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = collection.updateOne(query, updates, options);
            System.out.println("Modified document count: " + result.getModifiedCount());
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
        }
    }

    public static void aggiungiGuadagni(MongoCollection<Document> collection, String Nickname, Double guadagni)
    {
        Document query = new Document().append("Nickname",  Nickname);
        Bson updates = Updates.combine(
                Updates.inc("Guadagni",guadagni));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = collection.updateOne(query, updates, options);
            System.out.println("Modified document count: " + result.getModifiedCount());
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
        }
    }

    public static void cancellaGiocatore(MongoCollection<Document> collection, String Nickname){
        Bson query = eq("Nickname", Nickname);
        try {
            DeleteResult result = collection.deleteOne(query);
            System.out.println("Cancellato Giocatore: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Giocatore non Cancellato " + me);
        }
    }

    //OUTPUT RISULTATI
    public static void PrintSingleResult(Document doc)
    {
        if(doc!=null)
        {
            System.out.println(doc.toJson());
        }
        else
            System.out.println("Nessun Risultato Trovato");
    }

    public static void PrintMultipleResult(MongoCursor<Document> results)
    {
        try
        {
            if(results.hasNext()==false)
                System.out.println("Nessun Risultato Trovato");
            while(results.hasNext())
            {
                System.out.println(results.next().toJson());
            }
        }
        finally
        {
                results.close();
        }
    }

    public static String StringMultipleResult(MongoCursor<Document> results)
    {
        try
        {
            String result="";
            if(results.hasNext()==false)
                result="Nessun Risultato Trovato";
                //guiView.setText("Nessun Risultato Trovato");
            while(results.hasNext())
            {
                result+=results.next().toJson();
                result+="\n";
            }
            return result;

        }
        finally
        {
            results.close();
        }
    }


    //MENU
    //DEPRECATED WITH GUI
    /*

    public static void Menu(MongoCollection<Document> collection)
    {
        int exitCode=1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("Benvenuto nel mio progetto di Basi di Dati 2");
        System.out.println("In questo programma potrai approfondire la conoscenza sui guadagni dei giocatori di eSports");
        while(exitCode!=0) {
            System.out.println("-------------------------------------");
            System.out.println("-------------- MENU' ----------------");
            System.out.println("-------------------------------------");
            System.out.println("Digita 1: Ricercare un Giocatore per Nickname");
            System.out.println("Digita 2: Ricercare un Giocatore per Nazionalità");
            System.out.println("Digita 3: Ricercare un Giocatore per Nome");
            System.out.println("Digita 4: Ricercare un Giocatore per Cognome");
            System.out.println("Digita 5: Ricercare un Giocatore per Gioco");
            System.out.println("Digita 6: Ricercare un Giocatore per Genere");
            System.out.println("Digita 7: Ordina in modo crescente i Giocatori per Guadagni");
            System.out.println("Digita 8: Ordina in modo decrescente i Giocatori per Guadagni");
            System.out.println("Digita 9: Conta i Giocatori per Genere");
            System.out.println("Digita 10: Conta i Giocatori per ogni Gioco");
            System.out.println("Digita 11: Inserisci un nuovo Giocatore");
            System.out.println("Digita 12: Modifica un Giocatore Esistente");
            System.out.println("Digita 13: Aggiungi Guadagni ad un Giocatore");
            System.out.println("Digita 14: Rimuovi un Giocatore");
            System.out.println("Digita 0: Uscire");
            System.out.print("Inserisci la tua Selezione: ");
            exitCode = scanner.nextInt();
            System.out.println("Hai scelto l'opzione "+ exitCode);
            switch (exitCode){
                case 1:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nickname Giocatore:");
                    String nickName=scanner.nextLine();
                    PrintSingleResult(cercaNickname(collection, nickName));
                  break;
                }
                case 2:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nazionalità Giocatore:");
                    String nazione=scanner.nextLine();
                    PrintMultipleResult(cercaNazione(collection, nazione));
                    break;
                }
                case 3:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nome Giocatore:");
                    String nome=scanner.nextLine();
                    PrintMultipleResult(cercaNome(collection, nome));
                    break;
                }
                case 4:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Cognome Giocatore:");
                    String cognome=scanner.nextLine();
                    PrintMultipleResult(cercaCognome(collection, cognome));
                    break;
                }
                case 5:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Gioco:");
                    String gioco=scanner.nextLine();
                    PrintMultipleResult(cercaGioco(collection, gioco));
                    break;
                }
                case 6:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Genere:");
                    String genere=scanner.nextLine();
                    PrintMultipleResult(cercaGenere(collection, genere));
                    break;
                }
                case 7:
                {
                    scanner.nextLine();
                    PrintMultipleResult(ordinaGuadagni(collection, 1));
                    break;
                }
                case 8:
                {
                    scanner.nextLine();
                    PrintMultipleResult(ordinaGuadagni(collection, 0));
                    break;
                }
                case 9:
                {
                    scanner.nextLine();
                    PrintMultipleResult(ordinaGiochiPerGenere(collection));
                    break;
                }
                case 10:
                {
                    scanner.nextLine();
                    PrintMultipleResult(ordinaGiochiPerGiocatori(collection));
                    break;
                }
                case 11:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nome: ");
                    String nome=scanner.nextLine();
                    System.out.print("Inserisci Cognome: ");
                    String cognome=scanner.nextLine();
                    System.out.print("Inserisci Nickname: ");
                    String nickname=scanner.nextLine();
                    System.out.print("Inserisci Paese: ");
                    String paese=scanner.nextLine();
                    System.out.print("Inserisci Guadagni (usa il punto per i decimali): ");
                    String guadagniStr = scanner.nextLine();
                    Double guadagniDouble = Double.parseDouble(guadagniStr);
                    System.out.print("Inserisci Gioco: ");
                    String gioco = scanner.nextLine();
                    System.out.print("Inserisci Genere: ");
                    String genere = scanner.nextLine();
                    inserisciGiocatore(collection,nome,cognome,nickname,paese,guadagniDouble,gioco,genere);
                    break;
                }
                case 12:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nickname: ");
                    String nickname=scanner.nextLine();
                    System.out.print("Inserisci Nuovo Nome: ");
                    String nome=scanner.nextLine();
                    System.out.print("Inserisci Nuovo Cognome: ");
                    String cognome=scanner.nextLine();
                    System.out.print("Inserisci Nuovo Paese: ");
                    String paese=scanner.nextLine();
                    System.out.print("Inserisci Nuovo Nickname: ");
                    String newnickname=scanner.nextLine();
                    System.out.print("Inserisci Nuovo Gioco: ");
                    String gioco = scanner.nextLine();
                    System.out.print("Inserisci Nuovo Genere: ");
                    String genere = scanner.nextLine();
                    modificaGiocatore(collection,nickname,nome,cognome,paese,newnickname,gioco,genere);
                    break;
                }
                case 13:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nickname: ");
                    String nickname=scanner.nextLine();
                    System.out.print("Inserisci Guadagni: ");
                    String guadaniStr = scanner.nextLine();
                    Double guadagniDouble = Double.parseDouble(guadaniStr);
                    aggiungiGuadagni(collection,nickname,guadagniDouble);
                    break;
                }
                case 14:
                {
                    scanner.nextLine();
                    System.out.print("Inserisci Nickname: ");
                    String nickname=scanner.nextLine();
                    cancellaGiocatore(collection,nickname);
                    break;
                }
            }
        }
    }
     */
}
