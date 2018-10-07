/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awrnndfinalproject;

/**
 *
 * @author Alec
 */
public interface Chips extends java.io.Serializable {
    void setChips(int chips);
    void addChips();
    void removeChips();
    String getChips();
    int getChipsAsInt();
}
