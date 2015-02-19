package tsen.impl;

public class RoomImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.Room {

    public RoomImpl(tsen.TsenView p_factory, long p_uuid, org.kevoree.modeling.api.time.TimeTree p_timeTree, org.kevoree.modeling.api.meta.MetaClass p_metaClass) {
        super(p_factory, p_uuid, p_timeTree, p_metaClass);
    }

    
    @Override
    public java.lang.String getName() {
        return (java.lang.String) get(tsen.meta.MetaRoom.ATT_NAME);
    }

    @Override
    public tsen.Room setName(java.lang.String p_obj) {
        set(tsen.meta.MetaRoom.ATT_NAME, p_obj);
        return this;
    }
    

    
    @Override
    public tsen.Room addMeasurement(tsen.Sensor p_obj) {
        mutate(org.kevoree.modeling.api.KActionType.ADD, tsen.meta.MetaRoom.REF_MEASUREMENT, p_obj);
        return this;
    }

    @Override
    public tsen.Room removeMeasurement(tsen.Sensor p_obj) {
        mutate(org.kevoree.modeling.api.KActionType.REMOVE, tsen.meta.MetaRoom.REF_MEASUREMENT, p_obj);
        return this;
    }

    @Override
    public void getMeasurement(final org.kevoree.modeling.api.Callback<tsen.Sensor[]> p_callback) {
       this.all(tsen.meta.MetaRoom.REF_MEASUREMENT, new org.kevoree.modeling.api.Callback<org.kevoree.modeling.api.KObject[]>() {
            @Override
            public void on(org.kevoree.modeling.api.KObject[] kObjects) {
                if(p_callback != null){
                    tsen.Sensor[] casted = new tsen.Sensor[kObjects.length];
                    for(int i=0;i<kObjects.length;i++){
                        casted[i] = (tsen.Sensor) kObjects[i];
                    }
                    p_callback.on(casted);
                }
            }
        });
    }

    public org.kevoree.modeling.api.KTask<tsen.Sensor[]> taskGetMeasurement() {
        org.kevoree.modeling.api.abs.AbstractKTaskWrapper<tsen.Sensor[]> task = new org.kevoree.modeling.api.abs.AbstractKTaskWrapper<tsen.Sensor[]>();
        getMeasurement(task.initCallback());
        return task;
    }

    public int sizeOfMeasurement() {
        return size(tsen.meta.MetaRoom.REF_MEASUREMENT);
    }
        
    @Override
    public tsen.Room addMembers(tsen.User p_obj) {
        mutate(org.kevoree.modeling.api.KActionType.ADD, tsen.meta.MetaRoom.REF_MEMBERS, p_obj);
        return this;
    }

    @Override
    public tsen.Room removeMembers(tsen.User p_obj) {
        mutate(org.kevoree.modeling.api.KActionType.REMOVE, tsen.meta.MetaRoom.REF_MEMBERS, p_obj);
        return this;
    }

    @Override
    public void getMembers(final org.kevoree.modeling.api.Callback<tsen.User[]> p_callback) {
       this.all(tsen.meta.MetaRoom.REF_MEMBERS, new org.kevoree.modeling.api.Callback<org.kevoree.modeling.api.KObject[]>() {
            @Override
            public void on(org.kevoree.modeling.api.KObject[] kObjects) {
                if(p_callback != null){
                    tsen.User[] casted = new tsen.User[kObjects.length];
                    for(int i=0;i<kObjects.length;i++){
                        casted[i] = (tsen.User) kObjects[i];
                    }
                    p_callback.on(casted);
                }
            }
        });
    }

    public org.kevoree.modeling.api.KTask<tsen.User[]> taskGetMembers() {
        org.kevoree.modeling.api.abs.AbstractKTaskWrapper<tsen.User[]> task = new org.kevoree.modeling.api.abs.AbstractKTaskWrapper<tsen.User[]>();
        getMembers(task.initCallback());
        return task;
    }

    public int sizeOfMembers() {
        return size(tsen.meta.MetaRoom.REF_MEMBERS);
    }
        
    @Override
    public tsen.Room addLesson(tsen.Activity p_obj) {
        mutate(org.kevoree.modeling.api.KActionType.ADD, tsen.meta.MetaRoom.REF_LESSON, p_obj);
        return this;
    }

    @Override
    public tsen.Room removeLesson(tsen.Activity p_obj) {
        mutate(org.kevoree.modeling.api.KActionType.REMOVE, tsen.meta.MetaRoom.REF_LESSON, p_obj);
        return this;
    }

    @Override
    public void getLesson(final org.kevoree.modeling.api.Callback<tsen.Activity[]> p_callback) {
       this.all(tsen.meta.MetaRoom.REF_LESSON, new org.kevoree.modeling.api.Callback<org.kevoree.modeling.api.KObject[]>() {
            @Override
            public void on(org.kevoree.modeling.api.KObject[] kObjects) {
                if(p_callback != null){
                    tsen.Activity[] casted = new tsen.Activity[kObjects.length];
                    for(int i=0;i<kObjects.length;i++){
                        casted[i] = (tsen.Activity) kObjects[i];
                    }
                    p_callback.on(casted);
                }
            }
        });
    }

    public org.kevoree.modeling.api.KTask<tsen.Activity[]> taskGetLesson() {
        org.kevoree.modeling.api.abs.AbstractKTaskWrapper<tsen.Activity[]> task = new org.kevoree.modeling.api.abs.AbstractKTaskWrapper<tsen.Activity[]>();
        getLesson(task.initCallback());
        return task;
    }

    public int sizeOfLesson() {
        return size(tsen.meta.MetaRoom.REF_LESSON);
    }
    

    @Override
    public tsen.TsenView view() {
        return (tsen.TsenView) super.view();
    }

}

