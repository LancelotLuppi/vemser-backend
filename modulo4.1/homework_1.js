db.pedidos.insertOne(
    { _id: 0, id_cliente: 1, id_pet: 1, servico: "banho", valor: 90, descricao: "SD", status: "ABERTO", data: "2022-08-04" }
)

db.pedidos.insertMany(
    { _id: 1, id_cliente: 2, id_pet: 2, servico: "tosa", valor: 45, descricao: "Pelo fragilizado", status: "EM_ANDAMENTO", data: "2022-08-05" },
    { _id: 2, id_cliente: 5, id_pet: 5, servico: "corte de unha", valor: 15, descricao: "SD", status: "CONCLUIDO", data: "2022-08-02" },
    { _id: 3, id_cliente: 2, id_pet: 2, servico: "banho", valor: 60, descricao: "SD", status: "CONCLUIDO", data: "2022-08-02" },
    { _id: 4, id_cliente: 7, id_pet: 9, servico: "adestramento", valor: 150, descricao: "arisco com desconhecidos", status: "CANCELADO", data: "2022-08-03" }
)

db.pedidos.find({status: "CONCLUIDO"})
db.pedidos.find({valor: {$lt: 70}})