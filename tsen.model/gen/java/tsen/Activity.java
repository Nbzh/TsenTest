package tsen;

public interface Activity extends org.kevoree.modeling.api.KObject {

    public java.lang.String getHour();
    public tsen.Activity setHour(java.lang.String p_obj);
    public java.lang.Double getTargetTemperature();
    public tsen.Activity setTargetTemperature(java.lang.Double p_obj);



    @Override
    public tsen.TsenView view();

}

