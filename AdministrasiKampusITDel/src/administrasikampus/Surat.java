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
public abstract class Surat <T>{
    private T tujuan, requester;
    private StatusRequest sr;
    private T keperluan ; 

    public T getTujuan() {
        return tujuan;
    }
    
    public T getKeperluan() {
        return keperluan;
    }

    public void setTujuan(T tujuan) {
        this.tujuan = tujuan;
    }
    
    public void setKeperluan(T keperluan) {
        this.keperluan = keperluan;
    }

    public T getRequester() {
        return requester;
    }

    public void setRequester(T requester) {
        this.requester = requester;
    }

    public StatusRequest getSr() {
        return sr;
    }

    public void setSr(StatusRequest sr) {
        this.sr = sr;
    }
    
    
}
