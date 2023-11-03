package invaders.mode_contex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModeContex {
    private static final Map<String, String> videoMap = new HashMap<>();

    public ModeContex(List<ModeStrategy> modeStrategies) {
        modeStrategies.forEach(strategy -> videoMap.put(strategy.getMode(), strategy.getModePath()));
    }

    public String getModePath(String modeType){
        String modePath = videoMap.get(modeType);
        if (modePath==null) {
            throw new RuntimeException("modeType inValid!");
        }
        return modePath;
    }

}
