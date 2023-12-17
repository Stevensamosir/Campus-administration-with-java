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
public class Data_Mahasiswa <T> extends Surat{
    private T nim, nama, program_studi;

    public Data_Mahasiswa(T nim, T nama, T program_studi, StatusRequest sr, T requester) {
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
