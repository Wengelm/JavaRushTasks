package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    private Controller controller;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Controller getController() {
        return controller;
    }

    public void initMenuBar() {}
    public void initEditor() {

        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPane);

        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPane1);

        tabbedPane.setPreferredSize(new Dimension(300,300));

        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);

        Container container = getContentPane();
        container.add(tabbedPane, BorderLayout.CENTER);

    }
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged() {}
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void exit() {controller.exit();}
    public void init() {
        initGui();
        this.addWindowListener(new FrameListener(this));

        this.setVisible(true);
    }
}
