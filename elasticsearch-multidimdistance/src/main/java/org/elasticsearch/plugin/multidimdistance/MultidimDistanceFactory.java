package org.elasticsearch.plugin.multidimdistance;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

import java.util.Map;

public final class MultidimDistanceFactory implements NativeScriptFactory {

    @Override
    public ExecutableScript newScript(@Nullable Map<String, Object> params) {
        return new MultidimDistanceScript(params);
    }

}