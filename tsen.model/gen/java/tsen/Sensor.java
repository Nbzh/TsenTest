package tsen;

public interface Sensor extends org.kevoree.modeling.api.KObject {

    public java.lang.String getGroupAddress();
    public tsen.Sensor setGroupAddress(java.lang.String p_obj);
    public java.lang.String getSensorType();
    public tsen.Sensor setSensorType(java.lang.String p_obj);
    public java.lang.String getAssociatedDPT();
    public tsen.Sensor setAssociatedDPT(java.lang.String p_obj);
    public java.lang.String getScale();
    public tsen.Sensor setScale(java.lang.String p_obj);
    public java.lang.String getValue();
    public tsen.Sensor setValue(java.lang.String p_obj);
    public java.lang.String getSensorId();
    public tsen.Sensor setSensorId(java.lang.String p_obj);



    @Override
    public tsen.TsenView view();

}

