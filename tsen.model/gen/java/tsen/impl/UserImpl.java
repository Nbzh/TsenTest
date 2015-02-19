package tsen.impl;

public class UserImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.User {

    public UserImpl(tsen.TsenView p_factory, long p_uuid, org.kevoree.modeling.api.time.TimeTree p_timeTree, org.kevoree.modeling.api.meta.MetaClass p_metaClass) {
        super(p_factory, p_uuid, p_timeTree, p_metaClass);
    }

    
    @Override
    public java.lang.Double getTargetTemp() {
        return (java.lang.Double) get(tsen.meta.MetaUser.ATT_TARGETTEMP);
    }

    @Override
    public tsen.User setTargetTemp(java.lang.Double p_obj) {
        set(tsen.meta.MetaUser.ATT_TARGETTEMP, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getSurname() {
        return (java.lang.String) get(tsen.meta.MetaUser.ATT_SURNAME);
    }

    @Override
    public tsen.User setSurname(java.lang.String p_obj) {
        set(tsen.meta.MetaUser.ATT_SURNAME, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getName() {
        return (java.lang.String) get(tsen.meta.MetaUser.ATT_NAME);
    }

    @Override
    public tsen.User setName(java.lang.String p_obj) {
        set(tsen.meta.MetaUser.ATT_NAME, p_obj);
        return this;
    }
        
    @Override
    public java.lang.String getId() {
        return (java.lang.String) get(tsen.meta.MetaUser.ATT_ID);
    }

    @Override
    public tsen.User setId(java.lang.String p_obj) {
        set(tsen.meta.MetaUser.ATT_ID, p_obj);
        return this;
    }
    



    @Override
    public tsen.TsenView view() {
        return (tsen.TsenView) super.view();
    }

}

