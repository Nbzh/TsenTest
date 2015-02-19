package tsen.impl;

public class SensorImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.Sensor {

    public SensorImpl(tsen.TsenView p_factory, long p_uuid, org.kevoree.modeling.api.time.TimeTree p_timeTree, org.kevoree.modeling.api.meta.MetaClass p_metaClass) {
        super(p_factory, p_uuid, p_timeTree, p_metaClass);
    }

    
    @Override
    public java.lang.String getGroupAddress() {
        return (java.lang.String) get(tsen.meta.MetaSensor.ATT_GROUPADDRESS);
    }

    @Override
    public tsen.Sensor setGroupAddress(java.lang.String p_obj) {
        set(tsen.meta.MetaSensor.ATT_GROUPADDRESS, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getSensorType() {
        return (java.lang.String) get(tsen.meta.MetaSensor.ATT_SENSORTYPE);
    }

    @Override
    public tsen.Sensor setSensorType(java.lang.String p_obj) {
        set(tsen.meta.MetaSensor.ATT_SENSORTYPE, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getAssociatedDPT() {
        return (java.lang.String) get(tsen.meta.MetaSensor.ATT_ASSOCIATEDDPT);
    }

    @Override
    public tsen.Sensor setAssociatedDPT(java.lang.String p_obj) {
        set(tsen.meta.MetaSensor.ATT_ASSOCIATEDDPT, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getScale() {
        return (java.lang.String) get(tsen.meta.MetaSensor.ATT_SCALE);
    }

    @Override
    public tsen.Sensor setScale(java.lang.String p_obj) {
        set(tsen.meta.MetaSensor.ATT_SCALE, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getValue() {
        return (java.lang.String) get(tsen.meta.MetaSensor.ATT_VALUE);
    }

    @Override
    public tsen.Sensor setValue(java.lang.String p_obj) {
        set(tsen.meta.MetaSensor.ATT_VALUE, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getSensorId() {
        return (java.lang.String) get(tsen.meta.MetaSensor.ATT_SENSORID);
    }

    @Override
    public tsen.Sensor setSensorId(java.lang.String p_obj) {
        set(tsen.meta.MetaSensor.ATT_SENSORID, p_obj);
        return this;
    }
    



    @Override
    public tsen.TsenView view() {
        return (tsen.TsenView) super.view();
    }

}

