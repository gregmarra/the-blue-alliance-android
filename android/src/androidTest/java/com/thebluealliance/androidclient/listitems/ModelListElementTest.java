package com.thebluealliance.androidclient.listitems;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import android.view.LayoutInflater;
import android.view.View;

import com.facebook.testing.screenshot.Screenshot;
import com.facebook.testing.screenshot.ViewHelpers;
import com.thebluealliance.androidclient.types.ModelType;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ModelListElementTest {

    private static final int WIDTH_DP = 400;

    @Test
    public void testRender() {
        View view = getView("Test Model", "test", ModelType.TEAM);
        ViewHelpers.setupView(view)
                   .setExactWidthDp(WIDTH_DP)
                   .layout();

        Screenshot.snap(view)
                  .record();
    }

    private View getView(String text, String key, ModelType type) {
        ModelListElement element = new ModelListElement(text, key, type);
        Context targetContext = InstrumentationRegistry.getTargetContext();
        LayoutInflater inflater = LayoutInflater.from(targetContext);
        return element.getView(targetContext, inflater, null);
    }

}