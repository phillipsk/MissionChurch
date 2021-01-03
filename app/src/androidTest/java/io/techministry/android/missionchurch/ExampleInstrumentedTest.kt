package io.techministry.android.missionchurch

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import io.techministry.android.missionchurch.data.WebsiteHighlight
import io.techministry.android.missionchurch.utilities.ABOUT_US_DATA_FILENAME
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.techministry.android.missionchurch", appContext.packageName)
    }

    @Test
    fun test_JsonReader() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val f = appContext.assets.open(ABOUT_US_DATA_FILENAME)
        val jsonReader = JsonReader(f.reader())
        val whType = object : TypeToken<List<WebsiteHighlight>>() {}.type
        val whList: List<WebsiteHighlight> = Gson().fromJson(jsonReader, whType)
//        assertEquals(jsonReader, JsonReader(f.reader()))
        whList.forEach { t ->
            assertThat(t, instanceOf(WebsiteHighlight::class.java))


        }
    }
}