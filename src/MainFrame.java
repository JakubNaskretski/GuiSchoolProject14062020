import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    JTextField inputField;
    JList jList;
    JScrollPane listScroller;
    CountryListModel countryListModel  = new CountryListModel();


    public MainFrame( String title) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane();

        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        //Display the window.
        pack();
        setVisible(true);
    }

    //Creates and adds to pane UI elements
    public void addComponentsToPane() {

        // Settign layout and creating JList

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inputField = new JTextField("");

        jList = new JList(countryListModel);
        jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList.setLayoutOrientation(JList.VERTICAL);
        jList.setSelectionBackground(Color.YELLOW);
        jList.setSelectionForeground(Color.RED);
        listScroller = new JScrollPane(jList);



        c.gridy = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 0;
        add(inputField, c);

        c.gridy = 1;
        add(listScroller, c);


        //        Event listener for input field
        Action inputAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                countryListModel.addCountry(inputField.getText());
                inputField.setText("");
                jList.updateUI();
            }
        };


        inputField.addActionListener(inputAction);


        jList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    try{
                        countryListModel.removeCountry(list.locationToIndex(evt.getPoint()));
                        jList.updateUI();
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("No element choosen");}
                } else if (evt.getClickCount() == 1) {
                    try{
                        System.out.println(jList.getSelectedValuesList());
                        jList.updateUI();
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("No element choosen");}
                }

            }
        });

    }




}
