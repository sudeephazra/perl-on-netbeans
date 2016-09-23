/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.tests;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.netbeans.jellytools.*;
import org.netbeans.jellytools.actions.ActionNoBlock;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.junit.NbTestCase;
import org.openide.util.Exceptions;

/**
 *
 * @author Sudeep
 */
public class PerlOnNetBeansJUnitTest extends NbTestCase {

    public static junit.framework.Test suite() {
        return NbModuleSuite.createConfiguration(PerlOnNetBeansJUnitTest.class).
                gui(true).
                clusters(".*").
                failOnMessage(Level.SEVERE).
                // TODO: Can be enables if the java.lang.ClassCastException: org.netbeans.api.project.ProjectUtils$AnnotateIconProxyProjectInformation
                // cannot be cast to org.netbeans.modules.scala.project.J2SEProject$Info is solved
                //                failOnException(Level.INFO).
                suite();
    }

    public PerlOnNetBeansJUnitTest(String n) {
        super(n);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    @Override
    public void setUp() {
    }

    @After
    @Override
    public void tearDown() {

    }

    //Testing application launch
    @Test
    public void testApplicationLaunch() {
        new ActionNoBlock("Help|About", null).performMenu();
        new NbDialogOperator("About").closeByButton();
    }
    
    //All the files and projects are being created in the default TEMP space
    
    //Test new perl project creation
    @Test
    public void testNewPerlProject() {
        String testProjectName = "TestingPerlProject_" + UUID.randomUUID().toString();
        NewProjectWizardOperator newProjectWizard = NewProjectWizardOperator.invoke();
        newProjectWizard.selectCategory("Perl");
        newProjectWizard.selectProject("Perl Project");
        newProjectWizard.next();
        
        NewJavaProjectNameLocationStepOperator newProjectName = new NewJavaProjectNameLocationStepOperator();
        newProjectName.txtProjectName().typeText(testProjectName);
        
        newProjectWizard.finish();

    }

    //Test new perl file creation
    @Test
    public void testNewPerlFile() {
        String testFileName = "TestingPerlFile_" + UUID.randomUUID().toString();
        NewFileWizardOperator op = NewFileWizardOperator.invoke();
        op.selectCategory("Perl");
        op.selectFileType("New Perl File");
        op.next();

        NewJavaFileNameLocationStepOperator newFileName = new NewJavaFileNameLocationStepOperator();
        newFileName.txtObjectName().typeText(testFileName);

        op.finish();
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    //Test adding a print statement to the file
    
    
    
    
    
    
}
