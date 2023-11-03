package invaders.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<Memento> mementos = new ArrayList<>();

    public boolean isEmpty()
    {
        return this.mementos.isEmpty();
    }
    public void push(Memento memento) {
        mementos.add(memento);
    }

    public Memento pop() {
        int lastIndex = mementos.size() - 1;
        Memento lastMemento = mementos.get(lastIndex);
        mementos.remove(lastIndex);
        return lastMemento;
    }

}
