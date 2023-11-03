package invaders.mode_contex;

public class EasyModeStrategy implements ModeStrategy{
    @Override
    public String getMode() {
        return "Easy";
    }

    @Override
    public String getModePath() {
        return "src/main/resources/config_easy.json";
    }
}
