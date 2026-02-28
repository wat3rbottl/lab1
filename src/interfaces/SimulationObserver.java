package interfaces;
import view.RenderItem;
import java.util.List;

public interface SimulationObserver {
    void onTick(List<RenderItem> items);
}
