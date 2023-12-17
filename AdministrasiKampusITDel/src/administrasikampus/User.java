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
public abstract class User <T>{
    private T username, password;

    public T getUsername() {
        return username;
    }

    public T getPassword() {
        return password;
    }

    public void setUsername(T username) {
        this.username = username;
    }

    public void setPassword(T password) {
        this.password = password;
    }

    
}
