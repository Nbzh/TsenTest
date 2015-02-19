package tsen.meta;

public class MetaSensor extends org.kevoree.modeling.api.abs.AbstractMetaClass {

private static MetaSensor INSTANCE = null;

public static MetaSensor getInstance() {
    if (INSTANCE == null) {
        INSTANCE = new MetaSensor();
    }
    return INSTANCE;
}

public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_GROUPADDRESS = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("groupAddress", 5, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_SENSORTYPE = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("sensorType", 6, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_ASSOCIATEDDPT = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("associatedDPT", 7, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_SCALE = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("scale", 8, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_VALUE = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("value", 9, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
public static final org.kevoree.modeling.api.meta.MetaAttribute ATT_SENSORID = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("sensorId", 10, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());



    private MetaSensor() {
        super("tsen.Sensor", 1);
        org.kevoree.modeling.api.meta.MetaAttribute[] temp_attributes = new org.kevoree.modeling.api.meta.MetaAttribute[6];
        temp_attributes[0] = ATT_GROUPADDRESS;
        temp_attributes[1] = ATT_SENSORTYPE;
        temp_attributes[2] = ATT_ASSOCIATEDDPT;
        temp_attributes[3] = ATT_SCALE;
        temp_attributes[4] = ATT_VALUE;
        temp_attributes[5] = ATT_SENSORID;
        org.kevoree.modeling.api.meta.MetaReference[] temp_references = new org.kevoree.modeling.api.meta.MetaReference[0];
        org.kevoree.modeling.api.meta.MetaOperation[] temp_operations = new org.kevoree.modeling.api.meta.MetaOperation[0];
        init(temp_attributes, temp_references, temp_operations);
    }

}


