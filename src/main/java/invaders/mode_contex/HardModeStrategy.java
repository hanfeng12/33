package invaders.mode_contex;

public class HardModeStrategy implements ModeStrategy{
    @Override
    public String getMode() {
        return "Hard";
    }

    @Override
    public String getModePath() {
        return "src/main/resources/config_hard.json";
    }
}
