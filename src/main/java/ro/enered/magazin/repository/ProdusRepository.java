package ro.enered.magazin.repository;

import ro.enered.magazin.models.Produs;
import ro.enered.magazin.utils.DBConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdusRepository implements IRepository {
    @Override
    public boolean addItem(Object object) {
        Connection con = DBConnection.getConnection();
        Produs p =(Produs) object;
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO Produs(name,cantitate,pret) VALUES(?,?,?)");
            ps.setString(1, p.name);
            ps.setInt(2,p.cantitate);
            ps.setDouble(3,p.pret);
            ps.executeUpdate();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        Connection con = DBConnection.getConnection();
        try{
            PreparedStatement ps=con.prepareStatement("DELETE FROM Produs WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object viewList() {
        Connection con = DBConnection.getConnection();
        ArrayList<Produs> lista = new ArrayList<>();

        try{
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Produs");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Produs p = new Produs();
                p.id=rs.getInt(1);
                p.name=rs.getString(2);
                p.cantitate=rs.getInt(3);
                p.pret=rs.getDouble(4);
                lista.add(p);

            }
        return lista;

        }
        catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }


    @Override
    public boolean update(Object object) {
        Connection con = DBConnection.getConnection();
        Produs p = (Produs) object;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Produs SET name=?,cantitate=?,pret=? WHERE id=?");
            ps.setString(1, p.name);
            ps.setDouble(2, p.cantitate);
            ps.setDouble(3, p.pret);
            ps.setInt(4, p.id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object getByNumericalColumnOrAll(String columnName, int value){
        ArrayList<Produs> lista = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Produs WHERE "+columnName+"=?");
            if(value ==-1&& columnName.equals("getALL"))
                ps  = con.prepareStatement("SELECT * FROM Produs");
            else  ps.setInt(2,value);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produs p = new Produs();
                p.id = rs.getInt(1);
                p.name = rs.getString(2);
                p.cantitate = rs.getInt(3);
                p.pret = rs.getDouble(4);
                lista.add(p);

            }

            if(lista.size()==1)
                return lista.get(0);
            else return lista;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    return null;
    }

}
