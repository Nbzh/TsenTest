package tsen;

public class TsenModel extends org.kevoree.modeling.api.abs.AbstractKModel<TsenUniverse> {

    private org.kevoree.modeling.api.meta.MetaModel _metaModel;

    public TsenModel() {
        super();
        _metaModel = new org.kevoree.modeling.api.abs.AbstractMetaModel("Tsen", -1);
        org.kevoree.modeling.api.meta.MetaClass[] tempMetaClasses = new org.kevoree.modeling.api.meta.MetaClass[4];
                    tempMetaClasses[0] = tsen.meta.MetaRoom.getInstance();
                    tempMetaClasses[2] = tsen.meta.MetaActivity.getInstance();
                    tempMetaClasses[1] = tsen.meta.MetaSensor.getInstance();
                    tempMetaClasses[3] = tsen.meta.MetaUser.getInstance();
                ((org.kevoree.modeling.api.abs.AbstractMetaModel) _metaModel).init(tempMetaClasses);
    }

    @Override
    protected TsenUniverse internal_create(long key) {
        return new TsenUniverse(this,key);
    }

    @Override
    public org.kevoree.modeling.api.meta.MetaModel metaModel() {
        return _metaModel;
    }
}
    
