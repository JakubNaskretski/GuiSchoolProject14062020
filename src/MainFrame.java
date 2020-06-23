import javax.swing.*;
import java.awt.*;

public class MainFrame {

    JTextField inputField;
    JList jList;
    JScrollPane listScroller;
    String[] testData = {"Test 1", "Test2", "Test3"};


    public MainFrame( String title) {
        JFrame frame = new JFrame(title);
        frame.setLayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

//        frame.setSize(500, 500);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    //Creates and adds to pane UI elements
    public void addComponentsToPane( Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inputField = new JTextField(" test ");

        jList = new JList(testData);
        jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        jList.setVisibleRowCount(-1);
        listScroller = new JScrollPane(jList);


        c.fill = GridBagConstraints.VERTICAL;
//        c.gridwidth = 1;
        c.gridwidth = 3;
        c.gridy = 0;

        pane.add(inputField, c);

//        c.gridwidth = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridy = 1;
//        c.gridwidth = 3;
        pane.add(listScroller, c);

    }


}
