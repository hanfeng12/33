package invaders.mode_contex;

public class MediumModeStrategy implements ModeStrategy{
    @Override
    public String getMode() {
        return "Medium";
    }

    @Override
    public String getModePath() {
        return "src/main/resources/config_medium.json";
    }
}
