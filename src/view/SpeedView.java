package view;
import interfaces.SimulationObserver;
import java.awt.Color;


import javax.swing.*;
import java.util.List;
public class SpeedView extends JPanel implements SimulationObserver {
    private JLabel speedLabel = new JLabel();


    public SpeedView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Color Purple = new Color(128, 0, 128);
        setBackground(Purple);
        
        add(speedLabel);
        speedLabel.setForeground(Color.pink);
        this.setOpaque(true);

    }


    @Override
    public void onTick(List<RenderItem> items) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");

        for (RenderItem item : items) {
            if (!item.imageId().contains("Shop"))
                sb.append(item.name()).append(" : ").append(String.format("%.1f", item.speed())).append("<br>");
        }

        sb.append("</html>");
        speedLabel.setText(sb.toString());


    }

}

