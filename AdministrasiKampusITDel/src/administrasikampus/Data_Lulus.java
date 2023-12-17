/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasikampus;

/**
 *
 * @author VERI MARPAUNG
 */
public class Data_Lulus <T> extends Surat{
    private T nim, nama, program_studi;

    public Data_Lulus(T nim, T nama, T program_studi, StatusRequest sr, T requester) {
        super.setSr(sr);
        super.setRequester(requester);
        this.nim = nim;
        this.nama = nama;
        this.program_studi = program_studi;
    }

    @Override
    public String toString() {
        return "Nim: " + nim 
                + ", Nama: " + nama 
                + ", Program Studi:" + program_studi 
                + ", Status: " + super.getSr()
                + ", Request by: " + super.getRequester();
    }
}
