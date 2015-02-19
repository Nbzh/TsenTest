package tsen.meta;

public class MetaActivity extends org.kevoree.modeling.api.abs.AbstractMetaClass {

private static MetaActivity INSTANCE = null;

public static MetaActivity getInstance() {
    if (INSTANCE == null) {
        INSTANCE = new MetaActivity();
    }
    return INSTANCE;
}

public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_HOUR = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("hour", 5, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_TARGETTEMPERATURE = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("targetTemperature", 6, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.DOUBLE, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());



    private MetaActivity() {
        super("tsen.Activity", 2);
        org.kevoree.modeling.api.meta.MetaAttribute[] temp_attributes = new org.kevoree.modeling.api.meta.MetaAttribute[2];
        temp_attributes[0] = ATT_HOUR;
        temp_attributes[1] = ATT_TARGETTEMPERATURE;
        org.kevoree.modeling.api.meta.MetaReference[] temp_references = new org.kevoree.modeling.api.meta.MetaReference[0];
        org.kevoree.modeling.api.meta.MetaOperation[] temp_operations = new org.kevoree.modeling.api.meta.MetaOperation[0];
        init(temp_attributes, temp_references, temp_operations);
    }

}


