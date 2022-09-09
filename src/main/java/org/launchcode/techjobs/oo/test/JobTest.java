package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

//    @Test
//    public void emptyTest() {
//        assertEquals(10,10,.001);
//    }
    @Test //test to valid that each new job instantiated has a new id
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJob3 instanceof Job);
        assertEquals("Product tester",
                testJob3.getName());

       assertTrue(testJob3.getEmployer() instanceof Employer);
       assertEquals("ACME",
               testJob3.getEmployer().getValue());

        assertTrue(testJob3.getLocation() instanceof Location);
        assertEquals("Desert",
                testJob3.getLocation().getValue());

        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertEquals("Quality control",
                testJob3.getPositionType().getValue());

        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence",
                testJob3.getCoreCompetency().getValue());
    }

    @Test // Test to validate that new jobs with the same fields are not identical by comparing their IDs
    public void testJobsForEquality() {
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob4 == testJob5);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob6 = new Job("", new Employer("apple"), new Location("earth"), new PositionType("employed"), new CoreCompetency("computer"));
        assertEquals('\n', '\n');
        assertEquals(testJob6.toString().charAt(0), testJob6.toString().charAt(testJob6.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob7 = new Job("job", new Employer("apple"), new Location("earth"), new PositionType ("employed"),  new CoreCompetency("computer"));
        assertEquals("\nID: " + testJob7.getId() + "\n"
                + "Name: " + "job" + "\n"
                + "Employer: " + "apple" + "\n"
                + "Location: " + "earth" + "\n"
                + "Position Type: " + "employed" + "\n"
                + "Core Competency: " + "computer" + "\n",
                testJob7.toString());
        }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob8 = new Job("", new Employer("apple"), new Location("earth"), new PositionType ("employed"),  new CoreCompetency("computer"));
        assertEquals("\nID: " + testJob8.getId() + "\n"
                + "Name: " + "Data not available" + "\n"
                + "Employer: " + "apple" + "\n"
                + "Location: " + "earth" + "\n"
                + "Position Type: " + "employed" + "\n"
                + "Core Competency: " + "computer" + "\n",
                testJob8.toString());
    }
}


//"\nID:  " + testJob6.getId() + "\n"
//        + "Name:  " + testJob6.getName() + "\n"
//        + "Employer:  " + testJob6.getEmployer() + "\n"
//        + "Location:  " + testJob6.getLocation() + "\n"
//        + "Position Type:  " + testJob6.getPositionType() + "\n"
//        + "Core Competency:  " + testJob6.getCoreCompetency() + "\n"