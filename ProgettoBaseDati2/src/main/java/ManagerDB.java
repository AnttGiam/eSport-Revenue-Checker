import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author Antonio Giametta
 * @project Base Dati 2
 */

public class ManagerDB {

    public static String dbName = "ProgettoBD2";
    public static String collectionName = "Players";

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            System.out.println("Connesso correttamente a " + uri);
            MongoDatabase database = mongoClient.getDatabase(dbName);
            System.out.println("Selezionato Database " + dbName);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            System.out.println("Selezionata Collezione " + collectionName);
            Menu(collection);


        }
    }
    public static Document cercaNickname(MongoCollection<Document> collection, String Nickname){
        Bson projectionFields = Projections.fields(
                Projections.include("Nome", "Cognome","Nickname","Guadagni"),
                Projections.excludeId());
        Document doc = collection.find(eq("Nickname", Nickname))
                .projection(projectionFields)
                .sort(Sorts.descending("Nome"))
                .first();
        if (doc == null) {
            return null;
        } else {
            return doc;
        }
    }

    public static void PrintSingleResult(Document doc)
    {
        if(doc!=null)
        {
            System.out.println(doc.toJson());
        }
        else
            System.out.println("Nessun Risultato Trovato");
    }

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
            System.out.println("Digita 0: Uscire");
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
            }
        }

    }
}
