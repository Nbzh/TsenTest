package fr.esir.knx;

import tuwien.auto.calimero.exception.KNXException;

/**
 * Created by Nicolas on 19/02/2015.
 */
public class runTimeTestKnx {
    public static void main(String[] args){
        CaliConnection cc = new CaliConnection();
        cc.connectToEIBD();
        try {
            cc.readKnxData();
        } catch (KNXException e) {
            e.printStackTrace();
        }
        cc.CloseConnection();
    }
}
