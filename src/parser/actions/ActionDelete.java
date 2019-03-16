package parser.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parser.Parser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

@Component
public class ActionDelete extends AbstractAction {

    private Parser parser;

    @Autowired
    public ActionDelete(Parser parser) {
        this.parser = parser;
        ActionEnum action = ActionEnum.DELETE;
        this.putValue(Action.NAME, action.toString());
        this.putValue(Action.SHORT_DESCRIPTION, action.getDesc());
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(action.getKeyStroke()));
        this.putValue(Action.SMALL_ICON, action.getIcon());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] indices = parser.getFilesList().getSelectedIndices();
        removeFromListModel(parser.getListModel(), indices);
    }

    public void removeFromListModel(DefaultListModel listModel, int... indices){
        for(int i = 0; i < indices.length; i++){
            listModel.remove(indices[i] - i);
        }
    }

}
