package paint;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class About
        extends JFrame
{

    private JPanel contentPane;

    public About()
    {
        setTitle("About");
        setBounds(100, 100, 450, 300);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JEditorPane About = new JEditorPane();
        About.setEditable(false);
        About.setText("About Application:\r\nDesign by Barghi");
        contentPane.add(About, BorderLayout.CENTER);
    }
}
