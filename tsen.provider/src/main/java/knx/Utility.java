package knx;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import tuwien.auto.calimero.KNXListener;
import tuwien.auto.calimero.exception.KNXException;
import tuwien.auto.calimero.knxnetip.Discoverer;
import tuwien.auto.calimero.knxnetip.servicetype.SearchResponse;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


public class Utility {

   public static KNXNetworkLinkIP openKnxConnection (InetAddress destination){

        KNXNetworkLinkIP netLinkIp = null;
        try {

            /*InetAddress source = InetAddress.getByName(Reference.HOST_ADDRESS);
            InetSocketAddress socketSource = new InetSocketAddress(source,8060);
            System.out.println("address ip local :" + source.toString() + " on port 8060 ");


            InetSocketAddress socketDestination = new InetSocketAddress(destination,Reference.KNX_PORT);
            System.out.println("addresse ip maquette " +socketDestination.toString() +  " on port " + Reference.KNX_PORT);

            netLinkIp = new KNXNetworkLinkIP(KNXNetworkLinkIP.TUNNEL,socketSource,socketDestination,false, new TPSettings(false));*/

            InetSocketAddress local = new InetSocketAddress(InetAddress.getLocalHost(), 0);
            InetSocketAddress remote = new InetSocketAddress(Reference.KNX_ADDRESS, Reference.KNX_PORT);
            netLinkIp = new KNXNetworkLinkIP(KNXNetworkLinkIP.TUNNEL, local, remote, false, TPSettings.TP1);
        } catch (KNXException e) {
            System.out.println("KNX exception");
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host connection");
            e.printStackTrace();
        }


        return netLinkIp;
    }

    public static JsonNode importGroup(){

       ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        StringBuilder AllConf = new StringBuilder();

        try {

            File groupConfiguration = new File("tsen.provider/src/main/resources/knxGroup.txt");
            InputStream read = new FileInputStream(groupConfiguration);
            InputStreamReader lecture = new InputStreamReader(read);
            BufferedReader br = new BufferedReader(lecture);
            String line ;
            while((line=br.readLine())!=null){
                AllConf.append(line);
            }
            br.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            node = mapper.readTree(AllConf.toString());
        }catch (Exception e){
            System.out.println("Could not import KNXGroup");
            node =  null;
        }
        return node;
    }

}
