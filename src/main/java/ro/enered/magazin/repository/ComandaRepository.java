package ro.enered.magazin.repository;

import ro.enered.magazin.models.Comanda;
import ro.enered.magazin.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComandaRepository {


    @Override
    public boolean create(Object object) {
        Connection con = DBConnection.getConnection();
        Comanda c = (Comanda) object;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Comanda(id_user,id_produs,status,cantitate) VALUES(?,?,?,?)");
            ps.setInt(1, c.idUser);
            ps.setInt(2, c.idProdus);
            ps.setInt(3, 0);
            ps.setInt(4, c.cantitate);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Comanda WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Object object) {
        Connection con = DBConnection.getConnection();
        Comanda c = (Comanda) object;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Comanda SET id_user=?,id_produs=?,status=?,cantitate=? WHERE id=?");

            ps.setInt(1, c.idUser);
            ps.setDouble(2, c.idProdus);
            ps.setInt(3, c.status);
            ps.setInt(4, c.cantitate);
            ps.setInt(5, c.id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object getByNumericalColumnOrAll(String columnName, int value){
        ArrayList<Comanda> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Comanda WHERE " +columnName+"=?");
            //daca value=-1 inseamna ca vreau toate objects din tabel si nu doar un object in functie de id/
            if(value ==-1 && columnName.equals("getAll"))
                ps = con.prepareStatement("SELECT * FROM Comanda");
             else ps.setInt(1,value);

            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                Comanda c = new Comanda();
                c.id = rs.getInt(1);
                c.idUser = rs.getInt(2);
                c.idComanda = rs.getInt(3);
                c.status = rs.getInt(4);
                c.cantitate = rs.getInt(5);
                list.add(c);
            }

            //in cazul in care avem doar un element in lista
            //afisam acel Object, si nu un arraylist
            if(list.size()==1)
                return list.get(0);
            else return list;


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }
}
