package ro.enered.magazin.repository;

import ro.enered.magazin.models.UserOperator;
import ro.enered.magazin.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserOperatorRepository implements IRepository {
    @Override
    public boolean addUser(Object object){
        Connection con = DBConnection.getConnection();
        UserOperator uo = (UserOperator) object;
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO Users_operatori(email,password,nume,rol)VALUES(?,?,?,?)");
            ps.setString(1,uo.email);
            ps.setString(2,uo.password);
            ps.setString(3,uo.nume);
            ps.setString(4,uo.rol);
            ps.executeUpdate();
            return true;


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Object getByStringColumn(String columnName, String email){
        ArrayList<UserOperator> listaUO = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Users_operatori WHERE" + columnName +"=?");
            ps.setString(1,email);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UserOperator uc= new UserOperator();
                uc.id = rs.getInt(1);
                uc.email = rs.getString(2);
                uc.password = rs.getString(3);
                uc.nume = rs.getString(4);
                uc.rol = rs.getString(5);
                listaUO.add(uc);

            }
            return listaUO.get(0);

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
}
