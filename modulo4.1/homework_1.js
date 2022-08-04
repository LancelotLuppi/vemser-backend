db.pedidos.insertOne(
    { _id: 0, servico: "banho", valor: 90, descricao: "SD", status: "ABERTO", data: "2022-08-04" }
)

db.pedidos.insertMany(
    { _id: 1, servico: "tosa", valor: 45, descricao: "Pelo fragilizado", status: "EM_ANDAMENTO", data: "2022-08-05" },
    { _id: 2, servico: "corte de unha", valor: 15, descricao: "SD", status: "CONCLUIDO", data: "2022-08-02" },
    { _id: 3, servico: "banho", valor: 60, descricao: "SD", status: "CONCLUIDO", data: "2022-08-02" },
    { _id: 4, servico: "adestramento", valor: 150, descricao: "arisco com desconhecidos", status: "CANCELADO", data: "2022-08-03" }
)

db.pedidos.find({status: "CONCLUIDO"})
db.pedidos.find({valor: {$lt: 70}})