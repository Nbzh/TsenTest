package tsen.meta;

public class MetaUser extends org.kevoree.modeling.api.abs.AbstractMetaClass {

private static MetaUser INSTANCE = null;

public static MetaUser getInstance() {
    if (INSTANCE == null) {
        INSTANCE = new MetaUser();
    }
    return INSTANCE;
}

public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_TARGETTEMP = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("targetTemp", 5, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.DOUBLE, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_SURNAME = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("surname", 6, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_NAME = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("name", 7, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_ID = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("id", 8, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());



    private MetaUser() {
        super("tsen.User", 3);
        org.kevoree.modeling.api.meta.MetaAttribute[] temp_attributes = new org.kevoree.modeling.api.meta.MetaAttribute[4];
        temp_attributes[0] = ATT_TARGETTEMP;
        temp_attributes[1] = ATT_SURNAME;
        temp_attributes[2] = ATT_NAME;
        temp_attributes[3] = ATT_ID;
        org.kevoree.modeling.api.meta.MetaReference[] temp_references = new org.kevoree.modeling.api.meta.MetaReference[0];
        org.kevoree.modeling.api.meta.MetaOperation[] temp_operations = new org.kevoree.modeling.api.meta.MetaOperation[0];
        init(temp_attributes, temp_references, temp_operations);
    }

}


