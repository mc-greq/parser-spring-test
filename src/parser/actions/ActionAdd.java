package parser.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parser.Parser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

@Component
public class ActionAdd extends AbstractAction {

    private Parser parser;

    @Autowired
    public ActionAdd(Parser parser) {
        this.parser = parser;
        ActionEnum action = ActionEnum.ADD;
        this.putValue(Action.NAME, action.toString());
        this.putValue(Action.SHORT_DESCRIPTION, action.getDesc());
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(action.getKeyStroke()));
        this.putValue(Action.SMALL_ICON, action.getIcon());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = parser.getFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(Parser.jFileChooserFilter);
        fileChooser.setMultiSelectionEnabled(true);

        int tmp = fileChooser.showDialog(parser.getRootPane(), "Dodaj");

        if(tmp == JFileChooser.APPROVE_OPTION){
            File[] files = fileChooser.getSelectedFiles();
            addFilesToListModel(files, parser.getListModel());
        }
    }

    public void addFilesToListModel(File[] files, DefaultListModel<File> listModel){
        for(File file: files){
            if(!listModel.contains(file)){
                listModel.addElement(file);
            }
        }
    }
}
