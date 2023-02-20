/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author BUE
 */
public class AdDetail {
    private int AdId;
    private Owner Own;

    public AdDetail(int AdId, Owner Own) {
        this.AdId = AdId;
        this.Own = Own;
    }

    public int getAdId() {
        return AdId;
    }

    public void setAdId(int AdId) {
        this.AdId = AdId;
    }

    public Owner getOwn() {
        return Own;
    }

    public void setOwn(Owner Own) {
        this.Own = Own;
    }
}