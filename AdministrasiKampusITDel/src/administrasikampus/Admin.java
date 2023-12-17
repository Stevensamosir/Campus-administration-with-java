/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrasikampus;

/**
 *
 * @author ITD_Stu
 */
public class Admin<T> extends User implements BerhasilMasukInterface,GagalMasukInterface {

    public Admin(T username, T password) {
        super.setUsername(username);
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return "Username: " + super.getUsername()
                + ", Password : " + super.getPassword();
    }

    @Override
    public void BerhasilMasuk() {
        System.out.println(">>>Anda Berhasil masuk");

    }
    
    @Override
    public void GagalMasuk(){
        System.out.println("Ups! Gagal Masuk");
    }
}
