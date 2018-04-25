package ro.enered.magazin.repository;

import ro.enered.magazin.models.UserClient;
import ro.enered.magazin.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserClientRepository implements IRepository{
    @Override
    public boolean addItem(Object object) {
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return false;
    }

    @Override
    public Object viewList() {
        return null;
    }

    @Override
    public boolean addUser(Object object){
        Connection con = DBConnection.getConnection();
        UserClient uc = (UserClient) object;
        try{
            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO Users_Clients(nume,password,email,oras,varsta,sex,adresa)VALUES(?,?,?,?,?,?,?)");
                ps.setString(1,uc.nume);
                ps.setString(2,uc.password);
                ps.setString(3,uc.email);
                ps.setString(4,uc.oras);
                ps.setInt(5,uc.varsta);
                ps.setString(6,uc.sex);
                ps.setString(7,uc.adresa);
                ps.executeUpdate();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    public UserClientRepository(int id) {

    }

    @Override
    public getByStringColumn(String columnName, String email){
        ArrayList<UserClient> listaUserClient = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Users_Clients WHERE" + columnName + "=?");
            ps.setString(1,email);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                UserClient us = new UserClient();
                us.id = rs.getInt(1);
                us.email = rs.getString(2);
                us.password = rs.getString(3);
                us.nume = rs.getString(4);
                us.oras = rs.getString(5);
                us.varsta = rs.getInt(6);
                us.sex = rs.getString(7);
                us.adresa = rs.getString(8);
                listaUserClient.add(us);
            }

            return listaUserClient.get(0);

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;

    }


}
