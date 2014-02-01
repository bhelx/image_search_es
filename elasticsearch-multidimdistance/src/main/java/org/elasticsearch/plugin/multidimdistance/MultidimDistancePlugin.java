package org.elasticsearch.plugin.multidimdistance;

import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.script.ScriptModule;

public class MultidimDistancePlugin extends AbstractPlugin {
    @Override public String name() {
        return "multidimdistance-plugin";
    }

    @Override public String description() {
        return "multidimdistance Plugin Description";
    }

    public void onModule(final ScriptModule module) {
      module.registerScript("multidimensional-distance", MultidimDistanceFactory.class);
    }
}