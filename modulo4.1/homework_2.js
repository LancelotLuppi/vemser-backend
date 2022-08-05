db.pets.insertOne(
    {
        _id: 0,
        id_cliente: 0,
        nome: "Eros",
        tipo: "GATO",
        raca: "SRD",
        pelagem: "LONGO",
        porte: "MEDIO",
        idade: 8
    }
)
db.pets.insertMany([
    {
        _id: 2,
        id_cliente: 2,
        nome: "Rex",
        tipo: "CACHORRO",
        raca: "Labrador",
        porte: "GRANDE",
        pelagem: "CURTO",
        idade: 5
    },
    {
        _id: 5,
        id_cliente: 5,
        nome: "Riley",
        tipo: "CACHORRO",
        raca: "Pastor Alemão",
        porte: "MEDIO",
        pelagem: "MEDIO",
        idade: 1
    },
    {
        _id: 9,
        id_cliente: 7,
        nome: "Qiyana",
        tipo: "GATO",
        raca: "SRD",
        porte: "MEDIO",
        pelagem: "LONGO",
        idade: 2
    }
])

db.pedidos.insertMany(
    [
        { _id: 2, id_cliente: 5, id_pet: 5, servico: "corte de unha", valor: 15, descricao: "SD", status: "CONCLUIDO", data: "2022-08-02" },
        { _id: 3, id_cliente: 2, id_pet: 2, servico: "banho", valor: 60, descricao: "SD", status: "CONCLUIDO", data: "2022-08-02" },
        { _id: 4, id_cliente: 7, id_pet: 9, servico: "adestramento", valor: 150, descricao: "arisco com desconhecidos", status: "CANCELADO", data: "2022-08-03" }
    ]
)

db.pedidos.insertOne({ _id: 0, id_cliente: 0, id_pet: 0, servico: "tosa", valor: 45, descricao: "Pelo fragilizado", status: "EM_ANDAMENTO", data: "2022-08-05" })


// FIND
db.pedidos.find({status: "CONCLUIDO", valor: {$gt: 50}})
db.pedidos.find({status: "CONCLUIDO", id_cliente: 7})
db.pets.find({tipo: "CACHORRO"}).sort({idade: +1})
db.pets.find({tipo: "GATO"})

// UPDATE
db.pets.updateOne(
    {_id: 9},
    {$set: {idade: 3}}
)
db.pedidos.updateOne(
    {_id: 2},
    {$set: {servico: "tosa"}}
)

// PROJECTION
db.pets.find({}, {_id: 0, nome: 1, tipo: 1, idade: 1, raca: 1})
db.pedidos.find({}, {_id: 0, servico: 1, valor: 1, status: 1})

// AGGREGATE
db.pedidos.aggregate(
    [
        {$group: {_id: "$servico", countQuantity: {$count: {}}}}
    ]
)
db.pets.aggregate(
    [
        {$group: {_id: "$tipo", countQuantity: {$count: {}}}}
    ]
)

// DELETE
db.pets.deleteOne({_id: 2})
db.pedidos.deleteMany({status: "CANCELADO"})
