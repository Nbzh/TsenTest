package tsen;

import org.kevoree.modeling.api.meta.MetaModel;

public class TsenUniverse extends org.kevoree.modeling.api.abs.AbstractKUniverse<TsenView, TsenUniverse, TsenModel> {

    protected TsenUniverse(org.kevoree.modeling.api.KModel p_model, long key) {
        super(p_model, key);
    }

    @Override
    protected TsenView internal_create(Long timePoint) {
        return new tsen.impl.TsenViewImpl(timePoint,(org.kevoree.modeling.api.abs.AbstractKUniverse)this);
    }

    @Override
    public MetaModel metaModel() {
        return null;
    }

    @Override
    protected TsenView internal_create(long l) {
        return null;
    }
}

