package tsen.impl;

public class ActivityImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.Activity {

    public ActivityImpl(tsen.TsenView p_factory, long p_uuid, org.kevoree.modeling.api.time.TimeTree p_timeTree, org.kevoree.modeling.api.meta.MetaClass p_metaClass) {
        super(p_factory, p_uuid, p_timeTree, p_metaClass);
    }

    
    @Override
    public java.lang.String getHour() {
        return (java.lang.String) get(tsen.meta.MetaActivity.ATT_HOUR);
    }

    @Override
    public tsen.Activity setHour(java.lang.String p_obj) {
        set(tsen.meta.MetaActivity.ATT_HOUR, p_obj);
        return this;
    }
        
    @Override
    public java.lang.Double getTargetTemperature() {
        return (java.lang.Double) get(tsen.meta.MetaActivity.ATT_TARGETTEMPERATURE);
    }

    @Override
    public tsen.Activity setTargetTemperature(java.lang.Double p_obj) {
        set(tsen.meta.MetaActivity.ATT_TARGETTEMPERATURE, p_obj);
        return this;
    }
    



    @Override
    public tsen.TsenView view() {
        return (tsen.TsenView) super.view();
    }

}

