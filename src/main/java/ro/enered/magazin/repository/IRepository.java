package ro.enered.magazin.repository;

public interface IRepository {
    public boolean addItem(Object object);
    public boolean deleteItem(int id);


    public boolean addUser(Object object);

    public getById(int id);
    public Object getByStringColumn(String columnName, String value);

    //cu getByNumericalColumn putem sa scoatem orice produs/comanda din tabel
    //de exemplu daca apelam getByNumericalColumn("id", 10) in tabelul produse
    //"id" fiind coloana id, si 10 - valoare, practic getByID, doar ca mai flexibil
    //o sa afiseze, daca exista, {"id"=10,name="numeledintabel",cantitate="...",pret="..."}
    //sau getByNumericalColumn("pret", 100) o sa afiseze toate produsele cu pretul 100 din tabel
    //in loc sa facem o functie de fiecare data cand vrem ceva din tabel, facem una care le face pe toate
}
}
