package com.example.cst438project1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.cst438project1.DB.AccountDAO;
import com.example.cst438project1.DB.AppDatabase;
import com.example.cst438project1.DB.EnrollDAO;
import com.example.cst438project1.DB.EnrollDatabase;
import com.example.cst438project1.DB.EnrollLog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EnrollTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.cst438project1", appContext.getPackageName());
    }

    // Variable declarations for tests
    private EnrollDAO enrollDAO;
    private EnrollDatabase db;

    @Before
    public void createDatabase() {
        //Create a room database
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), EnrollDatabase.class)
                .allowMainThreadQueries()
                .build();

        enrollDAO = db.getEnrollDAO();
    }

    @Before
    //Sets up database (aka running the method created above)
    public void setUp() throws Exception {
        createDatabase();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void setEnrollment(){
        //Asserts that user enrolls the course that are accessable
        EnrollLog enrollment = new EnrollLog();
        enrollment.setCourseId(438);
        enrollment.setUserId(17);

        assertTrue(enrollment.getCourseId() == 438 && enrollment.getUserId() == 17);
    }

    @Test
    public void createEnrollment(){
        EnrollLog enrollment = new EnrollLog();
        assertNotNull(enrollment);
    }

}
