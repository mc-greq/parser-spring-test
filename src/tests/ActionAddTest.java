package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import parser.Parser;
import parser.ParserConfig;
import parser.actions.ActionAdd;

import javax.swing.*;
import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ParserConfig.class)
public class ActionAddTest {

    @Autowired
    private Parser parser;

    @Test
    public void testIfParserNotNull(){
        assertNotNull(parser);
    }

    @Test
    public void testAddFilesToListModel(){
        ActionAdd actionAdd = new ActionAdd(parser);
        DefaultListModel<File> listModel = new DefaultListModel<>();
        File[] files = {new File("testingFile"), new File("testingFile")};
        actionAdd.addFilesToListModel(files, listModel);
        assertEquals(1, listModel.getSize());
    }
}
