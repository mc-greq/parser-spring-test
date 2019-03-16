package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import parser.Parser;
import parser.ParserConfig;
import parser.actions.ActionDelete;

import javax.swing.*;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ParserConfig.class)
public class ActionDeleteTest {

    @Autowired
    private Parser parser;

    @Test
    public void testIfParserNotNull(){
        assertNotNull(parser);
    }


    @Test
    public void testRemoveFromListModel(){
        ActionDelete actionDelete = new ActionDelete(parser);
        DefaultListModel<File> listModel = new DefaultListModel<>();

        listModel.addElement(new File("testingFile1"));
        File controlFile = new File("testingFile2");
        listModel.addElement(controlFile);
        listModel.addElement(new File("testingFile3"));

        actionDelete.removeFromListModel(listModel, 0, 2);
        assertEquals(controlFile, listModel.get(0));
    }


}