package tsen.impl;

public class TsenViewImpl extends org.kevoree.modeling.api.abs.AbstractKView implements tsen.TsenView {

    public TsenViewImpl(long p_now, org.kevoree.modeling.api.KUniverse p_universe) {
        super(p_now, p_universe);
    }

    @Override
    protected org.kevoree.modeling.api.KObject internalCreate(org.kevoree.modeling.api.meta.MetaClass p_clazz, org.kevoree.modeling.api.time.TimeTree p_timeTree, long p_key) {
        if (p_clazz == null) {
            return null;
        }
        switch (p_clazz.index()) {
            case 0 : return new tsen.impl.RoomImpl(this, p_key, p_timeTree, p_clazz);
            case 2 : return new tsen.impl.ActivityImpl(this, p_key, p_timeTree, p_clazz);
            case 1 : return new tsen.impl.SensorImpl(this, p_key, p_timeTree, p_clazz);
            case 3 : return new tsen.impl.UserImpl(this, p_key, p_timeTree, p_clazz);
            default : return new org.kevoree.modeling.api.reflexive.DynamicKObject(this, p_key, p_timeTree, p_clazz);
        }
    }

    @Override
    public tsen.Room createRoom() {
        return (tsen.Room) this.create(tsen.meta.MetaRoom.getInstance());
    }
    @Override
    public tsen.Activity createActivity() {
        return (tsen.Activity) this.create(tsen.meta.MetaActivity.getInstance());
    }
    @Override
    public tsen.Sensor createSensor() {
        return (tsen.Sensor) this.create(tsen.meta.MetaSensor.getInstance());
    }
    @Override
    public tsen.User createUser() {
        return (tsen.User) this.create(tsen.meta.MetaUser.getInstance());
    }

    @Override
    public tsen.TsenUniverse universe() {
        return (tsen.TsenUniverse) super.universe();
    }

}

