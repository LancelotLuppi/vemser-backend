import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");
        MongoCollection<Document> pedidos = mongoDatabase.getCollection("pedidos");

        Document novoPedido = new Document("_id", 0)
                .append("id_cliente", 3)
                .append("id_pet", 5)
                .append("servico", "tosa")
                .append("valor", 45)
                .append("descricao", "SD")
                .append("status", "EM_ANDAMENTO")
                .append("data", new Date(2022, 8, 5));

        Document novoPedido1 = new Document("_id", 1)
                .append("id_cliente", 6)
                .append("id_pet", 8)
                .append("servico", "banho")
                .append("valor", 90)
                .append("descricao", "SD")
                .append("status", "CONCLUIDO")
                .append("data", new Date(2022, 8, 3));

        Document novoPedido2 = new Document("_id", 2)
                .append("id_cliente", 9)
                .append("id_pet", 13)
                .append("servico", "adestramento")
                .append("valor", 150)
                .append("descricao", "SD")
                .append("status", "CONCLUIDO")
                .append("data", new Date(2022, 7, 26));

        // INSERTS
        List<Document> novosPedidos = new ArrayList<>();
        novosPedidos.add(novoPedido1);
        novosPedidos.add(novoPedido2);

        pedidos.insertOne(novoPedido);
        pedidos.insertMany(novosPedidos);


        // UPDATE
        pedidos.updateOne(Filters.eq("_id", 2), new Document("$set", new Document("status", "ABERTO")));
        pedidos.updateOne(Filters.eq("id_pet", 13), new Document("$set", new Document("status", "CANCELADO")));


        // FIND
        System.out.println(pedidos.find(new Document("valor", new Document("$gt", 50))).first());
        System.out.println(pedidos.find(new Document("status", "CANCELADO")).first());


        // AGGREGATE
        pedidos.aggregate(List.of(
                group("status", Accumulators.sum("quantidade", 1))
                )).forEach(System.out::println);

        pedidos.aggregate(List.of(
                match(Filters.eq("valor", new Document("$gt", 50))),
                group("$status", Accumulators.sum("quantidade", 1))
        )).forEach(System.out::println);


        // PROJECTION
        pedidos.find()
                .projection(Projections.exclude("_id", "id_cliente", "id_pet", "descricao"))
                .iterator()
                .forEachRemaining(System.out::println);

        pedidos.find()
                .projection(Projections.exclude("_id", "descricao", "data"))
                .iterator()
                .forEachRemaining(System.out::println);


        // DELETE
        pedidos.deleteOne(Filters.eq("status", "CANCELADO"));
        pedidos.deleteOne(Filters.eq("status", "CONCLUIDO"));
    }
}
