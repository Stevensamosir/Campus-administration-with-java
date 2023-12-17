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
public class Mahasiswa <T>{
    private T nim, nama, gender, tempat_lahir, tanggal_lahir, gol_darah, agama, program_studi, nama_ayah, nama_ibu;

    public Mahasiswa (T nim, T nama, T gender, T tempat_lahir, T tanggal_lahir, T gol_darah, T agama, T program_studi, T nama_ayah, T nama_ibu) {
        this.nim = nim;
        this.nama = nama;
        this.gender = gender;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.gol_darah = gol_darah;
        this.agama = agama;
        this.program_studi = program_studi;
        this.nama_ayah = nama_ayah;
        this.nama_ibu = nama_ibu;
    }

    @Override
    public String toString() {
        return "nim: " + nim 
                + ", Nama: " + nama 
                + ", Gender: " + gender 
                + ", Tempat Lahir: " + tempat_lahir 
                + ", Tanggal Lahir: " + tanggal_lahir 
                + ", Golongan Darah: " + gol_darah 
                + ", Agama: " + agama 
                + ", program_studi: " + program_studi 
                + ", Nama Ayah: " + nama_ayah 
                + ", Nama Ibu: " + nama_ibu ;
    }
    
    
}