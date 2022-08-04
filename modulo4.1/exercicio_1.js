db.alunos.insertMany([
    { _id: 0, nome: "Luppi", data_nascimento: new Date("2003-12-08") },
    { _id: 1, nome: "Leonardo", data_nascimento: new Date("2003-09-23") },
    { _id: 2, nome: "Heloisa", data_nascimento: new Date("2005-04-20") }
])

db.alunos.insertOne(
    {
        _id: 3, nome: "Bianca", data_nascimento: new Date("2003-10-28")
    }
)

db.alunos.find(
    {
        _id: {$lt : 2}
    }
)

db.alunos.find({})