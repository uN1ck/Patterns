package util.game;

import actionObject.ActionObject;
import util.observers.ActionObjectObserver;
import util.view.NullView;
import util.view.ViewBridge;
import util.world.Cell;
import util.world.World;
import util.world.WorldIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {

    protected static Game instance;
    private World world;
    private List<Set<ActionObject>> players;
    private ViewBridge view;
    private ArrayList<ActionObjectObserver> observers;


    protected Game() {
        view = new NullView();
        players = new ArrayList<>();
        world = new World(0, 0);
    }

    /**
     * Статический метод инициализации и доступа к классу игры
     *
     * @return Экземпляр игры
     */
    public static Game instance() {
        if (instance != null)
            return instance;
        else {
            instance = new Game();
            return instance;
        }
    }

    public void setView(ViewBridge view) {
        this.view = view;
    }

    /**
     * Метод построения игры с помощью строителя
     *
     * @param builder строитель игры
     */
    public void buildGame(GameBuilder builder) {
        this.world = builder.getWorld();
        this.players = builder.getPlayers();
        this.observers = builder.getObservers();
    }

    /**
     * Основной метод игры, просчитывает каждую клетку в мире игры и дает выполнить ей ее десйтсвия, т.е. обращается
     * к возможному юниту внутри и дает ему выполнить свои действия, в процессе обхода,
     * по завершении действия очередного юнита запускает следующего.
     * После полного общета всех юнитов начинается обработка полученнй конфигурации системой ввода-вывода {@link #view}
     *
     * @param ticks Количество тиков для общета игры, фактически количество ходов игры, если отрицательно, то обход бесконечен
     */
    public void gameLoop(int ticks) {

        for (int i = 0; i < ticks; i++) {
            nextTick();

        }

    }

    public void nextTick() {
        WorldIterator worldIterator = world.iterator();
        while (worldIterator.hasNext()) {
            Cell current = worldIterator.next();
            current.doActions();
        }
        worldIterator = world.iterator();
        while (worldIterator.hasNext()) {
            Cell current = worldIterator.next();
            view.drawCell(current, worldIterator.getPosition());
        }
    }

    /**
     * Метод удаления уничетоженного объекта
     *
     * @param actionObject уничтоженный объект
     */
    public void removeActionObject(ActionObject actionObject) {
        //TODO: прописать нуичтоженеи объекта
    }
}
