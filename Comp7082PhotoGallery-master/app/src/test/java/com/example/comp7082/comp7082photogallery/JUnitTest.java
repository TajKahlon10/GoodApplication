package com.example.comp7082.comp7082photogallery;

import android.os.Environment;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class JUnitTest {
        @Test
        public void testCorrectPicturesPathIndex1() {
                String[] arr = {"abc", "123", "xyz"};
                Pictures_BullitenListActivity m1 = new Pictures_BullitenListActivity();
                m1.setDirectory("as");
                m1.setFileName(arr);
                m1.setCurrentIndex(1);
                assertEquals("as123", m1.getCurrentFilePath());
        }

        @Test
        public void testCorrectPicturesPathIndex2() {
                String[] arr = {"abc", "123", "xyz"};
                Pictures_BullitenListActivity m1 = new Pictures_BullitenListActivity();
                m1.setDirectory("as");
                m1.setFileName(arr);
                m1.setCurrentIndex(2);
                assertEquals("asxyz", m1.getCurrentFilePath());
        }
}