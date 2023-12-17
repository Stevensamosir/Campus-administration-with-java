/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasikampus;

/**
 *
 * @author VERI MARPAUNG
 */
public class KTM <T> extends Surat{
    private T nim;

    public KTM(T tujuan, T nim, StatusRequest sr, T requester) {
        super.setTujuan(tujuan);
        super.setSr(sr);
        super.setRequester(requester);
        this.nim = nim;
    }

    public T getNim() {
        return nim;
    }
    
    @Override
    public String toString() {
        return "NIM: " + nim                
                + ", Alasan: " +super.getTujuan()
                + ", Status: " +super.getSr()
                + ", Request by: " +super.getRequester();
    }
    
}
