package ro.enered.magazin.models;

public class UserClient {
     public int id;
     public String nume;
     public String password;
     public String email;
     public String oras;
     public int varsta;
     public String sex;
     public String adresa;


     @Override
     public String toString() {
          return "UserClient{" +
                  "id=" + id +
                  ", nume='" + nume + '\'' +
                  ", password='" + password + '\'' +
                  ", email='" + email + '\'' +
                  ", oras='" + oras + '\'' +
                  ", varsta=" + varsta +
                  ", sex='" + sex + '\'' +
                  ", adresa='" + adresa + '\'' +

                  '}';
     }
}
