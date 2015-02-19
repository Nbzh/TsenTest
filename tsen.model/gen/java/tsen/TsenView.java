package tsen;

public interface TsenView extends org.kevoree.modeling.api.KView {

    public tsen.Room createRoom();
    public tsen.Activity createActivity();
    public tsen.Sensor createSensor();
    public tsen.User createUser();

    @Override
    public tsen.TsenUniverse universe();

}

