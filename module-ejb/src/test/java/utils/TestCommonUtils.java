package utils;

import logic.name.generation.Letter;
import org.junit.Test;

public class TestCommonUtils {
    @Test
    public void testConvertObjectToJsonObjectString() {
        System.out.println(CommonUtils.convertListOfObjectsToJson(Letter.getDefaultLetterSettingsList()));
    }
}
