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
public class Saran <T>{
    private T topik, saran, tanggal;

    public Saran(T topik, T saran, T tanggal) {
        this.topik = topik;
        this.saran = saran;
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Topik: " + topik 
                + ", Saran: " + saran 
                + ", Tanggal: " + tanggal ;
    }
}
