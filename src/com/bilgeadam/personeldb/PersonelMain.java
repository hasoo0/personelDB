package com.bilgeadam.personeldb;

import java.sql.*;


public class PersonelMain {

    public static void main(String[] args) {

        try
        {
            // JCBD Driver`i tanimlama
            Class.forName("org.postgresql.Driver");

            // Connection objesi olusturuyoruz
            Connection conn = DriverManager.getConnection("jdbc:postgresql://Localhost:5432/postgres", "postgres","123456");

            //Statement objesi olusturuyoruz,
            Statement st = conn.createStatement();

            // ResultSet objesine, st tarafindan calistirilan sorgunun sonuclarini at.
            ResultSet rs = st.executeQuery("select no, ad, soyad, maas from personel order by no");


            while (rs.next())
            {
                System.out.println("No:" + rs.getInt("no"));
                System.out.println("Ad:" + rs.getString("ad"));
                System.out.println("Soyad:" + rs.getString("soyad"));
                System.out.println("Maas:"+ rs.getDouble("maas"));
                System.out.println();

            }
            rs.close();

            // veritabaninda isler bitince kaynaklari birak
            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Lutfen JDBC driver jar dosyasini ekleyin!");
        }

        catch (Exception e)
        {
            System.err.println("Hata:" + e.getMessage());
        }


    }
}
