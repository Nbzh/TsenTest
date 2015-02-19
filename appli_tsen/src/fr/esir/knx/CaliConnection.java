package fr.esir.knx;

import android.util.Log;
import fr.esir.maintasks.MyActivity;
import fr.esir.services.Knx_service;
import knx.Reference;
import knx.Service_knx;
import tuwien.auto.calimero.CloseEvent;
import tuwien.auto.calimero.FrameEvent;
import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXAddress;
import tuwien.auto.calimero.dptxlator.DPTXlator;
import tuwien.auto.calimero.dptxlator.DPTXlator2ByteFloat;
import tuwien.auto.calimero.dptxlator.DPTXlator8BitUnsigned;
import tuwien.auto.calimero.exception.KNXException;
import tuwien.auto.calimero.exception.KNXFormatException;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.event.NetworkLinkListener;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

import java.net.InetSocketAddress;

/**
 * Created by Nicolas on 13/02/2015.
 */
public class CaliConnection {
    private Service_knx sk;
    public CaliConnection(Service_knx sk) {
        this.sk = sk;
    }

    public CaliConnection(){
    }
    /**
     * The object used to interact with the KNX network
     */
    private KNXNetworkLink knxLink = null;

    /**
     * The object used to read and write from the KNX network
     */
    private ProcessCommunicator pc = null;

    private DPTXlator _dpt = null;

    /**
     * A listener class used to capture KNX events
     */
    //private KnxListener listener = null;

    /**
     * Connects to the KNX network though the EIBD server, thus the EIBD server
     * must be up&running first
     *
     * @return TRUE if connection successful
     */
    public boolean connectToEIBD() {

        try {
            InetSocketAddress local = new InetSocketAddress(Reference.HOST_ADDRESS, 8060);
            System.out.println(local);
            InetSocketAddress remote = new InetSocketAddress(Reference.KNX_ADDRESS, Reference.KNX_PORT);
            knxLink = new KNXNetworkLinkIP(KNXNetworkLinkIP.TUNNEL, local, remote, false, TPSettings.TP0);
            pc = new ProcessCommunicatorImpl(knxLink);

            knxLink.addLinkListener(new NetworkLinkListener() {
                @Override
                public void confirmation(FrameEvent frameEvent) {

                }

                @Override
                public void indication(FrameEvent frameEvent) {
                    KNXAddress addDest = ((tuwien.auto.calimero.cemi.CEMILData) frameEvent.getFrame()).getDestination();
                    System.out.println("srcadress " + frameEvent.getSource());
                    System.out.println("targetadress " + addDest);
                    System.out.println("CEMILData " + ((tuwien.auto.calimero.cemi.CEMILData) frameEvent.getFrame()).toString());
                    switch (addDest.toString()) {
                        case "0/0/4": //CO2
                            try {
                                _dpt = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_AIRQUALITY);
                            } catch (KNXFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "0/1/0": //outdoor temperature
                            try {
                                _dpt = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_TEMPERATURE);
                            } catch (KNXFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "0/1/1": //outdoor brightness
                            try {
                                _dpt = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_INTENSITY_OF_LIGHT);
                            } catch (KNXFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "0/0/5": //indoor humidity
                            try {
                               // _dpt = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_HUMIDITY);
                                _dpt = new DPTXlator8BitUnsigned(DPTXlator8BitUnsigned.DPT_PERCENT_U8);
                                _dpt.setData(frameEvent.getFrame().getPayload());
                            } catch (KNXFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "0/1/2": //outdoor humidity
                            try {
                                //_dpt = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_HUMIDITY);
                                _dpt = new DPTXlator8BitUnsigned(DPTXlator8BitUnsigned.DPT_PERCENT_U8);
                            } catch (KNXFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "0/0/3": //indoor temperature
                            try {
                                _dpt = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_TEMPERATURE);
                            } catch (KNXFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    _dpt.setData(frameEvent.getFrame().getPayload());
                    displayData(addDest.toString(), _dpt.getAllValues()[1]);
                }

                @Override
                public void linkClosed(CloseEvent closeEvent) {
                    System.out.println("Connection lost");
                }
            });
            return true;
        } catch (KNXException e) {
            System.out.println("There was a problem trying to create a KNXNetworkLink object or creating a ProcessCommunicator object. More info " + e.getStackTrace());
            return false;
        }

    }

    public String readKnxData() throws KNXException {
        //short value = getPc().readUnsigned(new GroupAddress("0/1/2"),ProcessCommunicator.UNSCALED);
        float value = pc.readFloat(new GroupAddress("0/1/0"));
        Log.i("KNX read",value+"");
        //System.out.println(value);
        return value+"";
    }

    private void displayData(String add, String data) {
        sk.sendDisplayData(add, data);
    }

    public void CloseConnection() {
        if(pc != null)
            pc.detach();
        if(knxLink != null)
            knxLink.close();
    }
}
