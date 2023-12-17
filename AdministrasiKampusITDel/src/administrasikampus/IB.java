/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasikampus;

/**
 *
 * @author VERI MARPAUNG
 */
public class IB <T> extends Surat{
    private T nim, alamat_skrg, alamat_tujuan, jumlah;

    public IB(T nim, T alamat_skrg, T alamat_tujuan, T jumlah, StatusRequest sr, T requester) {
        super.setSr(sr);
        super.setRequester(requester);
        this.nim = nim;
        this.alamat_skrg = alamat_skrg;
        this.alamat_tujuan = alamat_tujuan;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "NIM: " + nim                
                + ", Alamat Sekarang: " + alamat_skrg
                + ", Alamat Tujuan: " + alamat_tujuan
                + ", Jumlah: " + jumlah
                + ", Status: " +super.getSr()
                + ", Request by: " +super.getRequester();  
    
    }

}
