conn = new Mongo();
db = conn.getDB("sample");
db.books.insert({name:"MongoDB"});
