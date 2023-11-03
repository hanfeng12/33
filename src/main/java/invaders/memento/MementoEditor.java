package invaders.memento;

import invaders.engine.GameEngine;

public class MementoEditor {
    private GameEngine gameEngine;

    public void setContent(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public Memento createMemento() {
        return new Memento(this.gameEngine);
    }

    public void restoreMemento(Memento memento) {
        memento.restore(this.gameEngine);
    }

}
