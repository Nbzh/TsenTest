package tsen.meta;

public class MetaRoom extends org.kevoree.modeling.api.abs.AbstractMetaClass {

private static MetaRoom INSTANCE = null;

public static MetaRoom getInstance() {
    if (INSTANCE == null) {
        INSTANCE = new MetaRoom();
    }
    return INSTANCE;
}

public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_NAME = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("name", 5, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());

public static final org.kevoree.modeling.api.meta.MetaReference REF_MEASUREMENT = new org.kevoree.modeling.api.abs.AbstractMetaReference("Measurement", 6, true, false, new org.kevoree.modeling.api.abs.LazyResolver() {@Override public org.kevoree.modeling.api.meta.Meta meta() {return tsen.meta.MetaSensor.getInstance();}}, null,new org.kevoree.modeling.api.abs.LazyResolver() {@Override public org.kevoree.modeling.api.meta.Meta meta() {return tsen.meta.MetaRoom.getInstance();}});
public static final org.kevoree.modeling.api.meta.MetaReference REF_MEMBERS = new org.kevoree.modeling.api.abs.AbstractMetaReference("members", 7, true, false, new org.kevoree.modeling.api.abs.LazyResolver() {@Override public org.kevoree.modeling.api.meta.Meta meta() {return tsen.meta.MetaUser.getInstance();}}, null,new org.kevoree.modeling.api.abs.LazyResolver() {@Override public org.kevoree.modeling.api.meta.Meta meta() {return tsen.meta.MetaRoom.getInstance();}});
public static final org.kevoree.modeling.api.meta.MetaReference REF_LESSON = new org.kevoree.modeling.api.abs.AbstractMetaReference("lesson", 8, true, false, new org.kevoree.modeling.api.abs.LazyResolver() {@Override public org.kevoree.modeling.api.meta.Meta meta() {return tsen.meta.MetaActivity.getInstance();}}, null,new org.kevoree.modeling.api.abs.LazyResolver() {@Override public org.kevoree.modeling.api.meta.Meta meta() {return tsen.meta.MetaRoom.getInstance();}});


    private MetaRoom() {
        super("tsen.Room", 0);
        org.kevoree.modeling.api.meta.MetaAttribute[] temp_attributes = new org.kevoree.modeling.api.meta.MetaAttribute[1];
        temp_attributes[0] = ATT_NAME;
        org.kevoree.modeling.api.meta.MetaReference[] temp_references = new org.kevoree.modeling.api.meta.MetaReference[3];
        temp_references[0] = REF_MEASUREMENT;
        temp_references[1] = REF_MEMBERS;
        temp_references[2] = REF_LESSON;
        org.kevoree.modeling.api.meta.MetaOperation[] temp_operations = new org.kevoree.modeling.api.meta.MetaOperation[0];
        init(temp_attributes, temp_references, temp_operations);
    }

}


