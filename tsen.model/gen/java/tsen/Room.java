package tsen;

public interface Room extends org.kevoree.modeling.api.KObject {

    public java.lang.String getName();
    public tsen.Room setName(java.lang.String p_obj);

    public tsen.Room addMeasurement(tsen.Sensor p_obj);
    public tsen.Room removeMeasurement(tsen.Sensor p_obj);
    public void getMeasurement(org.kevoree.modeling.api.Callback<tsen.Sensor[]> p_callback);
    public org.kevoree.modeling.api.KTask<tsen.Sensor[]> taskGetMeasurement();
    public int sizeOfMeasurement();
    public tsen.Room addMembers(tsen.User p_obj);
    public tsen.Room removeMembers(tsen.User p_obj);
    public void getMembers(org.kevoree.modeling.api.Callback<tsen.User[]> p_callback);
    public org.kevoree.modeling.api.KTask<tsen.User[]> taskGetMembers();
    public int sizeOfMembers();
    public tsen.Room addLesson(tsen.Activity p_obj);
    public tsen.Room removeLesson(tsen.Activity p_obj);
    public void getLesson(org.kevoree.modeling.api.Callback<tsen.Activity[]> p_callback);
    public org.kevoree.modeling.api.KTask<tsen.Activity[]> taskGetLesson();
    public int sizeOfLesson();


    @Override
    public tsen.TsenView view();

}

