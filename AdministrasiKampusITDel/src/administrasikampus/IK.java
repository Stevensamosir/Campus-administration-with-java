/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasikampus;

/**
 *
 * @author VERI MARPAUNG
 */
public class IK <T> extends Surat{
    private T nim;

    public IK(T tujuan, T nim, T keperluan, StatusRequest sr, T requester) {
        super.setTujuan(tujuan);
        super.setKeperluan(keperluan);
        super.setSr(sr);
        super.setRequester(requester);
        this.nim = nim;
    }
 
    @Override
    public String toString() {
        return "NIM: " + nim                
                + ", Tujuan: " +super.getTujuan()
                + ", Status: " +super.getSr()
                + ", Request by: " +super.getRequester();
    }
    
    
}
