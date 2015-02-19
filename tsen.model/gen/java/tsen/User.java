package tsen;

public interface User extends org.kevoree.modeling.api.KObject {

    public java.lang.Double getTargetTemp();
    public tsen.User setTargetTemp(java.lang.Double p_obj);
    public java.lang.String getSurname();
    public tsen.User setSurname(java.lang.String p_obj);
    public java.lang.String getName();
    public tsen.User setName(java.lang.String p_obj);
    public java.lang.String getId();
    public tsen.User setId(java.lang.String p_obj);



    @Override
    public tsen.TsenView view();

}

