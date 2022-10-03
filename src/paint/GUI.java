package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GUI
        extends JFrame
{

    public static String selectShap = "";
    public static Color selectColor = Color.black;
    public static ArrayList<Paint> paint = new ArrayList<Paint>();
    private JPanel contentPane;
    public static GUI frame;

    public static void main(String[] args)
    {
        try
        {
            frame = new GUI();
            frame.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public GUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Paint - Barghi");
        setSize(1000, 600);
        setMinimumSize(getSize());
        /*
         * Creare meniu
         */
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);
        /*
         * Fila noua
         */
        JMenuItem mntmNew = new JMenuItem("New");
        mntmNew.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "";
                OpenFile.image = null;
                paint.clear();
                repaint();
            }
        });
        mnMenu.add(mntmNew);
        /*
         * Deschide fereastra
         */
        JMenuItem mntmOpen = new JMenuItem("Open");
        mntmOpen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                selectShap = "Open";
                try
                {
                    GUI.paint.clear();
                    new OpenFile();
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        });
        mnMenu.add(mntmOpen);
        /*
         * Salveaza desen
         */
        JMenuItem mntmNew_1 = new JMenuItem("Save");
        mntmNew_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Save";
                new SaveFile();
            }
        });
        mnMenu.add(mntmNew_1);
        /*
         * Inchide aplicatia
         */
        JMenuItem mntmNew_2 = new JMenuItem("Exit");
        mntmNew_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Exit";
                System.exit(0);
            }
        });
        mnMenu.add(mntmNew_2);
        /*
         * Help
         */
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        /*
         * Despre
         */
        Panel pnlabout = new Panel();
        pnlabout.setVisible(false);
        JMenu mnAbout = new JMenu("About");
        mnAbout.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                new About();
            }
        });
        menuBar.add(mnAbout);
        /*
         * Fereastra pentru desen
         */
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.setBackground(Color.white);
        contentPane.add(panel, BorderLayout.NORTH);
        /*
         * Buton Punct
         */
        JButton btnPoint = new JButton("Punct");
        btnPoint.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Point";
            }
        });
        panel.add(btnPoint);
        /*
         * Buton Linie
         */
        JButton btnLine = new JButton("Linie");
        btnLine.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectShap = "Line";
            }
        });
        panel.add(btnLine);
        /*
         * Buton Dreptunghi
         */
        JButton btnRect = new JButton("Dreptunghi");
        btnRect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Rectangle";
            }
        });
        panel.add(btnRect);
        /*
         * Buton Oval
         */
        JButton btnOval = new JButton("Oval");
        btnOval.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectShap = "Oval";
            }
        });
        panel.add(btnOval);
        /*
         * Buton Patrat
         */
        JButton btnSquare = new JButton("Patrat");
        btnSquare.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Square";
            }
        });
        panel.add(btnSquare);
        /*
         * Buton Triunghi
         */
        JButton btnTri = new JButton("Triunghi");
        btnTri.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectShap = "Triangle";
            }
        });
        panel.add(btnTri);
        /*
         * Buton Cerc
         */
        JButton btnCir = new JButton("Cerc");
        btnCir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Circle";
            }
        });
        panel.add(btnCir);

        /*
         * Buton umplere figura
         */
        JButton btnFill = new JButton("Culoare umplere");
        btnFill.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectShap = "fill";
            }
        });
        panel.add(btnFill);
        /*
         * Buton alegere culoare
         */
        JButton btnChooseColor = new JButton("Alege culoare");
        btnChooseColor.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                //selectShap = "ChooseColor";
                new AlegeCuloare();
            }
        });
        panel.add(btnChooseColor);
        /*
         * Buton pt miscarea figurii
         */
        JButton btnMove = new JButton("Move");
        btnMove.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "move";
            }
        });
        panel.add(btnMove);
        /*
         * Buton pt stergerea figurii
         */
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectShap = "Delete";
            }
        });
        panel.add(btnDelete);
        /*
         * Panel culori
         */
        JPanel pnlColor = new JPanel();
        pnlColor.setBackground(Color.white);
        pnlColor.setSize(20, getHeight());
        contentPane.add(pnlColor, BorderLayout.SOUTH);
        /*
         * Buton culoare
         */
        Dimension SizeColorBox = new Dimension(20, 20);
        JButton btnC_Red = new JButton();
        btnC_Red.setPreferredSize(SizeColorBox);
        btnC_Red.setBackground(Color.red);
        btnC_Red.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.red;
            }
        });
        pnlColor.add(btnC_Red);
        /*
         * Buton culoare
         */
        JButton btnC_Blue = new JButton();
        btnC_Blue.setPreferredSize(SizeColorBox);
        btnC_Blue.setBackground(Color.blue);
        btnC_Blue.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.blue;
            }
        });
        pnlColor.add(btnC_Blue);
        /*
         * Buton culoare verde
         */
        JButton btnC_Green = new JButton();
        btnC_Green.setPreferredSize(SizeColorBox);
        btnC_Green.setBackground(Color.green);
        btnC_Green.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.green;
            }
        });
        pnlColor.add(btnC_Green);
        /*
         * Buton culoare cyan
         */
        JButton btnC_Cyan = new JButton();
        btnC_Cyan.setPreferredSize(SizeColorBox);
        btnC_Cyan.setBackground(Color.cyan);
        btnC_Cyan.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.cyan;
            }
        });
        pnlColor.add(btnC_Cyan);
        /*
         * Buton culoare dark gray
         */
        JButton btnC_DarkGray = new JButton();
        btnC_DarkGray.setPreferredSize(SizeColorBox);
        btnC_DarkGray.setBackground(Color.darkGray);
        btnC_DarkGray.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.darkGray;
            }
        });
        pnlColor.add(btnC_DarkGray);
        /*
         * Buton culoare orange
         */
        JButton btnC_Orange = new JButton();
        btnC_Orange.setPreferredSize(SizeColorBox);
        btnC_Orange.setBackground(Color.orange);
        btnC_Orange.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.orange;
            }
        });
        pnlColor.add(btnC_Orange);
        /*
         * Buton culoare pink
         */
        JButton btnC_Pink = new JButton();
        btnC_Pink.setPreferredSize(SizeColorBox);
        btnC_Pink.setBackground(Color.pink);
        btnC_Pink.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.pink;
            }
        });
        pnlColor.add(btnC_Pink);
        /*
         * Buton culoare lightGray
         */
        JButton btnC_LightGray = new JButton();
        btnC_LightGray.setPreferredSize(SizeColorBox);
        btnC_LightGray.setBackground(Color.lightGray);
        btnC_LightGray.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectColor = Color.lightGray;
            }
        });
        pnlColor.add(btnC_LightGray);
        contentPane.add(new Paint_App(), BorderLayout.CENTER);
        validate();
    }
}
