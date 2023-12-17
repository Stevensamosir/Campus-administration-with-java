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
public class Berita <T>{
    private T topik, deskripsi, tanggal_kirim;

    public Berita(T topik, T deskripsi, T tanggal_kirim) {
        this.topik = topik;
        this.deskripsi = deskripsi;
        this.tanggal_kirim = tanggal_kirim;
    }

    @Override
    public String toString() {
        return "Topik: " + topik 
                + ", Deskripsi: " + deskripsi 
                + ", Tanggal Kirim: " + tanggal_kirim ;
    }
    
    
    
}
