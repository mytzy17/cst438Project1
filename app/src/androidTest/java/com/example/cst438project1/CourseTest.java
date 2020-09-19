package com.example.cst438project1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.CourseLog;
import com.example.cst438project1.DB.EnrollDAO;
import com.example.cst438project1.DB.EnrollDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourseTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.cst438project1", appContext.getPackageName());
    }

    // Variable declarations for tests
    private CourseDAO mCourseDAO;
    private CourseDatabase db;

    @Before
    public void createDatabase() {
        //Create a room database
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), CourseDatabase.class)
                .allowMainThreadQueries()
                .build();

        mCourseDAO = db.getCourseDAO();
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
    public void createCourse(){
        CourseLog course = new CourseLog();

        assertNotNull(course);
    }

    @Test
    public void setCourse(){
        CourseLog course = new CourseLog();
        course.setCourseID(438);
        course.setDesc("Software Engineering");
        course.setTitle("CST 438");
        course.setInstructor("Drew");

        assertTrue(course.getCourseID() == 438 &&
                course.getDesc() == "Software Engineering" && course.getTitle() == "CST 438"
                && course.getInstructor() == "Drew");
    }
}
